package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class AttributeDynamicSqlSupport {
    public static final Attribute attribute = new Attribute();

    public static final SqlColumn<Integer> id = attribute.id;

    public static final SqlColumn<String> attrName = attribute.attrName;

    public static final class Attribute extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> attrName = column("attr_name", JDBCType.VARCHAR);

        public Attribute() {
            super("attribute");
        }
    }
}