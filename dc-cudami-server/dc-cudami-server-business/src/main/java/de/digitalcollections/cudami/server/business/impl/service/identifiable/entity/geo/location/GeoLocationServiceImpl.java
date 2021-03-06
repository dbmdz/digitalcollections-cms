package de.digitalcollections.cudami.server.business.impl.service.identifiable.entity.geo.location;

import de.digitalcollections.cudami.server.backend.api.repository.identifiable.entity.geo.location.GeoLocationRepository;
import de.digitalcollections.cudami.server.business.api.service.identifiable.entity.geo.location.GeoLocationService;
import de.digitalcollections.cudami.server.business.impl.service.identifiable.entity.EntityServiceImpl;
import de.digitalcollections.model.identifiable.entity.geo.location.GeoLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoLocationServiceImpl extends EntityServiceImpl<GeoLocation>
    implements GeoLocationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationServiceImpl.class);

  @Autowired
  public GeoLocationServiceImpl(GeoLocationRepository repository) {
    super(repository);
  }
}
