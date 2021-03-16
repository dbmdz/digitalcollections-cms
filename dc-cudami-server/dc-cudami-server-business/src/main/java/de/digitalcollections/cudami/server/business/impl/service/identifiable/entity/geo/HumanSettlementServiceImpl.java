package de.digitalcollections.cudami.server.business.impl.service.identifiable.entity.geo;

import de.digitalcollections.cudami.server.backend.api.repository.identifiable.entity.geo.HumanSettlementRepository;
import de.digitalcollections.cudami.server.business.api.service.identifiable.entity.geo.HumanSettlementService;
import de.digitalcollections.cudami.server.business.impl.service.identifiable.entity.EntityServiceImpl;
import de.digitalcollections.model.api.identifiable.entity.geo.HumanSettlement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanSettlementServiceImpl extends EntityServiceImpl<HumanSettlement>
    implements HumanSettlementService {

  private static final Logger LOGGER = LoggerFactory.getLogger(HumanSettlementServiceImpl.class);

  @Autowired
  public HumanSettlementServiceImpl(HumanSettlementRepository repository) {
    super(repository);
  }
}