package de.digitalcollections.cudami.server.business.impl.service.identifiable;

import de.digitalcollections.cudami.server.backend.api.repository.identifiable.IdentifiableRepository;
import de.digitalcollections.cudami.server.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.server.business.api.service.identifiable.IdentifiableService;
import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@Transactional(readOnly = true)
public class IdentifiableServiceImpl<I extends Identifiable> implements IdentifiableService<I> {

  private static final Logger LOGGER = LoggerFactory.getLogger(IdentifiableServiceImpl.class);

  protected IdentifiableRepository<I> repository;

  @Autowired
  public IdentifiableServiceImpl(@Qualifier("identifiableRepositoryImpl") IdentifiableRepository<I> repository) {
    this.repository = repository;
  }

  @Override
  public long count() {
    return repository.count();
  }

  @Override
  public I create() {
    I identifiable = (I) repository.create();
    return identifiable;
  }

  @Override
  public PageResponse<I> find(PageRequest pageRequest) {
    return repository.find(pageRequest);
  }

  @Override
  public I get(UUID uuid) {
    return (I) repository.findOne(uuid);
  }

  @Override
//  @Transactional(readOnly = false)
  public I save(I identifiable) throws IdentifiableServiceException {
    try {
      return (I) repository.save(identifiable);
    } catch (Exception e) {
      LOGGER.error("Cannot save identifiable " + identifiable + ": ", e);
      throw new IdentifiableServiceException(e.getMessage());
    }
  }

  @Override
//  @Transactional(readOnly = false)
  public I update(I identifiable) throws IdentifiableServiceException {
    try {
      return (I) repository.update(identifiable);
    } catch (Exception e) {
      LOGGER.error("Cannot update identifiable " + identifiable + ": ", e);
      throw new IdentifiableServiceException(e.getMessage());
    }
  }
}