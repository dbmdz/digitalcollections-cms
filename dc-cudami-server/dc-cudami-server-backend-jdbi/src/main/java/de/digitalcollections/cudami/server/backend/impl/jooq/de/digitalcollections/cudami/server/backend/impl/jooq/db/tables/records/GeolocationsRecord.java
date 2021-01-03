/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.Geolocations;
import java.time.LocalDateTime;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class GeolocationsRecord extends TableRecordImpl<GeolocationsRecord>
    implements Record13<
        UUID,
        LocalDateTime,
        JSONB,
        String,
        JSONB,
        LocalDateTime,
        String,
        Integer,
        UUID,
        JSONB,
        JSONB,
        String,
        JSONB> {

  private static final long serialVersionUID = -1219884169;

  /** Setter for <code>public.geolocations.uuid</code>. */
  public void setUuid(UUID value) {
    set(0, value);
  }

  /** Getter for <code>public.geolocations.uuid</code>. */
  public UUID getUuid() {
    return (UUID) get(0);
  }

  /** Setter for <code>public.geolocations.created</code>. */
  public void setCreated(LocalDateTime value) {
    set(1, value);
  }

  /** Getter for <code>public.geolocations.created</code>. */
  public LocalDateTime getCreated() {
    return (LocalDateTime) get(1);
  }

  /** Setter for <code>public.geolocations.description</code>. */
  public void setDescription(JSONB value) {
    set(2, value);
  }

  /** Getter for <code>public.geolocations.description</code>. */
  public JSONB getDescription() {
    return (JSONB) get(2);
  }

  /** Setter for <code>public.geolocations.identifiable_type</code>. */
  public void setIdentifiableType(String value) {
    set(3, value);
  }

  /** Getter for <code>public.geolocations.identifiable_type</code>. */
  public String getIdentifiableType() {
    return (String) get(3);
  }

  /** Setter for <code>public.geolocations.label</code>. */
  public void setLabel(JSONB value) {
    set(4, value);
  }

  /** Getter for <code>public.geolocations.label</code>. */
  public JSONB getLabel() {
    return (JSONB) get(4);
  }

  /** Setter for <code>public.geolocations.last_modified</code>. */
  public void setLastModified(LocalDateTime value) {
    set(5, value);
  }

  /** Getter for <code>public.geolocations.last_modified</code>. */
  public LocalDateTime getLastModified() {
    return (LocalDateTime) get(5);
  }

  /** Setter for <code>public.geolocations.entity_type</code>. */
  public void setEntityType(String value) {
    set(6, value);
  }

  /** Getter for <code>public.geolocations.entity_type</code>. */
  public String getEntityType() {
    return (String) get(6);
  }

  /** Setter for <code>public.geolocations.refid</code>. */
  public void setRefid(Integer value) {
    set(7, value);
  }

  /** Getter for <code>public.geolocations.refid</code>. */
  public Integer getRefid() {
    return (Integer) get(7);
  }

  /** Setter for <code>public.geolocations.previewfileresource</code>. */
  public void setPreviewfileresource(UUID value) {
    set(8, value);
  }

  /** Getter for <code>public.geolocations.previewfileresource</code>. */
  public UUID getPreviewfileresource() {
    return (UUID) get(8);
  }

  /** Setter for <code>public.geolocations.preview_hints</code>. */
  public void setPreviewHints(JSONB value) {
    set(9, value);
  }

  /** Getter for <code>public.geolocations.preview_hints</code>. */
  public JSONB getPreviewHints() {
    return (JSONB) get(9);
  }

  /** Setter for <code>public.geolocations.custom_attrs</code>. */
  public void setCustomAttrs(JSONB value) {
    set(10, value);
  }

  /** Getter for <code>public.geolocations.custom_attrs</code>. */
  public JSONB getCustomAttrs() {
    return (JSONB) get(10);
  }

  /** Setter for <code>public.geolocations.geolocation_type</code>. */
  public void setGeolocationType(String value) {
    set(11, value);
  }

  /** Getter for <code>public.geolocations.geolocation_type</code>. */
  public String getGeolocationType() {
    return (String) get(11);
  }

  /** Setter for <code>public.geolocations.coordinate_location</code>. */
  public void setCoordinateLocation(JSONB value) {
    set(12, value);
  }

  /** Getter for <code>public.geolocations.coordinate_location</code>. */
  public JSONB getCoordinateLocation() {
    return (JSONB) get(12);
  }

  // -------------------------------------------------------------------------
  // Record13 type implementation
  // -------------------------------------------------------------------------

  @Override
  public Row13<
          UUID,
          LocalDateTime,
          JSONB,
          String,
          JSONB,
          LocalDateTime,
          String,
          Integer,
          UUID,
          JSONB,
          JSONB,
          String,
          JSONB>
      fieldsRow() {
    return (Row13) super.fieldsRow();
  }

  @Override
  public Row13<
          UUID,
          LocalDateTime,
          JSONB,
          String,
          JSONB,
          LocalDateTime,
          String,
          Integer,
          UUID,
          JSONB,
          JSONB,
          String,
          JSONB>
      valuesRow() {
    return (Row13) super.valuesRow();
  }

  @Override
  public Field<UUID> field1() {
    return Geolocations.GEOLOCATIONS.UUID;
  }

  @Override
  public Field<LocalDateTime> field2() {
    return Geolocations.GEOLOCATIONS.CREATED;
  }

  @Override
  public Field<JSONB> field3() {
    return Geolocations.GEOLOCATIONS.DESCRIPTION;
  }

  @Override
  public Field<String> field4() {
    return Geolocations.GEOLOCATIONS.IDENTIFIABLE_TYPE;
  }

  @Override
  public Field<JSONB> field5() {
    return Geolocations.GEOLOCATIONS.LABEL;
  }

  @Override
  public Field<LocalDateTime> field6() {
    return Geolocations.GEOLOCATIONS.LAST_MODIFIED;
  }

  @Override
  public Field<String> field7() {
    return Geolocations.GEOLOCATIONS.ENTITY_TYPE;
  }

  @Override
  public Field<Integer> field8() {
    return Geolocations.GEOLOCATIONS.REFID;
  }

  @Override
  public Field<UUID> field9() {
    return Geolocations.GEOLOCATIONS.PREVIEWFILERESOURCE;
  }

  @Override
  public Field<JSONB> field10() {
    return Geolocations.GEOLOCATIONS.PREVIEW_HINTS;
  }

  @Override
  public Field<JSONB> field11() {
    return Geolocations.GEOLOCATIONS.CUSTOM_ATTRS;
  }

  @Override
  public Field<String> field12() {
    return Geolocations.GEOLOCATIONS.GEOLOCATION_TYPE;
  }

  @Override
  public Field<JSONB> field13() {
    return Geolocations.GEOLOCATIONS.COORDINATE_LOCATION;
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
    return getRefid();
  }

  @Override
  public UUID component9() {
    return getPreviewfileresource();
  }

  @Override
  public JSONB component10() {
    return getPreviewHints();
  }

  @Override
  public JSONB component11() {
    return getCustomAttrs();
  }

  @Override
  public String component12() {
    return getGeolocationType();
  }

  @Override
  public JSONB component13() {
    return getCoordinateLocation();
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
    return getRefid();
  }

  @Override
  public UUID value9() {
    return getPreviewfileresource();
  }

  @Override
  public JSONB value10() {
    return getPreviewHints();
  }

  @Override
  public JSONB value11() {
    return getCustomAttrs();
  }

  @Override
  public String value12() {
    return getGeolocationType();
  }

  @Override
  public JSONB value13() {
    return getCoordinateLocation();
  }

  @Override
  public GeolocationsRecord value1(UUID value) {
    setUuid(value);
    return this;
  }

  @Override
  public GeolocationsRecord value2(LocalDateTime value) {
    setCreated(value);
    return this;
  }

  @Override
  public GeolocationsRecord value3(JSONB value) {
    setDescription(value);
    return this;
  }

  @Override
  public GeolocationsRecord value4(String value) {
    setIdentifiableType(value);
    return this;
  }

  @Override
  public GeolocationsRecord value5(JSONB value) {
    setLabel(value);
    return this;
  }

  @Override
  public GeolocationsRecord value6(LocalDateTime value) {
    setLastModified(value);
    return this;
  }

  @Override
  public GeolocationsRecord value7(String value) {
    setEntityType(value);
    return this;
  }

  @Override
  public GeolocationsRecord value8(Integer value) {
    setRefid(value);
    return this;
  }

  @Override
  public GeolocationsRecord value9(UUID value) {
    setPreviewfileresource(value);
    return this;
  }

  @Override
  public GeolocationsRecord value10(JSONB value) {
    setPreviewHints(value);
    return this;
  }

  @Override
  public GeolocationsRecord value11(JSONB value) {
    setCustomAttrs(value);
    return this;
  }

  @Override
  public GeolocationsRecord value12(String value) {
    setGeolocationType(value);
    return this;
  }

  @Override
  public GeolocationsRecord value13(JSONB value) {
    setCoordinateLocation(value);
    return this;
  }

  @Override
  public GeolocationsRecord values(
      UUID value1,
      LocalDateTime value2,
      JSONB value3,
      String value4,
      JSONB value5,
      LocalDateTime value6,
      String value7,
      Integer value8,
      UUID value9,
      JSONB value10,
      JSONB value11,
      String value12,
      JSONB value13) {
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
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  /** Create a detached GeolocationsRecord */
  public GeolocationsRecord() {
    super(Geolocations.GEOLOCATIONS);
  }

  /** Create a detached, initialised GeolocationsRecord */
  public GeolocationsRecord(
      UUID uuid,
      LocalDateTime created,
      JSONB description,
      String identifiableType,
      JSONB label,
      LocalDateTime lastModified,
      String entityType,
      Integer refid,
      UUID previewfileresource,
      JSONB previewHints,
      JSONB customAttrs,
      String geolocationType,
      JSONB coordinateLocation) {
    super(Geolocations.GEOLOCATIONS);

    set(0, uuid);
    set(1, created);
    set(2, description);
    set(3, identifiableType);
    set(4, label);
    set(5, lastModified);
    set(6, entityType);
    set(7, refid);
    set(8, previewfileresource);
    set(9, previewHints);
    set(10, customAttrs);
    set(11, geolocationType);
    set(12, coordinateLocation);
  }
}
