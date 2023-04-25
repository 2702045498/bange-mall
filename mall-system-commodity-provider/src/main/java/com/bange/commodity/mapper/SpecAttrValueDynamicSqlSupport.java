package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class SpecAttrValueDynamicSqlSupport {
    public static final SpecAttrValue specAttrValue = new SpecAttrValue();

    public static final SqlColumn<Long> id = specAttrValue.id;

    public static final SqlColumn<Long> specId = specAttrValue.specId;

    public static final SqlColumn<Integer> attrValueId = specAttrValue.attrValueId;

    public static final class SpecAttrValue extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> specId = column("spec_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> attrValueId = column("attr_value_id", JDBCType.INTEGER);

        public SpecAttrValue() {
            super("spec_attr_value");
        }
    }
}