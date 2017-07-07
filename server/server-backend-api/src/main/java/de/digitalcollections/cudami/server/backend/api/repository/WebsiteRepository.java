package de.digitalcollections.cudami.server.backend.api.repository;

import de.digitalcollections.cudami.model.api.entity.Website;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository for Website persistence handling.
 *
 * @param <T> entity instance
 * @param <ID> unique id
 */
public interface WebsiteRepository<T extends Website, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

  T create();

  @Override
  List<T> findAll(Sort sort);

//  T find(UUID uuid);
}