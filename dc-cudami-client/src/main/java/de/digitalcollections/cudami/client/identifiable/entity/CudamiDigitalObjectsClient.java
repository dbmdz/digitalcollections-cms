package de.digitalcollections.cudami.client.identifiable.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.cudami.client.CudamiBaseClient;
import de.digitalcollections.cudami.client.exceptions.HttpException;
import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.work.Item;
import de.digitalcollections.model.identifiable.resource.FileResource;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.paging.PageRequest;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.paging.SearchPageRequest;
import de.digitalcollections.model.paging.SearchPageResponse;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class CudamiDigitalObjectsClient extends CudamiBaseClient<DigitalObject> {

  public CudamiDigitalObjectsClient(HttpClient http, String serverUrl, ObjectMapper mapper) {
    super(http, serverUrl, DigitalObject.class, mapper);
  }

  public long count() throws HttpException {
    return Long.parseLong(doGetRequestForString("/latest/digitalobjects/count"));
  }

  public DigitalObject create() {
    return new DigitalObject();
  }

  public boolean delete(UUID uuid) throws HttpException {
    return Boolean.parseBoolean(
        doDeleteRequestForString(String.format("/latest/digitalobjects/%s", uuid)));
  }

  public PageResponse<DigitalObject> find(PageRequest pageRequest) throws HttpException {
    return doGetRequestForPagedObjectList("/latest/digitalobjects", pageRequest);
  }

  public SearchPageResponse<DigitalObject> find(SearchPageRequest searchPageRequest)
      throws HttpException {
    return doGetSearchRequestForPagedObjectList("/latest/digitalobjects/search", searchPageRequest);
  }

  public List<DigitalObject> find(String searchTerm, int maxResults) throws HttpException {
    SearchPageRequest searchPageRequest = new SearchPageRequest(searchTerm, 0, maxResults, null);
    SearchPageResponse<DigitalObject> response = find(searchPageRequest);
    return response.getContent();
  }

  public List<DigitalObject> findAllReduced() throws HttpException {
    return doGetRequestForObjectList("/latest/digitalobjects/reduced", DigitalObject.class);
  }

  public DigitalObject findOne(UUID uuid) throws HttpException {
    return doGetRequestForObject(String.format("/latest/digitalobjects/%s", uuid));
  }

  public DigitalObject findOneByIdentifier(String namespace, String id) throws HttpException {
    return doGetRequestForObject(
        String.format("/latest/digitalobjects/identifier/%s:%s.json", namespace, id));
  }

  public PageResponse<DigitalObject> findRandomDigitalObjects(int count) throws HttpException {
    PageRequest pageRequest = new PageRequest(0, count, null);
    return doGetRequestForPagedObjectList("/latest/digitalobjects/random", pageRequest);
  }

  public PageResponse<Collection> getActiveCollections(UUID uuid, PageRequest pageRequest)
      throws HttpException {
    return doGetRequestForPagedObjectList(
        String.format("/latest/digitalobjects/%s/collections?active=true", uuid),
        pageRequest,
        Collection.class);
  }

  public PageResponse<Collection> getCollections(UUID uuid, PageRequest pageRequest)
      throws HttpException {
    return doGetRequestForPagedObjectList(
        String.format("/latest/digitalobjects/%s/collections", uuid),
        pageRequest,
        Collection.class);
  }

  public List<FileResource> getFileResources(UUID uuid) throws HttpException {
    return doGetRequestForObjectList(
        String.format("/latest/digitalobjects/%s/fileresources", uuid), FileResource.class);
  }

  public List<ImageFileResource> getImageFileResources(UUID uuid) throws HttpException {
    return doGetRequestForObjectList(
        String.format("/latest/digitalobjects/%s/fileresources/images", uuid),
        ImageFileResource.class);
  }

  public Item getItem(UUID uuid) throws HttpException {
    return (Item)
        doGetRequestForObject(String.format("/latest/digitalobjects/%s/item", uuid), Item.class);
  }

  public PageResponse<Project> getProjects(UUID uuid, PageRequest pageRequest)
      throws HttpException {
    return doGetRequestForPagedObjectList(
        String.format("/latest/digitalobjects/%s/projects", uuid), pageRequest, Project.class);
  }

  public DigitalObject save(DigitalObject digitalObject) throws HttpException {
    return doPostRequestForObject("/latest/digitalobjects", digitalObject);
  }

  public List<FileResource> saveFileResources(UUID uuid, List fileResources) throws HttpException {
    return doPostRequestForObjectList(
        String.format("/latest/digitalobjects/%s/fileresources", uuid),
        fileResources,
        FileResource.class);
  }

  public DigitalObject update(UUID uuid, DigitalObject digitalObject) throws HttpException {
    return doPutRequestForObject(String.format("/latest/digitalobjects/%s", uuid), digitalObject);
  }

  public List<Locale> getLanguages() throws HttpException {
    return doGetRequestForObjectList("/latest/digitalobjects/languages", Locale.class);
  }
}
