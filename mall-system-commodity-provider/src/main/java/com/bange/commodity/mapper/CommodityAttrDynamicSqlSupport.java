package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CommodityAttrDynamicSqlSupport {
    public static final CommodityAttr commodityAttr = new CommodityAttr();

    public static final SqlColumn<Long> id = commodityAttr.id;

    public static final SqlColumn<Long> commdityId = commodityAttr.commdityId;

    public static final SqlColumn<Integer> attrId = commodityAttr.attrId;

    public static final class CommodityAttr extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> commdityId = column("commdity_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> attrId = column("attr_id", JDBCType.INTEGER);

        public CommodityAttr() {
            super("commodity_attr");
        }
    }
}