package com.bange.user.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class SystemUserDynamicSqlSupport {
    public static final SystemUser systemUser = new SystemUser();

    public static final SqlColumn<Long> id = systemUser.id;

    public static final SqlColumn<String> userName = systemUser.userName;

    public static final SqlColumn<String> nickName = systemUser.nickName;

    public static final SqlColumn<String> avatar = systemUser.avatar;

    public static final SqlColumn<Integer> gender = systemUser.gender;

    public static final SqlColumn<String> pwd = systemUser.pwd;

    public static final SqlColumn<String> phone = systemUser.phone;

    public static final SqlColumn<String> email = systemUser.email;

    public static final SqlColumn<Integer> userStatus = systemUser.userStatus;

    public static final SqlColumn<Integer> delFlag = systemUser.delFlag;

    public static final SqlColumn<Integer> userType = systemUser.userType;

    public static final SqlColumn<String> loginIp = systemUser.loginIp;

    public static final SqlColumn<LocalDateTime> loginTime = systemUser.loginTime;

    public static final SqlColumn<LocalDateTime> createTime = systemUser.createTime;

    public static final SqlColumn<LocalDateTime> updateTime = systemUser.updateTime;

    public static final class SystemUser extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<String> pwd = column("pwd", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userStatus = column("user_status", JDBCType.INTEGER);

        public final SqlColumn<Integer> delFlag = column("del_flag", JDBCType.INTEGER);

        public final SqlColumn<Integer> userType = column("user_type", JDBCType.INTEGER);

        public final SqlColumn<String> loginIp = column("login_ip", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> loginTime = column("login_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public SystemUser() {
            super("system_user");
        }
    }
}