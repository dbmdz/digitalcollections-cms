package de.digitalcollections.cudami.admin.backend.api.repository.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.ContentTree;
import de.digitalcollections.model.api.identifiable.entity.parts.ContentNode;
import java.util.List;

/**
 * Repository for ContentTree persistence handling.
 *
 * @param <C> content tree instance
 */
public interface ContentTreeRepository<C extends ContentTree> extends EntityRepository<C> {

  List<ContentNode> getRootNodes(C contentTree);
}
