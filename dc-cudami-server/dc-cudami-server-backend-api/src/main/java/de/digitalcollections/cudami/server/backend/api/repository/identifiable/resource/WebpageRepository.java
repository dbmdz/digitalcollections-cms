package de.digitalcollections.cudami.server.backend.api.repository.identifiable.resource;

import de.digitalcollections.cudami.server.backend.api.repository.identifiable.IdentifiableRepository;
import de.digitalcollections.model.api.identifiable.resource.Webpage;
import java.util.List;
import java.util.UUID;

/**
 * Repository for Webpage persistence handling.
 *
 * @param <W> resource instance
 */
public interface WebpageRepository<W extends Webpage> extends IdentifiableRepository<W> {

  List<Webpage> getSubPages(W webpage);

  Webpage saveWithParentWebsite(W webpage, UUID parentWebsiteUuid);

  Webpage saveWithParentWebpage(W webpage, UUID parentWebpageUuid);
}
