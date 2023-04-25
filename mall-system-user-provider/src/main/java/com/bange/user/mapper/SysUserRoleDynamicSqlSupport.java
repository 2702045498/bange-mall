package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class SysUserRoleDynamicSqlSupport {
    public static final SysUserRole sysUserRole = new SysUserRole();

    public static final SqlColumn<Integer> id = sysUserRole.id;

    public static final SqlColumn<Integer> roleId = sysUserRole.roleId;

    public static final SqlColumn<Long> userId = sysUserRole.userId;

    public static final class SysUserRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public SysUserRole() {
            super("sys_user_role");
        }
    }
}