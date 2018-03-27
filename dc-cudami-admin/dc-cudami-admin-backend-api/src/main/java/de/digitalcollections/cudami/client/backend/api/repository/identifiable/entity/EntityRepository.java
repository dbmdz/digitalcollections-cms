package de.digitalcollections.cudami.client.backend.api.repository.identifiable.entity;

import de.digitalcollections.cudami.client.backend.api.repository.identifiable.IdentifiableRepository;
import de.digitalcollections.cudami.model.api.identifiable.entity.Entity;

public interface EntityRepository<E extends Entity> extends IdentifiableRepository<E> {

}