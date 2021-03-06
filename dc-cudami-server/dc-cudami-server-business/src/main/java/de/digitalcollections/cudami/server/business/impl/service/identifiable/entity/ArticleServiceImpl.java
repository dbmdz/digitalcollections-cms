package de.digitalcollections.cudami.server.business.impl.service.identifiable.entity;

import de.digitalcollections.cudami.server.backend.api.repository.identifiable.entity.ArticleRepository;
import de.digitalcollections.cudami.server.business.api.service.exceptions.IdentifiableServiceException;
import de.digitalcollections.cudami.server.business.api.service.identifiable.entity.ArticleService;
import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Service for Article handling. */
@Service
public class ArticleServiceImpl extends EntityServiceImpl<Article> implements ArticleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

  @Autowired
  public ArticleServiceImpl(ArticleRepository repository) {
    super(repository);
  }

  @Override
  public Article get(UUID uuid, Locale locale) throws IdentifiableServiceException {
    Article article = super.get(uuid, locale);
    if (article == null) {
      return null;
    }

    // filter out not requested translations of fields not already filtered
    if (article.getText() != null) {
      article.getText().entrySet().removeIf((Map.Entry entry) -> !entry.getKey().equals(locale));
    }
    return article;
  }

  @Override
  public List<Agent> getCreators(UUID articleUuid) {
    return ((ArticleRepository) repository).getCreators(articleUuid);
  }
}
