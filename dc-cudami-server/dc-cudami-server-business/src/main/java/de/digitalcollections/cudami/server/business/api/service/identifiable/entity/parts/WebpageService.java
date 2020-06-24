package de.digitalcollections.cudami.server.business.api.service.identifiable.entity.parts;

import de.digitalcollections.cudami.server.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.server.business.api.service.identifiable.NodeService;
import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.Website;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.api.view.BreadcrumbNavigation;
import java.util.Locale;
import java.util.UUID;

/**
 * Service for Webpage.
 *
 * @param <E> entity type
 */
public interface WebpageService<E extends Entity>
    extends NodeService<Webpage>, EntityPartService<Webpage, E> {

  Webpage get(UUID uuid, Locale locale) throws IdentifiableServiceException;

  Website getWebsite(UUID webpageUuid);

  Webpage saveWithParentWebsite(Webpage webpage, UUID parentWebsiteUuid)
      throws IdentifiableServiceException;

  Webpage saveWithParentWebpage(Webpage webpage, UUID parentWebpageUuid)
      throws IdentifiableServiceException;

  /**
   * Build and return the breadcrumb navigation for the given webpage UUID
   *
   * @param uuid the uuid of the webpage.
   * @return BreadcrumbNavigation with labels in all available languages
   */
  BreadcrumbNavigation getBreadcrumbNavigation(UUID uuid);

  /**
   * Build and return the breadcrumb navigation for the given webpage UUID and desired locale. If no
   * label for that locale exists, use the label for the fallbackLocale, and if even this fails, use
   * the first locale.
   *
   * @param uuid the uuid of the webpage
   * @param locale the desired locale for the navigation item labels
   * @param fallbackLocale the fallback locale for the navigation item labels
   * @return Breadcrumb navigation with labels in the desired language (if possible)
   */
  BreadcrumbNavigation getBreadcrumbNavigation(UUID uuid, Locale locale, Locale fallbackLocale);
}
