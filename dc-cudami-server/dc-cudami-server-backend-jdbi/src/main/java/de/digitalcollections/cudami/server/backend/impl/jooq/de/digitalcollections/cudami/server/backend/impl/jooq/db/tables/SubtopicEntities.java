/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.Keys;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.Public;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records.SubtopicEntitiesRecord;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SubtopicEntities extends TableImpl<SubtopicEntitiesRecord> {

  private static final long serialVersionUID = -2000026952;

  /** The reference instance of <code>public.subtopic_entities</code> */
  public static final SubtopicEntities SUBTOPIC_ENTITIES = new SubtopicEntities();

  /** The class holding records for this type */
  @Override
  public Class<SubtopicEntitiesRecord> getRecordType() {
    return SubtopicEntitiesRecord.class;
  }

  /** The column <code>public.subtopic_entities.subtopic_uuid</code>. */
  public final TableField<SubtopicEntitiesRecord, UUID> SUBTOPIC_UUID =
      createField(
          DSL.name("subtopic_uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

  /** The column <code>public.subtopic_entities.entity_uuid</code>. */
  public final TableField<SubtopicEntitiesRecord, UUID> ENTITY_UUID =
      createField(
          DSL.name("entity_uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

  /** The column <code>public.subtopic_entities.sortindex</code>. */
  public final TableField<SubtopicEntitiesRecord, Short> SORTINDEX =
      createField(DSL.name("sortindex"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

  /** Create a <code>public.subtopic_entities</code> table reference */
  public SubtopicEntities() {
    this(DSL.name("subtopic_entities"), null);
  }

  /** Create an aliased <code>public.subtopic_entities</code> table reference */
  public SubtopicEntities(String alias) {
    this(DSL.name(alias), SUBTOPIC_ENTITIES);
  }

  /** Create an aliased <code>public.subtopic_entities</code> table reference */
  public SubtopicEntities(Name alias) {
    this(alias, SUBTOPIC_ENTITIES);
  }

  private SubtopicEntities(Name alias, Table<SubtopicEntitiesRecord> aliased) {
    this(alias, aliased, null);
  }

  private SubtopicEntities(
      Name alias, Table<SubtopicEntitiesRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  public <O extends Record> SubtopicEntities(
      Table<O> child, ForeignKey<O, SubtopicEntitiesRecord> key) {
    super(child, key, SUBTOPIC_ENTITIES);
  }

  @Override
  public Schema getSchema() {
    return Public.PUBLIC;
  }

  @Override
  public UniqueKey<SubtopicEntitiesRecord> getPrimaryKey() {
    return Keys.SUBTOPIC_ENTITIES_PKEY;
  }

  @Override
  public List<UniqueKey<SubtopicEntitiesRecord>> getKeys() {
    return Arrays.<UniqueKey<SubtopicEntitiesRecord>>asList(Keys.SUBTOPIC_ENTITIES_PKEY);
  }

  @Override
  public List<ForeignKey<SubtopicEntitiesRecord, ?>> getReferences() {
    return Arrays.<ForeignKey<SubtopicEntitiesRecord, ?>>asList(
        Keys.SUBTOPIC_ENTITIES__SUBTOPIC_ENTITIES_SUBTOPIC_UUID_FKEY);
  }

  public Subtopics subtopics() {
    return new Subtopics(this, Keys.SUBTOPIC_ENTITIES__SUBTOPIC_ENTITIES_SUBTOPIC_UUID_FKEY);
  }

  @Override
  public SubtopicEntities as(String alias) {
    return new SubtopicEntities(DSL.name(alias), this);
  }

  @Override
  public SubtopicEntities as(Name alias) {
    return new SubtopicEntities(alias, this);
  }

  /** Rename this table */
  @Override
  public SubtopicEntities rename(String name) {
    return new SubtopicEntities(DSL.name(name), null);
  }

  /** Rename this table */
  @Override
  public SubtopicEntities rename(Name name) {
    return new SubtopicEntities(name, null);
  }

  // -------------------------------------------------------------------------
  // Row3 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row3<UUID, UUID, Short> fieldsRow() {
    return (Row3) super.fieldsRow();
  }
}
