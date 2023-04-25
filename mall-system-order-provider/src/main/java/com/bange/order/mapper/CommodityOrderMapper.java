package com.bange.order.mapper;

import com.bange.mall.entity.order.CommodityOrder;
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


import static com.bange.order.mapper.CommodityOrderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CommodityOrderMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, orderNo, userId, commodityId, specId, payPrice, activityPrice, userAddrId, payTime, payFlag, createTime, orderValidTime, closeFlag, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CommodityOrder> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CommodityOrder> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommodityOrderResult")
    Optional<CommodityOrder> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommodityOrderResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.BIGINT),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="activity_price", property="activityPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="user_addr_id", property="userAddrId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_flag", property="payFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_valid_time", property="orderValidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="close_flag", property="closeFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommodityOrder> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, commodityOrder, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, commodityOrder, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(CommodityOrder record) {
        return MyBatis3Utils.insert(this::insert, record, commodityOrder, c ->
            c.map(id).toProperty("id")
            .map(orderNo).toProperty("orderNo")
            .map(userId).toProperty("userId")
            .map(commodityId).toProperty("commodityId")
            .map(specId).toProperty("specId")
            .map(payPrice).toProperty("payPrice")
            .map(activityPrice).toProperty("activityPrice")
            .map(userAddrId).toProperty("userAddrId")
            .map(payTime).toProperty("payTime")
            .map(payFlag).toProperty("payFlag")
            .map(createTime).toProperty("createTime")
            .map(orderValidTime).toProperty("orderValidTime")
            .map(closeFlag).toProperty("closeFlag")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<CommodityOrder> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, commodityOrder, c ->
            c.map(id).toProperty("id")
            .map(orderNo).toProperty("orderNo")
            .map(userId).toProperty("userId")
            .map(commodityId).toProperty("commodityId")
            .map(specId).toProperty("specId")
            .map(payPrice).toProperty("payPrice")
            .map(activityPrice).toProperty("activityPrice")
            .map(userAddrId).toProperty("userAddrId")
            .map(payTime).toProperty("payTime")
            .map(payFlag).toProperty("payFlag")
            .map(createTime).toProperty("createTime")
            .map(orderValidTime).toProperty("orderValidTime")
            .map(closeFlag).toProperty("closeFlag")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(CommodityOrder record) {
        return MyBatis3Utils.insert(this::insert, record, commodityOrder, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderNo).toPropertyWhenPresent("orderNo", record::getOrderNo)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(commodityId).toPropertyWhenPresent("commodityId", record::getCommodityId)
            .map(specId).toPropertyWhenPresent("specId", record::getSpecId)
            .map(payPrice).toPropertyWhenPresent("payPrice", record::getPayPrice)
            .map(activityPrice).toPropertyWhenPresent("activityPrice", record::getActivityPrice)
            .map(userAddrId).toPropertyWhenPresent("userAddrId", record::getUserAddrId)
            .map(payTime).toPropertyWhenPresent("payTime", record::getPayTime)
            .map(payFlag).toPropertyWhenPresent("payFlag", record::getPayFlag)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(orderValidTime).toPropertyWhenPresent("orderValidTime", record::getOrderValidTime)
            .map(closeFlag).toPropertyWhenPresent("closeFlag", record::getCloseFlag)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<CommodityOrder> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, commodityOrder, completer);
    }

    default List<CommodityOrder> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, commodityOrder, completer);
    }

    default List<CommodityOrder> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, commodityOrder, completer);
    }

    default Optional<CommodityOrder> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, commodityOrder, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(CommodityOrder record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderNo).equalTo(record::getOrderNo)
                .set(userId).equalTo(record::getUserId)
                .set(commodityId).equalTo(record::getCommodityId)
                .set(specId).equalTo(record::getSpecId)
                .set(payPrice).equalTo(record::getPayPrice)
                .set(activityPrice).equalTo(record::getActivityPrice)
                .set(userAddrId).equalTo(record::getUserAddrId)
                .set(payTime).equalTo(record::getPayTime)
                .set(payFlag).equalTo(record::getPayFlag)
                .set(createTime).equalTo(record::getCreateTime)
                .set(orderValidTime).equalTo(record::getOrderValidTime)
                .set(closeFlag).equalTo(record::getCloseFlag)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(CommodityOrder record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderNo).equalToWhenPresent(record::getOrderNo)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(commodityId).equalToWhenPresent(record::getCommodityId)
                .set(specId).equalToWhenPresent(record::getSpecId)
                .set(payPrice).equalToWhenPresent(record::getPayPrice)
                .set(activityPrice).equalToWhenPresent(record::getActivityPrice)
                .set(userAddrId).equalToWhenPresent(record::getUserAddrId)
                .set(payTime).equalToWhenPresent(record::getPayTime)
                .set(payFlag).equalToWhenPresent(record::getPayFlag)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(orderValidTime).equalToWhenPresent(record::getOrderValidTime)
                .set(closeFlag).equalToWhenPresent(record::getCloseFlag)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(CommodityOrder record) {
        return update(c ->
            c.set(orderNo).equalTo(record::getOrderNo)
            .set(userId).equalTo(record::getUserId)
            .set(commodityId).equalTo(record::getCommodityId)
            .set(specId).equalTo(record::getSpecId)
            .set(payPrice).equalTo(record::getPayPrice)
            .set(activityPrice).equalTo(record::getActivityPrice)
            .set(userAddrId).equalTo(record::getUserAddrId)
            .set(payTime).equalTo(record::getPayTime)
            .set(payFlag).equalTo(record::getPayFlag)
            .set(createTime).equalTo(record::getCreateTime)
            .set(orderValidTime).equalTo(record::getOrderValidTime)
            .set(closeFlag).equalTo(record::getCloseFlag)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(CommodityOrder record) {
        return update(c ->
            c.set(orderNo).equalToWhenPresent(record::getOrderNo)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(commodityId).equalToWhenPresent(record::getCommodityId)
            .set(specId).equalToWhenPresent(record::getSpecId)
            .set(payPrice).equalToWhenPresent(record::getPayPrice)
            .set(activityPrice).equalToWhenPresent(record::getActivityPrice)
            .set(userAddrId).equalToWhenPresent(record::getUserAddrId)
            .set(payTime).equalToWhenPresent(record::getPayTime)
            .set(payFlag).equalToWhenPresent(record::getPayFlag)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(orderValidTime).equalToWhenPresent(record::getOrderValidTime)
            .set(closeFlag).equalToWhenPresent(record::getCloseFlag)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}