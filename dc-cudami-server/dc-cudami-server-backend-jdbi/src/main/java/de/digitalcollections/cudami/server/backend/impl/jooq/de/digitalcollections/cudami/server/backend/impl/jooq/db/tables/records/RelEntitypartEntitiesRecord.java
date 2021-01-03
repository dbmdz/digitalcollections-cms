/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.RelEntitypartEntities;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class RelEntitypartEntitiesRecord extends UpdatableRecordImpl<RelEntitypartEntitiesRecord>
    implements Record3<UUID, UUID, Short> {

  private static final long serialVersionUID = -439480071;

  /** Setter for <code>public.rel_entitypart_entities.entitypart_uuid</code>. */
  public void setEntitypartUuid(UUID value) {
    set(0, value);
  }

  /** Getter for <code>public.rel_entitypart_entities.entitypart_uuid</code>. */
  public UUID getEntitypartUuid() {
    return (UUID) get(0);
  }

  /** Setter for <code>public.rel_entitypart_entities.entity_uuid</code>. */
  public void setEntityUuid(UUID value) {
    set(1, value);
  }

  /** Getter for <code>public.rel_entitypart_entities.entity_uuid</code>. */
  public UUID getEntityUuid() {
    return (UUID) get(1);
  }

  /** Setter for <code>public.rel_entitypart_entities.sortindex</code>. */
  public void setSortindex(Short value) {
    set(2, value);
  }

  /** Getter for <code>public.rel_entitypart_entities.sortindex</code>. */
  public Short getSortindex() {
    return (Short) get(2);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record2<UUID, UUID> key() {
    return (Record2) super.key();
  }

  // -------------------------------------------------------------------------
  // Record3 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row3<UUID, UUID, Short> fieldsRow() {
    return (Row3) super.fieldsRow();
  }

  @Override
  public Row3<UUID, UUID, Short> valuesRow() {
    return (Row3) super.valuesRow();
  }

  @Override
  public Field<UUID> field1() {
    return RelEntitypartEntities.REL_ENTITYPART_ENTITIES.ENTITYPART_UUID;
  }

  @Override
  public Field<UUID> field2() {
    return RelEntitypartEntities.REL_ENTITYPART_ENTITIES.ENTITY_UUID;
  }

  @Override
  public Field<Short> field3() {
    return RelEntitypartEntities.REL_ENTITYPART_ENTITIES.SORTINDEX;
  }

  @Override
  public UUID component1() {
    return getEntitypartUuid();
  }

  @Override
  public UUID component2() {
    return getEntityUuid();
  }

  @Override
  public Short component3() {
    return getSortindex();
  }

  @Override
  public UUID value1() {
    return getEntitypartUuid();
  }

  @Override
  public UUID value2() {
    return getEntityUuid();
  }

  @Override
  public Short value3() {
    return getSortindex();
  }

  @Override
  public RelEntitypartEntitiesRecord value1(UUID value) {
    setEntitypartUuid(value);
    return this;
  }

  @Override
  public RelEntitypartEntitiesRecord value2(UUID value) {
    setEntityUuid(value);
    return this;
  }

  @Override
  public RelEntitypartEntitiesRecord value3(Short value) {
    setSortindex(value);
    return this;
  }

  @Override
  public RelEntitypartEntitiesRecord values(UUID value1, UUID value2, Short value3) {
    value1(value1);
    value2(value2);
    value3(value3);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /** Create a detached RelEntitypartEntitiesRecord */
  public RelEntitypartEntitiesRecord() {
    super(RelEntitypartEntities.REL_ENTITYPART_ENTITIES);
  }

  /** Create a detached, initialised RelEntitypartEntitiesRecord */
  public RelEntitypartEntitiesRecord(UUID entitypartUuid, UUID entityUuid, Short sortindex) {
    super(RelEntitypartEntities.REL_ENTITYPART_ENTITIES);

    set(0, entitypartUuid);
    set(1, entityUuid);
    set(2, sortindex);
  }
}
