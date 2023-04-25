package com.bange.user.mapper;

import com.bange.mall.entity.system.SysMenu;
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

import static com.bange.user.mapper.SysMenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysMenuMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, menuName, parentId, orderNum, path, component, menuType, perms, icon, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SysMenu> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SysMenu> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysMenuResult")
    Optional<SysMenu> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysMenuResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_num", property="orderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.VARCHAR),
        @Result(column="perms", property="perms", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysMenu> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysMenu, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysMenu, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(SysMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysMenu, c ->
            c.map(id).toProperty("id")
            .map(menuName).toProperty("menuName")
            .map(parentId).toProperty("parentId")
            .map(orderNum).toProperty("orderNum")
            .map(path).toProperty("path")
            .map(component).toProperty("component")
            .map(menuType).toProperty("menuType")
            .map(perms).toProperty("perms")
            .map(icon).toProperty("icon")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<SysMenu> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysMenu, c ->
            c.map(id).toProperty("id")
            .map(menuName).toProperty("menuName")
            .map(parentId).toProperty("parentId")
            .map(orderNum).toProperty("orderNum")
            .map(path).toProperty("path")
            .map(component).toProperty("component")
            .map(menuType).toProperty("menuType")
            .map(perms).toProperty("perms")
            .map(icon).toProperty("icon")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(SysMenu record) {
        return MyBatis3Utils.insert(this::insert, record, sysMenu, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(menuName).toPropertyWhenPresent("menuName", record::getMenuName)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(orderNum).toPropertyWhenPresent("orderNum", record::getOrderNum)
            .map(path).toPropertyWhenPresent("path", record::getPath)
            .map(component).toPropertyWhenPresent("component", record::getComponent)
            .map(menuType).toPropertyWhenPresent("menuType", record::getMenuType)
            .map(perms).toPropertyWhenPresent("perms", record::getPerms)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<SysMenu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysMenu, completer);
    }

    default List<SysMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysMenu, completer);
    }

    default List<SysMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysMenu, completer);
    }

    default Optional<SysMenu> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysMenu, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(SysMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(menuName).equalTo(record::getMenuName)
                .set(parentId).equalTo(record::getParentId)
                .set(orderNum).equalTo(record::getOrderNum)
                .set(path).equalTo(record::getPath)
                .set(component).equalTo(record::getComponent)
                .set(menuType).equalTo(record::getMenuType)
                .set(perms).equalTo(record::getPerms)
                .set(icon).equalTo(record::getIcon)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(menuName).equalToWhenPresent(record::getMenuName)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(orderNum).equalToWhenPresent(record::getOrderNum)
                .set(path).equalToWhenPresent(record::getPath)
                .set(component).equalToWhenPresent(record::getComponent)
                .set(menuType).equalToWhenPresent(record::getMenuType)
                .set(perms).equalToWhenPresent(record::getPerms)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(SysMenu record) {
        return update(c ->
            c.set(menuName).equalTo(record::getMenuName)
            .set(parentId).equalTo(record::getParentId)
            .set(orderNum).equalTo(record::getOrderNum)
            .set(path).equalTo(record::getPath)
            .set(component).equalTo(record::getComponent)
            .set(menuType).equalTo(record::getMenuType)
            .set(perms).equalTo(record::getPerms)
            .set(icon).equalTo(record::getIcon)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(SysMenu record) {
        return update(c ->
            c.set(menuName).equalToWhenPresent(record::getMenuName)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .set(orderNum).equalToWhenPresent(record::getOrderNum)
            .set(path).equalToWhenPresent(record::getPath)
            .set(component).equalToWhenPresent(record::getComponent)
            .set(menuType).equalToWhenPresent(record::getMenuType)
            .set(perms).equalToWhenPresent(record::getPerms)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}