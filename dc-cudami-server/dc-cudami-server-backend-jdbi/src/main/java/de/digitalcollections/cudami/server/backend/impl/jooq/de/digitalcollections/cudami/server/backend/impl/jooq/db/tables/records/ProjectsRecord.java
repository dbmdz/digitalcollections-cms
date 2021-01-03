/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.Projects;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ProjectsRecord extends UpdatableRecordImpl<ProjectsRecord>
    implements Record15<
        UUID,
        LocalDateTime,
        JSONB,
        String,
        JSONB,
        LocalDateTime,
        String,
        Integer,
        JSONB,
        LocalDate,
        LocalDate,
        Integer,
        UUID,
        JSONB,
        JSONB> {

  private static final long serialVersionUID = -2051015110;

  /** Setter for <code>public.projects.uuid</code>. */
  public void setUuid(UUID value) {
    set(0, value);
  }

  /** Getter for <code>public.projects.uuid</code>. */
  public UUID getUuid() {
    return (UUID) get(0);
  }

  /** Setter for <code>public.projects.created</code>. */
  public void setCreated(LocalDateTime value) {
    set(1, value);
  }

  /** Getter for <code>public.projects.created</code>. */
  public LocalDateTime getCreated() {
    return (LocalDateTime) get(1);
  }

  /** Setter for <code>public.projects.description</code>. */
  public void setDescription(JSONB value) {
    set(2, value);
  }

  /** Getter for <code>public.projects.description</code>. */
  public JSONB getDescription() {
    return (JSONB) get(2);
  }

  /** Setter for <code>public.projects.identifiable_type</code>. */
  public void setIdentifiableType(String value) {
    set(3, value);
  }

  /** Getter for <code>public.projects.identifiable_type</code>. */
  public String getIdentifiableType() {
    return (String) get(3);
  }

  /** Setter for <code>public.projects.label</code>. */
  public void setLabel(JSONB value) {
    set(4, value);
  }

  /** Getter for <code>public.projects.label</code>. */
  public JSONB getLabel() {
    return (JSONB) get(4);
  }

  /** Setter for <code>public.projects.last_modified</code>. */
  public void setLastModified(LocalDateTime value) {
    set(5, value);
  }

  /** Getter for <code>public.projects.last_modified</code>. */
  public LocalDateTime getLastModified() {
    return (LocalDateTime) get(5);
  }

  /** Setter for <code>public.projects.entity_type</code>. */
  public void setEntityType(String value) {
    set(6, value);
  }

  /** Getter for <code>public.projects.entity_type</code>. */
  public String getEntityType() {
    return (String) get(6);
  }

  /** Setter for <code>public.projects.id</code>. */
  public void setId(Integer value) {
    set(7, value);
  }

  /** Getter for <code>public.projects.id</code>. */
  public Integer getId() {
    return (Integer) get(7);
  }

  /** Setter for <code>public.projects.text</code>. */
  public void setText(JSONB value) {
    set(8, value);
  }

  /** Getter for <code>public.projects.text</code>. */
  public JSONB getText() {
    return (JSONB) get(8);
  }

  /** Setter for <code>public.projects.start_date</code>. */
  public void setStartDate(LocalDate value) {
    set(9, value);
  }

  /** Getter for <code>public.projects.start_date</code>. */
  public LocalDate getStartDate() {
    return (LocalDate) get(9);
  }

  /** Setter for <code>public.projects.end_date</code>. */
  public void setEndDate(LocalDate value) {
    set(10, value);
  }

  /** Getter for <code>public.projects.end_date</code>. */
  public LocalDate getEndDate() {
    return (LocalDate) get(10);
  }

  /** Setter for <code>public.projects.refid</code>. */
  public void setRefid(Integer value) {
    set(11, value);
  }

  /** Getter for <code>public.projects.refid</code>. */
  public Integer getRefid() {
    return (Integer) get(11);
  }

  /** Setter for <code>public.projects.previewfileresource</code>. */
  public void setPreviewfileresource(UUID value) {
    set(12, value);
  }

  /** Getter for <code>public.projects.previewfileresource</code>. */
  public UUID getPreviewfileresource() {
    return (UUID) get(12);
  }

  /** Setter for <code>public.projects.preview_hints</code>. */
  public void setPreviewHints(JSONB value) {
    set(13, value);
  }

  /** Getter for <code>public.projects.preview_hints</code>. */
  public JSONB getPreviewHints() {
    return (JSONB) get(13);
  }

  /** Setter for <code>public.projects.custom_attrs</code>. */
  public void setCustomAttrs(JSONB value) {
    set(14, value);
  }

  /** Getter for <code>public.projects.custom_attrs</code>. */
  public JSONB getCustomAttrs() {
    return (JSONB) get(14);
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  @Override
  public Record1<Integer> key() {
    return (Record1) super.key();
  }

  // -------------------------------------------------------------------------
  // Record15 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row15<
          UUID,
          LocalDateTime,
          JSONB,
          String,
          JSONB,
          LocalDateTime,
          String,
          Integer,
          JSONB,
          LocalDate,
          LocalDate,
          Integer,
          UUID,
          JSONB,
          JSONB>
      fieldsRow() {
    return (Row15) super.fieldsRow();
  }

  @Override
  public Row15<
          UUID,
          LocalDateTime,
          JSONB,
          String,
          JSONB,
          LocalDateTime,
          String,
          Integer,
          JSONB,
          LocalDate,
          LocalDate,
          Integer,
          UUID,
          JSONB,
          JSONB>
      valuesRow() {
    return (Row15) super.valuesRow();
  }

  @Override
  public Field<UUID> field1() {
    return Projects.PROJECTS.UUID;
  }

  @Override
  public Field<LocalDateTime> field2() {
    return Projects.PROJECTS.CREATED;
  }

  @Override
  public Field<JSONB> field3() {
    return Projects.PROJECTS.DESCRIPTION;
  }

  @Override
  public Field<String> field4() {
    return Projects.PROJECTS.IDENTIFIABLE_TYPE;
  }

  @Override
  public Field<JSONB> field5() {
    return Projects.PROJECTS.LABEL;
  }

  @Override
  public Field<LocalDateTime> field6() {
    return Projects.PROJECTS.LAST_MODIFIED;
  }

  @Override
  public Field<String> field7() {
    return Projects.PROJECTS.ENTITY_TYPE;
  }

  @Override
  public Field<Integer> field8() {
    return Projects.PROJECTS.ID;
  }

  @Override
  public Field<JSONB> field9() {
    return Projects.PROJECTS.TEXT;
  }

  @Override
  public Field<LocalDate> field10() {
    return Projects.PROJECTS.START_DATE;
  }

  @Override
  public Field<LocalDate> field11() {
    return Projects.PROJECTS.END_DATE;
  }

  @Override
  public Field<Integer> field12() {
    return Projects.PROJECTS.REFID;
  }

  @Override
  public Field<UUID> field13() {
    return Projects.PROJECTS.PREVIEWFILERESOURCE;
  }

  @Override
  public Field<JSONB> field14() {
    return Projects.PROJECTS.PREVIEW_HINTS;
  }

  @Override
  public Field<JSONB> field15() {
    return Projects.PROJECTS.CUSTOM_ATTRS;
  }

  @Override
  public UUID component1() {
    return getUuid();
  }

  @Override
  public LocalDateTime component2() {
    return getCreated();
  }

  @Override
  public JSONB component3() {
    return getDescription();
  }

  @Override
  public String component4() {
    return getIdentifiableType();
  }

  @Override
  public JSONB component5() {
    return getLabel();
  }

  @Override
  public LocalDateTime component6() {
    return getLastModified();
  }

  @Override
  public String component7() {
    return getEntityType();
  }

  @Override
  public Integer component8() {
    return getId();
  }

  @Override
  public JSONB component9() {
    return getText();
  }

  @Override
  public LocalDate component10() {
    return getStartDate();
  }

  @Override
  public LocalDate component11() {
    return getEndDate();
  }

  @Override
  public Integer component12() {
    return getRefid();
  }

  @Override
  public UUID component13() {
    return getPreviewfileresource();
  }

  @Override
  public JSONB component14() {
    return getPreviewHints();
  }

  @Override
  public JSONB component15() {
    return getCustomAttrs();
  }

  @Override
  public UUID value1() {
    return getUuid();
  }

  @Override
  public LocalDateTime value2() {
    return getCreated();
  }

  @Override
  public JSONB value3() {
    return getDescription();
  }

  @Override
  public String value4() {
    return getIdentifiableType();
  }

  @Override
  public JSONB value5() {
    return getLabel();
  }

  @Override
  public LocalDateTime value6() {
    return getLastModified();
  }

  @Override
  public String value7() {
    return getEntityType();
  }

  @Override
  public Integer value8() {
    return getId();
  }

  @Override
  public JSONB value9() {
    return getText();
  }

  @Override
  public LocalDate value10() {
    return getStartDate();
  }

  @Override
  public LocalDate value11() {
    return getEndDate();
  }

  @Override
  public Integer value12() {
    return getRefid();
  }

  @Override
  public UUID value13() {
    return getPreviewfileresource();
  }

  @Override
  public JSONB value14() {
    return getPreviewHints();
  }

  @Override
  public JSONB value15() {
    return getCustomAttrs();
  }

  @Override
  public ProjectsRecord value1(UUID value) {
    setUuid(value);
    return this;
  }

  @Override
  public ProjectsRecord value2(LocalDateTime value) {
    setCreated(value);
    return this;
  }

  @Override
  public ProjectsRecord value3(JSONB value) {
    setDescription(value);
    return this;
  }

  @Override
  public ProjectsRecord value4(String value) {
    setIdentifiableType(value);
    return this;
  }

  @Override
  public ProjectsRecord value5(JSONB value) {
    setLabel(value);
    return this;
  }

  @Override
  public ProjectsRecord value6(LocalDateTime value) {
    setLastModified(value);
    return this;
  }

  @Override
  public ProjectsRecord value7(String value) {
    setEntityType(value);
    return this;
  }

  @Override
  public ProjectsRecord value8(Integer value) {
    setId(value);
    return this;
  }

  @Override
  public ProjectsRecord value9(JSONB value) {
    setText(value);
    return this;
  }

  @Override
  public ProjectsRecord value10(LocalDate value) {
    setStartDate(value);
    return this;
  }

  @Override
  public ProjectsRecord value11(LocalDate value) {
    setEndDate(value);
    return this;
  }

  @Override
  public ProjectsRecord value12(Integer value) {
    setRefid(value);
    return this;
  }

  @Override
  public ProjectsRecord value13(UUID value) {
    setPreviewfileresource(value);
    return this;
  }

  @Override
  public ProjectsRecord value14(JSONB value) {
    setPreviewHints(value);
    return this;
  }

  @Override
  public ProjectsRecord value15(JSONB value) {
    setCustomAttrs(value);
    return this;
  }

  @Override
  public ProjectsRecord values(
      UUID value1,
      LocalDateTime value2,
      JSONB value3,
      String value4,
      JSONB value5,
      LocalDateTime value6,
      String value7,
      Integer value8,
      JSONB value9,
      LocalDate value10,
      LocalDate value11,
      Integer value12,
      UUID value13,
      JSONB value14,
      JSONB value15) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    value5(value5);
    value6(value6);
    value7(value7);
    value8(value8);
    value9(value9);
    value10(value10);
    value11(value11);
    value12(value12);
    value13(value13);
    value14(value14);
    value15(value15);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /** Create a detached ProjectsRecord */
  public ProjectsRecord() {
    super(Projects.PROJECTS);
  }

  /** Create a detached, initialised ProjectsRecord */
  public ProjectsRecord(
      UUID uuid,
      LocalDateTime created,
      JSONB description,
      String identifiableType,
      JSONB label,
      LocalDateTime lastModified,
      String entityType,
      Integer id,
      JSONB text,
      LocalDate startDate,
      LocalDate endDate,
      Integer refid,
      UUID previewfileresource,
      JSONB previewHints,
      JSONB customAttrs) {
    super(Projects.PROJECTS);

    set(0, uuid);
    set(1, created);
    set(2, description);
    set(3, identifiableType);
    set(4, label);
    set(5, lastModified);
    set(6, entityType);
    set(7, id);
    set(8, text);
    set(9, startDate);
    set(10, endDate);
    set(11, refid);
    set(12, previewfileresource);
    set(13, previewHints);
    set(14, customAttrs);
  }
}
