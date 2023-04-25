package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class SysRoleMenuDynamicSqlSupport {
    public static final SysRoleMenu sysRoleMenu = new SysRoleMenu();

    public static final SqlColumn<Long> id = sysRoleMenu.id;

    public static final SqlColumn<Integer> roleId = sysRoleMenu.roleId;

    public static final SqlColumn<Long> menuId = sysRoleMenu.menuId;

    public static final class SysRoleMenu extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<Long> menuId = column("menu_id", JDBCType.BIGINT);

        public SysRoleMenu() {
            super("sys_role_menu");
        }
    }
}