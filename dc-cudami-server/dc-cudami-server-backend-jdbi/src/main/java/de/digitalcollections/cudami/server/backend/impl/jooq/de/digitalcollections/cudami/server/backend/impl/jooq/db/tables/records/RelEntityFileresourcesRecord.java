/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.RelEntityFileresources;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class RelEntityFileresourcesRecord extends UpdatableRecordImpl<RelEntityFileresourcesRecord>
    implements Record3<UUID, UUID, Short> {

  private static final long serialVersionUID = -1048936472;

  /** Setter for <code>public.rel_entity_fileresources.entity_uuid</code>. */
  public void setEntityUuid(UUID value) {
    set(0, value);
  }

  /** Getter for <code>public.rel_entity_fileresources.entity_uuid</code>. */
  public UUID getEntityUuid() {
    return (UUID) get(0);
  }

  /** Setter for <code>public.rel_entity_fileresources.fileresource_uuid</code>. */
  public void setFileresourceUuid(UUID value) {
    set(1, value);
  }

  /** Getter for <code>public.rel_entity_fileresources.fileresource_uuid</code>. */
  public UUID getFileresourceUuid() {
    return (UUID) get(1);
  }

  /** Setter for <code>public.rel_entity_fileresources.sortindex</code>. */
  public void setSortindex(Short value) {
    set(2, value);
  }

  /** Getter for <code>public.rel_entity_fileresources.sortindex</code>. */
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
    return RelEntityFileresources.REL_ENTITY_FILERESOURCES.ENTITY_UUID;
  }

  @Override
  public Field<UUID> field2() {
    return RelEntityFileresources.REL_ENTITY_FILERESOURCES.FILERESOURCE_UUID;
  }

  @Override
  public Field<Short> field3() {
    return RelEntityFileresources.REL_ENTITY_FILERESOURCES.SORTINDEX;
  }

  @Override
  public UUID component1() {
    return getEntityUuid();
  }

  @Override
  public UUID component2() {
    return getFileresourceUuid();
  }

  @Override
  public Short component3() {
    return getSortindex();
  }

  @Override
  public UUID value1() {
    return getEntityUuid();
  }

  @Override
  public UUID value2() {
    return getFileresourceUuid();
  }

  @Override
  public Short value3() {
    return getSortindex();
  }

  @Override
  public RelEntityFileresourcesRecord value1(UUID value) {
    setEntityUuid(value);
    return this;
  }

  @Override
  public RelEntityFileresourcesRecord value2(UUID value) {
    setFileresourceUuid(value);
    return this;
  }

  @Override
  public RelEntityFileresourcesRecord value3(Short value) {
    setSortindex(value);
    return this;
  }

  @Override
  public RelEntityFileresourcesRecord values(UUID value1, UUID value2, Short value3) {
    value1(value1);
    value2(value2);
    value3(value3);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /** Create a detached RelEntityFileresourcesRecord */
  public RelEntityFileresourcesRecord() {
    super(RelEntityFileresources.REL_ENTITY_FILERESOURCES);
  }

  /** Create a detached, initialised RelEntityFileresourcesRecord */
  public RelEntityFileresourcesRecord(UUID entityUuid, UUID fileresourceUuid, Short sortindex) {
    super(RelEntityFileresources.REL_ENTITY_FILERESOURCES);

    set(0, entityUuid);
    set(1, fileresourceUuid);
    set(2, sortindex);
  }
}
