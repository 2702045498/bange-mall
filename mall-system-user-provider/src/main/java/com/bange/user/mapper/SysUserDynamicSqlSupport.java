package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class SysUserDynamicSqlSupport {
    public static final SysUser sysUser = new SysUser();

    public static final SqlColumn<Long> id = sysUser.id;

    public static final SqlColumn<String> userName = sysUser.userName;

    public static final SqlColumn<String> pwd = sysUser.pwd;

    public static final SqlColumn<String> loginIp = sysUser.loginIp;

    public static final SqlColumn<LocalDateTime> loginTime = sysUser.loginTime;

    public static final SqlColumn<String> avator = sysUser.avator;

    public static final SqlColumn<String> phone = sysUser.phone;

    public static final SqlColumn<String> email = sysUser.email;

    public static final SqlColumn<Integer> userStatu = sysUser.userStatu;

    public static final SqlColumn<Integer> gender = sysUser.gender;

    public static final SqlColumn<Integer> delFlag = sysUser.delFlag;

    public static final SqlColumn<LocalDateTime> createTime = sysUser.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = sysUser.updateTime;

    public static final class SysUser extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> pwd = column("pwd", JDBCType.VARCHAR);

        public final SqlColumn<String> loginIp = column("login_ip", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> loginTime = column("login_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> avator = column("avator", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userStatu = column("user_statu", JDBCType.INTEGER);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<Integer> delFlag = column("del_flag", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public SysUser() {
            super("sys_user");
        }
    }
}