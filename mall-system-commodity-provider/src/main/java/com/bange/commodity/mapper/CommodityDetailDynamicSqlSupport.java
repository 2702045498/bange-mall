package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CommodityDetailDynamicSqlSupport {
    public static final CommodityDetail commodityDetail = new CommodityDetail();

    public static final SqlColumn<Long> id = commodityDetail.id;

    public static final SqlColumn<String> bannerUrl = commodityDetail.bannerUrl;

    public static final SqlColumn<String> bannerName = commodityDetail.bannerName;

    public static final SqlColumn<Long> commodityId = commodityDetail.commodityId;

    public static final SqlColumn<LocalDateTime> createTime = commodityDetail.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = commodityDetail.updateTime;

    public static final class CommodityDetail extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> bannerUrl = column("banner_url", JDBCType.VARCHAR);

        public final SqlColumn<String> bannerName = column("banner_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> commodityId = column("commodity_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public CommodityDetail() {
            super("commodity_detail");
        }
    }
}