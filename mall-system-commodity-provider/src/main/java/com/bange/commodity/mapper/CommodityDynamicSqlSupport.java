package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CommodityDynamicSqlSupport {
    public static final Commodity commodity = new Commodity();

    public static final SqlColumn<Long> id = commodity.id;

    public static final SqlColumn<String> commdityCode = commodity.commdityCode;

    public static final SqlColumn<String> commdityName = commodity.commdityName;

    public static final SqlColumn<String> commdodityImg = commodity.commdodityImg;

    public static final SqlColumn<LocalDateTime> createTime = commodity.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = commodity.updateTime;

    public static final class Commodity extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> commdityCode = column("commdity_code", JDBCType.VARCHAR);

        public final SqlColumn<String> commdityName = column("commdity_name", JDBCType.VARCHAR);

        public final SqlColumn<String> commdodityImg = column("commdodity_img", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Commodity() {
            super("commodity");
        }
    }
}