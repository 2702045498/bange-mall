package com.bange.order.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class OrderDetailDynamicSqlSupport {
    public static final OrderDetail orderDetail = new OrderDetail();

    public static final SqlColumn<Long> id = orderDetail.id;

    public static final SqlColumn<Long> orderId = orderDetail.orderId;

    public static final SqlColumn<String> orderNo = orderDetail.orderNo;

    public static final SqlColumn<Long> userId = orderDetail.userId;

    public static final SqlColumn<String> userName = orderDetail.userName;

    public static final SqlColumn<Long> commodityId = orderDetail.commodityId;

    public static final SqlColumn<String> commodityName = orderDetail.commodityName;

    public static final SqlColumn<String> commodityImg = orderDetail.commodityImg;

    public static final SqlColumn<Long> specId = orderDetail.specId;

    public static final SqlColumn<String> specName = orderDetail.specName;

    public static final SqlColumn<String> specImg = orderDetail.specImg;

    public static final SqlColumn<String> specAttrValue = orderDetail.specAttrValue;

    public static final SqlColumn<BigDecimal> payPrice = orderDetail.payPrice;

    public static final SqlColumn<BigDecimal> activityPrice = orderDetail.activityPrice;

    public static final SqlColumn<Long> userAddrId = orderDetail.userAddrId;

    public static final SqlColumn<String> userAddress = orderDetail.userAddress;

    public static final SqlColumn<LocalDateTime> payTime = orderDetail.payTime;

    public static final SqlColumn<Integer> payFlag = orderDetail.payFlag;

    public static final SqlColumn<LocalDateTime> createTime = orderDetail.createTime;

    public static final SqlColumn<LocalDateTime> orderValidTime = orderDetail.orderValidTime;

    public static final SqlColumn<Integer> closeFlag = orderDetail.closeFlag;

    public static final SqlColumn<LocalDateTime> updateTime = orderDetail.updateTime;

    public static final class OrderDetail extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderId = column("order_id", JDBCType.BIGINT);

        public final SqlColumn<String> orderNo = column("order_no", JDBCType.VARCHAR);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> commodityId = column("commodity_id", JDBCType.BIGINT);

        public final SqlColumn<String> commodityName = column("commodity_name", JDBCType.VARCHAR);

        public final SqlColumn<String> commodityImg = column("commodity_img", JDBCType.VARCHAR);

        public final SqlColumn<Long> specId = column("spec_id", JDBCType.BIGINT);

        public final SqlColumn<String> specName = column("spec_name", JDBCType.VARCHAR);

        public final SqlColumn<String> specImg = column("spec_img", JDBCType.VARCHAR);

        public final SqlColumn<String> specAttrValue = column("spec_attr_value", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> payPrice = column("pay_price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> activityPrice = column("activity_price", JDBCType.DECIMAL);

        public final SqlColumn<Long> userAddrId = column("user_addr_id", JDBCType.BIGINT);

        public final SqlColumn<String> userAddress = column("user_address", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> payTime = column("pay_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> payFlag = column("pay_flag", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> orderValidTime = column("order_valid_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> closeFlag = column("close_flag", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public OrderDetail() {
            super("order_detail");
        }
    }
}