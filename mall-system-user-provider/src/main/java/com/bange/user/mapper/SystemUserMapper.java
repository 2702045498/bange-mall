package com.bange.user.mapper;


import com.bange.mall.entity.user.SystemUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.bange.user.mapper.SystemUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
@Mapper
public interface SystemUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, userName, nickName, avatar, gender, pwd, phone, email, userStatus, delFlag, userType, loginIp, loginTime, createTime, updateTime);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SystemUser> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SystemUser> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SystemUserResult")
    Optional<SystemUser> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SystemUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType= JdbcType.INTEGER),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.INTEGER),
        @Result(column="login_ip", property="loginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemUser> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, systemUser, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, systemUser, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(SystemUser record) {
        return MyBatis3Utils.insert(this::insert, record, systemUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(nickName).toProperty("nickName")
            .map(avatar).toProperty("avatar")
            .map(gender).toProperty("gender")
            .map(pwd).toProperty("pwd")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(userStatus).toProperty("userStatus")
            .map(delFlag).toProperty("delFlag")
            .map(userType).toProperty("userType")
            .map(loginIp).toProperty("loginIp")
            .map(loginTime).toProperty("loginTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<SystemUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, systemUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(nickName).toProperty("nickName")
            .map(avatar).toProperty("avatar")
            .map(gender).toProperty("gender")
            .map(pwd).toProperty("pwd")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(userStatus).toProperty("userStatus")
            .map(delFlag).toProperty("delFlag")
            .map(userType).toProperty("userType")
            .map(loginIp).toProperty("loginIp")
            .map(loginTime).toProperty("loginTime")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(SystemUser record) {
        return MyBatis3Utils.insert(this::insert, record, systemUser, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(nickName).toPropertyWhenPresent("nickName", record::getNickName)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(pwd).toPropertyWhenPresent("pwd", record::getPwd)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(userStatus).toPropertyWhenPresent("userStatus", record::getUserStatus)
            .map(delFlag).toPropertyWhenPresent("delFlag", record::getDelFlag)
            .map(userType).toPropertyWhenPresent("userType", record::getUserType)
            .map(loginIp).toPropertyWhenPresent("loginIp", record::getLoginIp)
            .map(loginTime).toPropertyWhenPresent("loginTime", record::getLoginTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<SystemUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, systemUser, completer);
    }

    default List<SystemUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, systemUser, completer);
    }

    default List<SystemUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, systemUser, completer);
    }

    default Optional<SystemUser> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, systemUser, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(SystemUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userName).equalTo(record::getUserName)
                .set(nickName).equalTo(record::getNickName)
                .set(avatar).equalTo(record::getAvatar)
                .set(gender).equalTo(record::getGender)
                .set(pwd).equalTo(record::getPwd)
                .set(phone).equalTo(record::getPhone)
                .set(email).equalTo(record::getEmail)
                .set(userStatus).equalTo(record::getUserStatus)
                .set(delFlag).equalTo(record::getDelFlag)
                .set(userType).equalTo(record::getUserType)
                .set(loginIp).equalTo(record::getLoginIp)
                .set(loginTime).equalTo(record::getLoginTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(SystemUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(nickName).equalToWhenPresent(record::getNickName)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(pwd).equalToWhenPresent(record::getPwd)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(userStatus).equalToWhenPresent(record::getUserStatus)
                .set(delFlag).equalToWhenPresent(record::getDelFlag)
                .set(userType).equalToWhenPresent(record::getUserType)
                .set(loginIp).equalToWhenPresent(record::getLoginIp)
                .set(loginTime).equalToWhenPresent(record::getLoginTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(SystemUser record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(nickName).equalTo(record::getNickName)
            .set(avatar).equalTo(record::getAvatar)
            .set(gender).equalTo(record::getGender)
            .set(pwd).equalTo(record::getPwd)
            .set(phone).equalTo(record::getPhone)
            .set(email).equalTo(record::getEmail)
            .set(userStatus).equalTo(record::getUserStatus)
            .set(delFlag).equalTo(record::getDelFlag)
            .set(userType).equalTo(record::getUserType)
            .set(loginIp).equalTo(record::getLoginIp)
            .set(loginTime).equalTo(record::getLoginTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(SystemUser record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(nickName).equalToWhenPresent(record::getNickName)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(pwd).equalToWhenPresent(record::getPwd)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(userStatus).equalToWhenPresent(record::getUserStatus)
            .set(delFlag).equalToWhenPresent(record::getDelFlag)
            .set(userType).equalToWhenPresent(record::getUserType)
            .set(loginIp).equalToWhenPresent(record::getLoginIp)
            .set(loginTime).equalToWhenPresent(record::getLoginTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}