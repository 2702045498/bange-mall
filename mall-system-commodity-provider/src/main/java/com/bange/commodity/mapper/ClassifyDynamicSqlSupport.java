package com.bange.commodity.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ClassifyDynamicSqlSupport {
    public static final Classify classify = new Classify();

    public static final SqlColumn<Integer> id = classify.id;

    public static final SqlColumn<String> classifyName = classify.classifyName;

    public static final SqlColumn<Integer> parentId = classify.parentId;

    public static final class Classify extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> classifyName = column("classify_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> parentId = column("parent_id", JDBCType.INTEGER);

        public Classify() {
            super("classify");
        }
    }
}