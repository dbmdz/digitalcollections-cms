/*
 * This file is generated by jOOQ.
 */
package de.digitalcollections.cudami.server.backend.impl.jooq.db.tables;

import de.digitalcollections.cudami.server.backend.impl.jooq.db.Keys;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.Public;
import de.digitalcollections.cudami.server.backend.impl.jooq.db.tables.records.IdentifiertypesRecord;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Identifiertypes extends TableImpl<IdentifiertypesRecord> {

  private static final long serialVersionUID = 804047777;

  /** The reference instance of <code>public.identifiertypes</code> */
  public static final Identifiertypes IDENTIFIERTYPES = new Identifiertypes();

  /** The class holding records for this type */
  @Override
  public Class<IdentifiertypesRecord> getRecordType() {
    return IdentifiertypesRecord.class;
  }

  /** The column <code>public.identifiertypes.label</code>. */
  public final TableField<IdentifiertypesRecord, String> LABEL =
      createField(DSL.name("label"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

  /** The column <code>public.identifiertypes.namespace</code>. */
  public final TableField<IdentifiertypesRecord, String> NAMESPACE =
      createField(
          DSL.name("namespace"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

  /** The column <code>public.identifiertypes.pattern</code>. */
  public final TableField<IdentifiertypesRecord, String> PATTERN =
      createField(DSL.name("pattern"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

  /** The column <code>public.identifiertypes.uuid</code>. */
  public final TableField<IdentifiertypesRecord, UUID> UUID =
      createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

  /** Create a <code>public.identifiertypes</code> table reference */
  public Identifiertypes() {
    this(DSL.name("identifiertypes"), null);
  }

  /** Create an aliased <code>public.identifiertypes</code> table reference */
  public Identifiertypes(String alias) {
    this(DSL.name(alias), IDENTIFIERTYPES);
  }

  /** Create an aliased <code>public.identifiertypes</code> table reference */
  public Identifiertypes(Name alias) {
    this(alias, IDENTIFIERTYPES);
  }

  private Identifiertypes(Name alias, Table<IdentifiertypesRecord> aliased) {
    this(alias, aliased, null);
  }

  private Identifiertypes(Name alias, Table<IdentifiertypesRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  public <O extends Record> Identifiertypes(
      Table<O> child, ForeignKey<O, IdentifiertypesRecord> key) {
    super(child, key, IDENTIFIERTYPES);
  }

  @Override
  public Schema getSchema() {
    return Public.PUBLIC;
  }

  @Override
  public UniqueKey<IdentifiertypesRecord> getPrimaryKey() {
    return Keys.IDENTIFIERTYPES_PKEY;
  }

  @Override
  public List<UniqueKey<IdentifiertypesRecord>> getKeys() {
    return Arrays.<UniqueKey<IdentifiertypesRecord>>asList(
        Keys.IDENTIFIERTYPES_NAMESPACE_KEY, Keys.IDENTIFIERTYPES_PKEY);
  }

  @Override
  public Identifiertypes as(String alias) {
    return new Identifiertypes(DSL.name(alias), this);
  }

  @Override
  public Identifiertypes as(Name alias) {
    return new Identifiertypes(alias, this);
  }

  /** Rename this table */
  @Override
  public Identifiertypes rename(String name) {
    return new Identifiertypes(DSL.name(name), null);
  }

  /** Rename this table */
  @Override
  public Identifiertypes rename(Name name) {
    return new Identifiertypes(name, null);
  }

  // -------------------------------------------------------------------------
  // Row4 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row4<String, String, String, UUID> fieldsRow() {
    return (Row4) super.fieldsRow();
  }
}
