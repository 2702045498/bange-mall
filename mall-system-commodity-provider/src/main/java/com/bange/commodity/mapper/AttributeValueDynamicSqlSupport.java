package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class AttributeValueDynamicSqlSupport {
    public static final AttributeValue attributeValue = new AttributeValue();

    public static final SqlColumn<Integer> id = attributeValue.id;

    public static final SqlColumn<Integer> attrId = attributeValue.attrId;

    public static final SqlColumn<String> attrValue = attributeValue.attrValue;

    public static final class AttributeValue extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> attrId = column("attr_id", JDBCType.INTEGER);

        public final SqlColumn<String> attrValue = column("attr_value", JDBCType.VARCHAR);

        public AttributeValue() {
            super("attribute_value");
        }
    }
}