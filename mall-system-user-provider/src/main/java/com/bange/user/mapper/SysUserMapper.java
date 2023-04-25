package com.bange.user.mapper;

import com.bange.mall.entity.user.SysUser;
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

import static com.bange.user.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, userName, pwd, loginIp, loginTime, avator, phone, email, userStatu, gender, delFlag, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SysUser> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SysUser> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_ip", property="loginIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="avator", property="avator", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_statu", property="userStatu", jdbcType=JdbcType.INTEGER),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(pwd).toProperty("pwd")
            .map(loginIp).toProperty("loginIp")
            .map(loginTime).toProperty("loginTime")
            .map(avator).toProperty("avator")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(userStatu).toProperty("userStatu")
            .map(gender).toProperty("gender")
            .map(delFlag).toProperty("delFlag")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<SysUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(pwd).toProperty("pwd")
            .map(loginIp).toProperty("loginIp")
            .map(loginTime).toProperty("loginTime")
            .map(avator).toProperty("avator")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(userStatu).toProperty("userStatu")
            .map(gender).toProperty("gender")
            .map(delFlag).toProperty("delFlag")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(SysUser record) {
        return MyBatis3Utils.insert(this::insert, record, sysUser, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(pwd).toPropertyWhenPresent("pwd", record::getPwd)
            .map(loginIp).toPropertyWhenPresent("loginIp", record::getLoginIp)
            .map(loginTime).toPropertyWhenPresent("loginTime", record::getLoginTime)
            .map(avator).toPropertyWhenPresent("avator", record::getAvator)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(userStatu).toPropertyWhenPresent("userStatu", record::getUserStatu)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(delFlag).toPropertyWhenPresent("delFlag", record::getDelFlag)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    default Optional<SysUser> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userName).equalTo(record::getUserName)
                .set(pwd).equalTo(record::getPwd)
                .set(loginIp).equalTo(record::getLoginIp)
                .set(loginTime).equalTo(record::getLoginTime)
                .set(avator).equalTo(record::getAvator)
                .set(phone).equalTo(record::getPhone)
                .set(email).equalTo(record::getEmail)
                .set(userStatu).equalTo(record::getUserStatu)
                .set(gender).equalTo(record::getGender)
                .set(delFlag).equalTo(record::getDelFlag)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(pwd).equalToWhenPresent(record::getPwd)
                .set(loginIp).equalToWhenPresent(record::getLoginIp)
                .set(loginTime).equalToWhenPresent(record::getLoginTime)
                .set(avator).equalToWhenPresent(record::getAvator)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(userStatu).equalToWhenPresent(record::getUserStatu)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(delFlag).equalToWhenPresent(record::getDelFlag)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(SysUser record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(pwd).equalTo(record::getPwd)
            .set(loginIp).equalTo(record::getLoginIp)
            .set(loginTime).equalTo(record::getLoginTime)
            .set(avator).equalTo(record::getAvator)
            .set(phone).equalTo(record::getPhone)
            .set(email).equalTo(record::getEmail)
            .set(userStatu).equalTo(record::getUserStatu)
            .set(gender).equalTo(record::getGender)
            .set(delFlag).equalTo(record::getDelFlag)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(SysUser record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(pwd).equalToWhenPresent(record::getPwd)
            .set(loginIp).equalToWhenPresent(record::getLoginIp)
            .set(loginTime).equalToWhenPresent(record::getLoginTime)
            .set(avator).equalToWhenPresent(record::getAvator)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(userStatu).equalToWhenPresent(record::getUserStatu)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(delFlag).equalToWhenPresent(record::getDelFlag)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}