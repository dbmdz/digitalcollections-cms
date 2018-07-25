package de.digitalcollections.cudami.server.controller.identifiable.entity;

import de.digitalcollections.cudami.server.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.server.business.api.service.identifiable.entity.WebsiteService;
import de.digitalcollections.model.api.identifiable.entity.Website;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import de.digitalcollections.model.api.paging.enums.Direction;
import de.digitalcollections.model.api.paging.enums.NullHandling;
import de.digitalcollections.model.api.paging.impl.OrderImpl;
import de.digitalcollections.model.api.paging.impl.PageRequestImpl;
import de.digitalcollections.model.api.paging.impl.SortingImpl;
import java.util.Objects;
import java.util.UUID;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "The website controller", name = "Website controller")
public class WebsiteController {

  @Autowired
  private WebsiteService service;

  @ApiMethod(description = "get all websites")
  @RequestMapping(value = "/v1/websites",
          produces = "application/json", method = RequestMethod.GET)
  @ApiResponseObject
  public PageResponse<Website> findAll(
          @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
          @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
          @RequestParam(name = "sortField", required = false, defaultValue = "uuid") String sortField,
          @RequestParam(name = "sortDirection", required = false, defaultValue = "ASC") Direction sortDirection,
          @RequestParam(name = "nullHandling", required = false, defaultValue = "NATIVE") NullHandling nullHandling
  ) {
    // FIXME add support for multiple sorting orders
    OrderImpl order = new OrderImpl(sortDirection, sortField, nullHandling);
    Sorting sorting = new SortingImpl(order);
    PageRequest pageRequest = new PageRequestImpl(pageNumber, pageSize, sorting);
    return service.find(pageRequest);
  }

  @ApiMethod(description = "get website by uuid")
  @RequestMapping(value = "/v1/websites/{uuid}", produces = "application/json", method = RequestMethod.GET)
  @ApiResponseObject
  public Website findById(@PathVariable UUID uuid) {
    return (Website) service.get(uuid);
  }

  @ApiMethod(description = "save a newly created website")
  @RequestMapping(value = "/v1/websites", produces = "application/json", method = RequestMethod.POST)
  @ApiResponseObject
  public Website save(@RequestBody Website website, BindingResult errors) throws IdentifiableServiceException {
    return (Website) service.save(website);
  }

  @ApiMethod(description = "update a website")
  @RequestMapping(value = "/v1/websites/{uuid}", produces = "application/json", method = RequestMethod.PUT)
  @ApiResponseObject
  public Website update(@PathVariable UUID uuid, @RequestBody Website website, BindingResult errors) throws IdentifiableServiceException {
    assert Objects.equals(uuid, website.getUuid());
    return (Website) service.update(website);
  }
}
