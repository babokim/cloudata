/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.cloudata.thrift.generated;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class ThriftTableSchema implements TBase<ThriftTableSchema._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftTableSchema> {
  private static final TStruct STRUCT_DESC = new TStruct("ThriftTableSchema");

  private static final TField TABLE_NAME_FIELD_DESC = new TField("tableName", TType.STRING, (short)1);
  private static final TField DESCRIPTION_FIELD_DESC = new TField("description", TType.STRING, (short)2);
  private static final TField NUM_OF_VERSION_FIELD_DESC = new TField("numOfVersion", TType.STRING, (short)3);
  private static final TField OWNER_FIELD_DESC = new TField("owner", TType.STRING, (short)4);
  private static final TField COLUMNS_FIELD_DESC = new TField("columns", TType.LIST, (short)5);

  public String tableName;
  public String description;
  public String numOfVersion;
  public String owner;
  public List<ThriftColumnInfo> columns;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    TABLE_NAME((short)1, "tableName"),
    DESCRIPTION((short)2, "description"),
    NUM_OF_VERSION((short)3, "numOfVersion"),
    OWNER((short)4, "owner"),
    COLUMNS((short)5, "columns");

    private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byId.put((int)field._thriftId, field);
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      return byId.get(fieldId);
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
    put(_Fields.TABLE_NAME, new FieldMetaData("tableName", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(_Fields.DESCRIPTION, new FieldMetaData("description", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(_Fields.NUM_OF_VERSION, new FieldMetaData("numOfVersion", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(_Fields.OWNER, new FieldMetaData("owner", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(_Fields.COLUMNS, new FieldMetaData("columns", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, ThriftColumnInfo.class))));
  }});

  static {
    FieldMetaData.addStructMetaDataMap(ThriftTableSchema.class, metaDataMap);
  }

  public ThriftTableSchema() {
  }

  public ThriftTableSchema(
    String tableName,
    String description,
    String numOfVersion,
    String owner,
    List<ThriftColumnInfo> columns)
  {
    this();
    this.tableName = tableName;
    this.description = description;
    this.numOfVersion = numOfVersion;
    this.owner = owner;
    this.columns = columns;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftTableSchema(ThriftTableSchema other) {
    if (other.isSetTableName()) {
      this.tableName = other.tableName;
    }
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    if (other.isSetNumOfVersion()) {
      this.numOfVersion = other.numOfVersion;
    }
    if (other.isSetOwner()) {
      this.owner = other.owner;
    }
    if (other.isSetColumns()) {
      List<ThriftColumnInfo> __this__columns = new ArrayList<ThriftColumnInfo>();
      for (ThriftColumnInfo other_element : other.columns) {
        __this__columns.add(new ThriftColumnInfo(other_element));
      }
      this.columns = __this__columns;
    }
  }

  public ThriftTableSchema deepCopy() {
    return new ThriftTableSchema(this);
  }

  @Deprecated
  public ThriftTableSchema clone() {
    return new ThriftTableSchema(this);
  }

  public String getTableName() {
    return this.tableName;
  }

  public ThriftTableSchema setTableName(String tableName) {
    this.tableName = tableName;
    return this;
  }

  public void unsetTableName() {
    this.tableName = null;
  }

  /** Returns true if field tableName is set (has been asigned a value) and false otherwise */
  public boolean isSetTableName() {
    return this.tableName != null;
  }

  public void setTableNameIsSet(boolean value) {
    if (!value) {
      this.tableName = null;
    }
  }

  public String getDescription() {
    return this.description;
  }

  public ThriftTableSchema setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been asigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.description = null;
    }
  }

  public String getNumOfVersion() {
    return this.numOfVersion;
  }

  public ThriftTableSchema setNumOfVersion(String numOfVersion) {
    this.numOfVersion = numOfVersion;
    return this;
  }

  public void unsetNumOfVersion() {
    this.numOfVersion = null;
  }

  /** Returns true if field numOfVersion is set (has been asigned a value) and false otherwise */
  public boolean isSetNumOfVersion() {
    return this.numOfVersion != null;
  }

  public void setNumOfVersionIsSet(boolean value) {
    if (!value) {
      this.numOfVersion = null;
    }
  }

  public String getOwner() {
    return this.owner;
  }

  public ThriftTableSchema setOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public void unsetOwner() {
    this.owner = null;
  }

  /** Returns true if field owner is set (has been asigned a value) and false otherwise */
  public boolean isSetOwner() {
    return this.owner != null;
  }

  public void setOwnerIsSet(boolean value) {
    if (!value) {
      this.owner = null;
    }
  }

  public int getColumnsSize() {
    return (this.columns == null) ? 0 : this.columns.size();
  }

  public java.util.Iterator<ThriftColumnInfo> getColumnsIterator() {
    return (this.columns == null) ? null : this.columns.iterator();
  }

  public void addToColumns(ThriftColumnInfo elem) {
    if (this.columns == null) {
      this.columns = new ArrayList<ThriftColumnInfo>();
    }
    this.columns.add(elem);
  }

  public List<ThriftColumnInfo> getColumns() {
    return this.columns;
  }

  public ThriftTableSchema setColumns(List<ThriftColumnInfo> columns) {
    this.columns = columns;
    return this;
  }

  public void unsetColumns() {
    this.columns = null;
  }

  /** Returns true if field columns is set (has been asigned a value) and false otherwise */
  public boolean isSetColumns() {
    return this.columns != null;
  }

  public void setColumnsIsSet(boolean value) {
    if (!value) {
      this.columns = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TABLE_NAME:
      if (value == null) {
        unsetTableName();
      } else {
        setTableName((String)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    case NUM_OF_VERSION:
      if (value == null) {
        unsetNumOfVersion();
      } else {
        setNumOfVersion((String)value);
      }
      break;

    case OWNER:
      if (value == null) {
        unsetOwner();
      } else {
        setOwner((String)value);
      }
      break;

    case COLUMNS:
      if (value == null) {
        unsetColumns();
      } else {
        setColumns((List<ThriftColumnInfo>)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE_NAME:
      return getTableName();

    case DESCRIPTION:
      return getDescription();

    case NUM_OF_VERSION:
      return getNumOfVersion();

    case OWNER:
      return getOwner();

    case COLUMNS:
      return getColumns();

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case TABLE_NAME:
      return isSetTableName();
    case DESCRIPTION:
      return isSetDescription();
    case NUM_OF_VERSION:
      return isSetNumOfVersion();
    case OWNER:
      return isSetOwner();
    case COLUMNS:
      return isSetColumns();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftTableSchema)
      return this.equals((ThriftTableSchema)that);
    return false;
  }

  public boolean equals(ThriftTableSchema that) {
    if (that == null)
      return false;

    boolean this_present_tableName = true && this.isSetTableName();
    boolean that_present_tableName = true && that.isSetTableName();
    if (this_present_tableName || that_present_tableName) {
      if (!(this_present_tableName && that_present_tableName))
        return false;
      if (!this.tableName.equals(that.tableName))
        return false;
    }

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_numOfVersion = true && this.isSetNumOfVersion();
    boolean that_present_numOfVersion = true && that.isSetNumOfVersion();
    if (this_present_numOfVersion || that_present_numOfVersion) {
      if (!(this_present_numOfVersion && that_present_numOfVersion))
        return false;
      if (!this.numOfVersion.equals(that.numOfVersion))
        return false;
    }

    boolean this_present_owner = true && this.isSetOwner();
    boolean that_present_owner = true && that.isSetOwner();
    if (this_present_owner || that_present_owner) {
      if (!(this_present_owner && that_present_owner))
        return false;
      if (!this.owner.equals(that.owner))
        return false;
    }

    boolean this_present_columns = true && this.isSetColumns();
    boolean that_present_columns = true && that.isSetColumns();
    if (this_present_columns || that_present_columns) {
      if (!(this_present_columns && that_present_columns))
        return false;
      if (!this.columns.equals(that.columns))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ThriftTableSchema other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftTableSchema typedOther = (ThriftTableSchema)other;

    lastComparison = Boolean.valueOf(isSetTableName()).compareTo(isSetTableName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(tableName, typedOther.tableName);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(description, typedOther.description);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetNumOfVersion()).compareTo(isSetNumOfVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(numOfVersion, typedOther.numOfVersion);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetOwner()).compareTo(isSetOwner());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(owner, typedOther.owner);
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = Boolean.valueOf(isSetColumns()).compareTo(isSetColumns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(columns, typedOther.columns);
    if (lastComparison != 0) {
      return lastComparison;
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      _Fields fieldId = _Fields.findByThriftId(field.id);
      if (fieldId == null) {
        TProtocolUtil.skip(iprot, field.type);
      } else {
        switch (fieldId) {
          case TABLE_NAME:
            if (field.type == TType.STRING) {
              this.tableName = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case DESCRIPTION:
            if (field.type == TType.STRING) {
              this.description = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case NUM_OF_VERSION:
            if (field.type == TType.STRING) {
              this.numOfVersion = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case OWNER:
            if (field.type == TType.STRING) {
              this.owner = iprot.readString();
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          case COLUMNS:
            if (field.type == TType.LIST) {
              {
                TList _list0 = iprot.readListBegin();
                this.columns = new ArrayList<ThriftColumnInfo>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  ThriftColumnInfo _elem2;
                  _elem2 = new ThriftColumnInfo();
                  _elem2.read(iprot);
                  this.columns.add(_elem2);
                }
                iprot.readListEnd();
              }
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
        }
        iprot.readFieldEnd();
      }
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.tableName != null) {
      oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
      oprot.writeString(this.tableName);
      oprot.writeFieldEnd();
    }
    if (this.description != null) {
      oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
      oprot.writeString(this.description);
      oprot.writeFieldEnd();
    }
    if (this.numOfVersion != null) {
      oprot.writeFieldBegin(NUM_OF_VERSION_FIELD_DESC);
      oprot.writeString(this.numOfVersion);
      oprot.writeFieldEnd();
    }
    if (this.owner != null) {
      oprot.writeFieldBegin(OWNER_FIELD_DESC);
      oprot.writeString(this.owner);
      oprot.writeFieldEnd();
    }
    if (this.columns != null) {
      oprot.writeFieldBegin(COLUMNS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.columns.size()));
        for (ThriftColumnInfo _iter3 : this.columns)
        {
          _iter3.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftTableSchema(");
    boolean first = true;

    sb.append("tableName:");
    if (this.tableName == null) {
      sb.append("null");
    } else {
      sb.append(this.tableName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("description:");
    if (this.description == null) {
      sb.append("null");
    } else {
      sb.append(this.description);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("numOfVersion:");
    if (this.numOfVersion == null) {
      sb.append("null");
    } else {
      sb.append(this.numOfVersion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("owner:");
    if (this.owner == null) {
      sb.append("null");
    } else {
      sb.append(this.owner);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("columns:");
    if (this.columns == null) {
      sb.append("null");
    } else {
      sb.append(this.columns);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

