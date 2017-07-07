package de.digitalcollections.cudami.client.backend.impl.repository;

import de.digitalcollections.cudami.model.impl.security.OperationImpl;
import feign.Param;
import feign.RequestLine;

public interface OperationRepositoryEndpoint {

  @RequestLine("GET /operation/v1/findByName/{name}")
  OperationImpl findByName(@Param("name") String name);
}