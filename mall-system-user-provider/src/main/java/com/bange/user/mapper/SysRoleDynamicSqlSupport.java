package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class SysRoleDynamicSqlSupport {
    public static final SysRole sysRole = new SysRole();

    public static final SqlColumn<Integer> id = sysRole.id;

    public static final SqlColumn<String> roleName = sysRole.roleName;

    public static final class SysRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public SysRole() {
            super("sys_role");
        }
    }
}