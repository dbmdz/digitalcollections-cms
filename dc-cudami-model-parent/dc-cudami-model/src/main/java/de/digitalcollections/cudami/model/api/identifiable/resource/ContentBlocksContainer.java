package de.digitalcollections.cudami.model.api.identifiable.resource;

import de.digitalcollections.cudami.model.api.identifiable.resource.parts.ContentBlock;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ContentBlocksContainer is used for text content.
 */
public interface ContentBlocksContainer extends Resource {

  /**
   * @return (multilingual) text content
   */
  Map<Locale, List<ContentBlock>> getContentBlocks();

  /**
   * @param contentBlocks the (multilingual) text content
   */
  void setContentBlocks(Map<Locale, List<ContentBlock>> contentBlocks);

  default void addContentBlocks(Locale locale, List<ContentBlock> contentBlocks) {
    if (getContentBlocks() == null) {
      setContentBlocks(new HashMap<>());
    }
    getContentBlocks().put(locale, contentBlocks);
  }
}