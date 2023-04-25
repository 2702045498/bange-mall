package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class StockDynamicSqlSupport {
    public static final Stock stock = new Stock();

    public static final SqlColumn<Long> id = stock.id;

    public static final SqlColumn<Long> specId = stock.specId;

    public static final SqlColumn<String> specCode = stock.specCode;

    public static final SqlColumn<Integer> stockCount = stock.stockCount;

    public static final SqlColumn<String> manufacturer = stock.manufacturer;

    public static final SqlColumn<LocalDateTime> productDate = stock.productDate;

    public static final SqlColumn<LocalDateTime> createTime = stock.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = stock.updateTime;

    public static final class Stock extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> specId = column("spec_id", JDBCType.BIGINT);

        public final SqlColumn<String> specCode = column("spec_code", JDBCType.VARCHAR);

        public final SqlColumn<Integer> stockCount = column("stock_count", JDBCType.INTEGER);

        public final SqlColumn<String> manufacturer = column("manufacturer", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> productDate = column("product_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Stock() {
            super("stock");
        }
    }
}