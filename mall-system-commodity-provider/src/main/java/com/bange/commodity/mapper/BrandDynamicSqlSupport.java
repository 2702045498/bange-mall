package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class BrandDynamicSqlSupport {
    public static final Brand brand = new Brand();

    public static final SqlColumn<Integer> id = brand.id;

    public static final SqlColumn<String> brandName = brand.brandName;

    public static final class Brand extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> brandName = column("brand_name", JDBCType.VARCHAR);

        public Brand() {
            super("brand");
        }
    }
}