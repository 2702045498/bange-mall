package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class SysMenuDynamicSqlSupport {
    public static final SysMenu sysMenu = new SysMenu();

    public static final SqlColumn<Long> id = sysMenu.id;

    public static final SqlColumn<String> menuName = sysMenu.menuName;

    public static final SqlColumn<Long> parentId = sysMenu.parentId;

    public static final SqlColumn<Integer> orderNum = sysMenu.orderNum;

    public static final SqlColumn<String> path = sysMenu.path;

    public static final SqlColumn<String> component = sysMenu.component;

    public static final SqlColumn<String> menuType = sysMenu.menuType;

    public static final SqlColumn<String> perms = sysMenu.perms;

    public static final SqlColumn<String> icon = sysMenu.icon;

    public static final SqlColumn<LocalDateTime> createTime = sysMenu.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = sysMenu.updateTime;

    public static final class SysMenu extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> menuName = column("menu_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> orderNum = column("order_num", JDBCType.INTEGER);

        public final SqlColumn<String> path = column("path", JDBCType.VARCHAR);

        public final SqlColumn<String> component = column("component", JDBCType.VARCHAR);

        public final SqlColumn<String> menuType = column("menu_type", JDBCType.VARCHAR);

        public final SqlColumn<String> perms = column("perms", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public SysMenu() {
            super("sys_menu");
        }
    }
}