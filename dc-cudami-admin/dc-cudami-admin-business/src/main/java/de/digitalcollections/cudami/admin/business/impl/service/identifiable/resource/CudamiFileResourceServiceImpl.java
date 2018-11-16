package de.digitalcollections.cudami.admin.business.impl.service.identifiable.resource;

import de.digitalcollections.cudami.admin.backend.api.repository.identifiable.resource.CudamiFileResourceRepository;
import de.digitalcollections.cudami.admin.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.admin.business.api.service.identifiable.resource.CudamiFileResourceService;
import de.digitalcollections.cudami.admin.business.impl.service.identifiable.IdentifiableServiceImpl;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
//@Transactional(readOnly = true)
public class CudamiFileResourceServiceImpl<F extends FileResource> extends IdentifiableServiceImpl<F> implements CudamiFileResourceService<F> {

  private static final Logger LOGGER = LoggerFactory.getLogger(CudamiFileResourceServiceImpl.class);

  @Autowired
  public CudamiFileResourceServiceImpl(CudamiFileResourceRepository<F> repository) {
    super(repository);
  }

  @Override
  public F save(FileResource fileResource, byte[] bytes, Errors results) throws IdentifiableServiceException {
    if (!results.hasErrors()) {
      try {
        fileResource = (F) ((CudamiFileResourceRepository) repository).save(fileResource, bytes);
      } catch (Exception e) {
        LOGGER.error("Cannot save fileResource " + fileResource + ": ", e);
        throw new IdentifiableServiceException(e.getMessage());
      }
    }
    // FIXME: what if results has errors? throw exception?
    return (F) fileResource;
  }
}