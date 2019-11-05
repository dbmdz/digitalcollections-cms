package de.digitalcollections.cudami.server.controller.identifiable.entity;

import de.digitalcollections.cudami.server.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.server.business.api.service.identifiable.entity.CollectionService;
import de.digitalcollections.model.api.identifiable.entity.Collection;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import de.digitalcollections.model.api.paging.enums.NullHandling;
import de.digitalcollections.model.impl.paging.OrderImpl;
import de.digitalcollections.model.impl.paging.PageRequestImpl;
import de.digitalcollections.model.impl.paging.SortingImpl;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "The collection controller", name = "Collection controller")
public class CollectionController {

  private CollectionService collectionService;

  @Autowired
  public CollectionController(CollectionService collectionService) {
    this.collectionService = collectionService;
  }

  @ApiMethod(description = "Get all collections")
  @RequestMapping(
      value = {"/latest/collections", "/v2/collections"},
      produces = "application/json",
      method = RequestMethod.GET)
  @ApiResponseObject
  public PageResponse<Collection> findAll(
      @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
      @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
      @RequestParam(name = "sortField", required = false, defaultValue = "uuid") String sortField,
      @RequestParam(name = "sortDirection", required = false, defaultValue = "ASC")
          Direction sortDirection,
      @RequestParam(name = "nullHandling", required = false, defaultValue = "NATIVE")
          NullHandling nullHandling) {
    OrderImpl order = new OrderImpl(sortDirection, sortField, nullHandling);
    Sorting sorting = new SortingImpl(order);
    PageRequest pageRequest = new PageRequestImpl(pageNumber, pageSize, sorting);
    return collectionService.find(pageRequest);
  }

  // Test-URL: http://localhost:9000/latest/collections/599a120c-2dd5-11e8-b467-0ed5f89f718b
  @ApiMethod(
      description =
          "Get an collection as JSON or XML, depending on extension or <tt>format</tt> request parameter or accept header")
  @RequestMapping(
      value = {"/latest/collections/{uuid}", "/v2/collections/{uuid}"},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      method = RequestMethod.GET)
  @ApiResponseObject
  public ResponseEntity<Collection> getWebpage(
      @ApiPathParam(
              description =
                  "UUID of the collection, e.g. <tt>599a120c-2dd5-11e8-b467-0ed5f89f718b</tt>")
          @PathVariable("uuid")
          UUID uuid,
      @ApiQueryParam(
              name = "pLocale",
              description =
                  "Desired locale, e.g. <tt>de_DE</tt>. If unset, contents in all languages will be returned")
          @RequestParam(name = "pLocale", required = false)
          Locale pLocale)
      throws IdentifiableServiceException {

    Collection collection;
    if (pLocale == null) {
      collection = collectionService.get(uuid);
    } else {
      collection = collectionService.get(uuid, pLocale);
    }
    return new ResponseEntity<>(collection, HttpStatus.OK);
  }

  @ApiMethod(description = "Save a newly created collection")
  @RequestMapping(
      value = {"/latest/collections", "/v2/collections"},
      produces = "application/json",
      method = RequestMethod.POST)
  @ApiResponseObject
  public Collection save(@RequestBody Collection collection, BindingResult errors)
      throws IdentifiableServiceException {
    return collectionService.save(collection);
  }

  @ApiMethod(description = "Update an collection")
  @RequestMapping(
      value = {"/latest/collections/{uuid}", "/v2/collections/{uuid}"},
      produces = "application/json",
      method = RequestMethod.PUT)
  @ApiResponseObject
  public Collection update(
      @PathVariable UUID uuid, @RequestBody Collection collection, BindingResult errors)
      throws IdentifiableServiceException {
    assert Objects.equals(uuid, collection.getUuid());
    return collectionService.update(collection);
  }
}