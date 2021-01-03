/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.Keys;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.Public;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records.TopicSubtopicsRecord;
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
public class TopicSubtopics extends TableImpl<TopicSubtopicsRecord> {

  private static final long serialVersionUID = 697743878;

  /** The reference instance of <code>public.topic_subtopics</code> */
  public static final TopicSubtopics TOPIC_SUBTOPICS = new TopicSubtopics();

  /** The class holding records for this type */
  @Override
  public Class<TopicSubtopicsRecord> getRecordType() {
    return TopicSubtopicsRecord.class;
  }

  /** The column <code>public.topic_subtopics.topic_uuid</code>. */
  public final TableField<TopicSubtopicsRecord, UUID> TOPIC_UUID =
      createField(DSL.name("topic_uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

  /** The column <code>public.topic_subtopics.subtopic_uuid</code>. */
  public final TableField<TopicSubtopicsRecord, UUID> SUBTOPIC_UUID =
      createField(
          DSL.name("subtopic_uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

  /** The column <code>public.topic_subtopics.sortindex</code>. */
  public final TableField<TopicSubtopicsRecord, Short> SORTINDEX =
      createField(DSL.name("sortindex"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

  /** Create a <code>public.topic_subtopics</code> table reference */
  public TopicSubtopics() {
    this(DSL.name("topic_subtopics"), null);
  }

  /** Create an aliased <code>public.topic_subtopics</code> table reference */
  public TopicSubtopics(String alias) {
    this(DSL.name(alias), TOPIC_SUBTOPICS);
  }

  /** Create an aliased <code>public.topic_subtopics</code> table reference */
  public TopicSubtopics(Name alias) {
    this(alias, TOPIC_SUBTOPICS);
  }

  private TopicSubtopics(Name alias, Table<TopicSubtopicsRecord> aliased) {
    this(alias, aliased, null);
  }

  private TopicSubtopics(Name alias, Table<TopicSubtopicsRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  public <O extends Record> TopicSubtopics(
      Table<O> child, ForeignKey<O, TopicSubtopicsRecord> key) {
    super(child, key, TOPIC_SUBTOPICS);
  }

  @Override
  public Schema getSchema() {
    return Public.PUBLIC;
  }

  @Override
  public UniqueKey<TopicSubtopicsRecord> getPrimaryKey() {
    return Keys.TOPIC_SUBTOPICS_PKEY;
  }

  @Override
  public List<UniqueKey<TopicSubtopicsRecord>> getKeys() {
    return Arrays.<UniqueKey<TopicSubtopicsRecord>>asList(Keys.TOPIC_SUBTOPICS_PKEY);
  }

  @Override
  public List<ForeignKey<TopicSubtopicsRecord, ?>> getReferences() {
    return Arrays.<ForeignKey<TopicSubtopicsRecord, ?>>asList(
        Keys.TOPIC_SUBTOPICS__TOPIC_SUBTOPICS_TOPIC_UUID_FKEY,
        Keys.TOPIC_SUBTOPICS__TOPIC_SUBTOPICS_SUBTOPIC_UUID_FKEY);
  }

  public Topics topics() {
    return new Topics(this, Keys.TOPIC_SUBTOPICS__TOPIC_SUBTOPICS_TOPIC_UUID_FKEY);
  }

  public Subtopics subtopics() {
    return new Subtopics(this, Keys.TOPIC_SUBTOPICS__TOPIC_SUBTOPICS_SUBTOPIC_UUID_FKEY);
  }

  @Override
  public TopicSubtopics as(String alias) {
    return new TopicSubtopics(DSL.name(alias), this);
  }

  @Override
  public TopicSubtopics as(Name alias) {
    return new TopicSubtopics(alias, this);
  }

  /** Rename this table */
  @Override
  public TopicSubtopics rename(String name) {
    return new TopicSubtopics(DSL.name(name), null);
  }

  /** Rename this table */
  @Override
  public TopicSubtopics rename(Name name) {
    return new TopicSubtopics(name, null);
  }

  // -------------------------------------------------------------------------
  // Row3 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row3<UUID, UUID, Short> fieldsRow() {
    return (Row3) super.fieldsRow();
  }
}
