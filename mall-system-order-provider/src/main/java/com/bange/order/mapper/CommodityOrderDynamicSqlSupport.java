package com.bange.order.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CommodityOrderDynamicSqlSupport {
    public static final CommodityOrder commodityOrder = new CommodityOrder();

    public static final SqlColumn<Long> id = commodityOrder.id;

    public static final SqlColumn<String> orderNo = commodityOrder.orderNo;

    public static final SqlColumn<Long> userId = commodityOrder.userId;

    public static final SqlColumn<Long> commodityId = commodityOrder.commodityId;

    public static final SqlColumn<Long> specId = commodityOrder.specId;

    public static final SqlColumn<BigDecimal> payPrice = commodityOrder.payPrice;

    public static final SqlColumn<BigDecimal> activityPrice = commodityOrder.activityPrice;

    public static final SqlColumn<Long> userAddrId = commodityOrder.userAddrId;

    public static final SqlColumn<LocalDateTime> payTime = commodityOrder.payTime;

    public static final SqlColumn<Integer> payFlag = commodityOrder.payFlag;

    public static final SqlColumn<LocalDateTime> createTime = commodityOrder.createTime;

    public static final SqlColumn<LocalDateTime> orderValidTime = commodityOrder.orderValidTime;

    public static final SqlColumn<Integer> closeFlag = commodityOrder.closeFlag;

    public static final SqlColumn<LocalDateTime> updateTime = commodityOrder.updateTime;

    public static final class CommodityOrder extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> orderNo = column("order_no", JDBCType.VARCHAR);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> commodityId = column("commodity_id", JDBCType.BIGINT);

        public final SqlColumn<Long> specId = column("spec_id", JDBCType.BIGINT);

        public final SqlColumn<BigDecimal> payPrice = column("pay_price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> activityPrice = column("activity_price", JDBCType.DECIMAL);

        public final SqlColumn<Long> userAddrId = column("user_addr_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> payTime = column("pay_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> payFlag = column("pay_flag", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> orderValidTime = column("order_valid_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> closeFlag = column("close_flag", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public CommodityOrder() {
            super("commodity_order");
        }
    }
}