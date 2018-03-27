package de.digitalcollections.cudami.model.jackson.mixin.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.cudami.model.impl.identifiable.resource.IiifImageImpl;

@JsonDeserialize(as = IiifImageImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface IiifImageMixIn {

}