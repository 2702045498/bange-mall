package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class SpecDynamicSqlSupport {
    public static final Spec spec = new Spec();

    public static final SqlColumn<Long> id = spec.id;

    public static final SqlColumn<String> specCode = spec.specCode;

    public static final SqlColumn<String> specName = spec.specName;

    public static final SqlColumn<String> markImg = spec.markImg;

    public static final SqlColumn<Integer> displayMark = spec.displayMark;

    public static final SqlColumn<Long> commodityId = spec.commodityId;

    public static final SqlColumn<LocalDateTime> createTime = spec.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = spec.updateTime;

    public static final class Spec extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> specCode = column("spec_code", JDBCType.VARCHAR);

        public final SqlColumn<String> specName = column("spec_name", JDBCType.VARCHAR);

        public final SqlColumn<String> markImg = column("mark_img", JDBCType.VARCHAR);

        public final SqlColumn<Integer> displayMark = column("display_mark", JDBCType.INTEGER);

        public final SqlColumn<Long> commodityId = column("commodity_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Spec() {
            super("spec");
        }
    }
}