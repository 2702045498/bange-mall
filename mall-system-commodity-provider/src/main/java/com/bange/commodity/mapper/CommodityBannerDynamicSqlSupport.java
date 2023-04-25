package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CommodityBannerDynamicSqlSupport {
    public static final CommodityBanner commodityBanner = new CommodityBanner();

    public static final SqlColumn<Long> id = commodityBanner.id;

    public static final SqlColumn<String> bannerUrl = commodityBanner.bannerUrl;

    public static final SqlColumn<String> bannerName = commodityBanner.bannerName;

    public static final SqlColumn<Long> commodityId = commodityBanner.commodityId;

    public static final SqlColumn<LocalDateTime> createTime = commodityBanner.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = commodityBanner.updateTime;

    public static final class CommodityBanner extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> bannerUrl = column("banner_url", JDBCType.VARCHAR);

        public final SqlColumn<String> bannerName = column("banner_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> commodityId = column("commodity_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public CommodityBanner() {
            super("commodity_banner");
        }
    }
}