package com.bange.order.mapper;

import com.bange.mall.entity.order.OrderDetail;
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

import static com.bange.order.mapper.OrderDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface OrderDetailMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, orderId, orderNo, userId, userName, commodityId, commodityName, commodityImg, specId, specName, specImg, specAttrValue, payPrice, activityPrice, userAddrId, userAddress, payTime, payFlag, createTime, orderValidTime, closeFlag, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<OrderDetail> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<OrderDetail> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderDetailResult")
    Optional<OrderDetail> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderDetailResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.BIGINT),
        @Result(column="commodity_name", property="commodityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="commodity_img", property="commodityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.BIGINT),
        @Result(column="spec_name", property="specName", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_img", property="specImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_attr_value", property="specAttrValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="activity_price", property="activityPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="user_addr_id", property="userAddrId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_flag", property="payFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_valid_time", property="orderValidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="close_flag", property="closeFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderDetail> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderDetail, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orderDetail, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(OrderDetail record) {
        return MyBatis3Utils.insert(this::insert, record, orderDetail, c ->
            c.map(id).toProperty("id")
            .map(orderId).toProperty("orderId")
            .map(orderNo).toProperty("orderNo")
            .map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(commodityId).toProperty("commodityId")
            .map(commodityName).toProperty("commodityName")
            .map(commodityImg).toProperty("commodityImg")
            .map(specId).toProperty("specId")
            .map(specName).toProperty("specName")
            .map(specImg).toProperty("specImg")
            .map(specAttrValue).toProperty("specAttrValue")
            .map(payPrice).toProperty("payPrice")
            .map(activityPrice).toProperty("activityPrice")
            .map(userAddrId).toProperty("userAddrId")
            .map(userAddress).toProperty("userAddress")
            .map(payTime).toProperty("payTime")
            .map(payFlag).toProperty("payFlag")
            .map(createTime).toProperty("createTime")
            .map(orderValidTime).toProperty("orderValidTime")
            .map(closeFlag).toProperty("closeFlag")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<OrderDetail> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderDetail, c ->
            c.map(id).toProperty("id")
            .map(orderId).toProperty("orderId")
            .map(orderNo).toProperty("orderNo")
            .map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(commodityId).toProperty("commodityId")
            .map(commodityName).toProperty("commodityName")
            .map(commodityImg).toProperty("commodityImg")
            .map(specId).toProperty("specId")
            .map(specName).toProperty("specName")
            .map(specImg).toProperty("specImg")
            .map(specAttrValue).toProperty("specAttrValue")
            .map(payPrice).toProperty("payPrice")
            .map(activityPrice).toProperty("activityPrice")
            .map(userAddrId).toProperty("userAddrId")
            .map(userAddress).toProperty("userAddress")
            .map(payTime).toProperty("payTime")
            .map(payFlag).toProperty("payFlag")
            .map(createTime).toProperty("createTime")
            .map(orderValidTime).toProperty("orderValidTime")
            .map(closeFlag).toProperty("closeFlag")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(OrderDetail record) {
        return MyBatis3Utils.insert(this::insert, record, orderDetail, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(orderId).toPropertyWhenPresent("orderId", record::getOrderId)
            .map(orderNo).toPropertyWhenPresent("orderNo", record::getOrderNo)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(commodityId).toPropertyWhenPresent("commodityId", record::getCommodityId)
            .map(commodityName).toPropertyWhenPresent("commodityName", record::getCommodityName)
            .map(commodityImg).toPropertyWhenPresent("commodityImg", record::getCommodityImg)
            .map(specId).toPropertyWhenPresent("specId", record::getSpecId)
            .map(specName).toPropertyWhenPresent("specName", record::getSpecName)
            .map(specImg).toPropertyWhenPresent("specImg", record::getSpecImg)
            .map(specAttrValue).toPropertyWhenPresent("specAttrValue", record::getSpecAttrValue)
            .map(payPrice).toPropertyWhenPresent("payPrice", record::getPayPrice)
            .map(activityPrice).toPropertyWhenPresent("activityPrice", record::getActivityPrice)
            .map(userAddrId).toPropertyWhenPresent("userAddrId", record::getUserAddrId)
            .map(userAddress).toPropertyWhenPresent("userAddress", record::getUserAddress)
            .map(payTime).toPropertyWhenPresent("payTime", record::getPayTime)
            .map(payFlag).toPropertyWhenPresent("payFlag", record::getPayFlag)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(orderValidTime).toPropertyWhenPresent("orderValidTime", record::getOrderValidTime)
            .map(closeFlag).toPropertyWhenPresent("closeFlag", record::getCloseFlag)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<OrderDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderDetail, completer);
    }

    default List<OrderDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderDetail, completer);
    }

    default List<OrderDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderDetail, completer);
    }

    default Optional<OrderDetail> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderDetail, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(OrderDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(orderId).equalTo(record::getOrderId)
                .set(orderNo).equalTo(record::getOrderNo)
                .set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(commodityId).equalTo(record::getCommodityId)
                .set(commodityName).equalTo(record::getCommodityName)
                .set(commodityImg).equalTo(record::getCommodityImg)
                .set(specId).equalTo(record::getSpecId)
                .set(specName).equalTo(record::getSpecName)
                .set(specImg).equalTo(record::getSpecImg)
                .set(specAttrValue).equalTo(record::getSpecAttrValue)
                .set(payPrice).equalTo(record::getPayPrice)
                .set(activityPrice).equalTo(record::getActivityPrice)
                .set(userAddrId).equalTo(record::getUserAddrId)
                .set(userAddress).equalTo(record::getUserAddress)
                .set(payTime).equalTo(record::getPayTime)
                .set(payFlag).equalTo(record::getPayFlag)
                .set(createTime).equalTo(record::getCreateTime)
                .set(orderValidTime).equalTo(record::getOrderValidTime)
                .set(closeFlag).equalTo(record::getCloseFlag)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(orderId).equalToWhenPresent(record::getOrderId)
                .set(orderNo).equalToWhenPresent(record::getOrderNo)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(commodityId).equalToWhenPresent(record::getCommodityId)
                .set(commodityName).equalToWhenPresent(record::getCommodityName)
                .set(commodityImg).equalToWhenPresent(record::getCommodityImg)
                .set(specId).equalToWhenPresent(record::getSpecId)
                .set(specName).equalToWhenPresent(record::getSpecName)
                .set(specImg).equalToWhenPresent(record::getSpecImg)
                .set(specAttrValue).equalToWhenPresent(record::getSpecAttrValue)
                .set(payPrice).equalToWhenPresent(record::getPayPrice)
                .set(activityPrice).equalToWhenPresent(record::getActivityPrice)
                .set(userAddrId).equalToWhenPresent(record::getUserAddrId)
                .set(userAddress).equalToWhenPresent(record::getUserAddress)
                .set(payTime).equalToWhenPresent(record::getPayTime)
                .set(payFlag).equalToWhenPresent(record::getPayFlag)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(orderValidTime).equalToWhenPresent(record::getOrderValidTime)
                .set(closeFlag).equalToWhenPresent(record::getCloseFlag)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(OrderDetail record) {
        return update(c ->
            c.set(orderId).equalTo(record::getOrderId)
            .set(orderNo).equalTo(record::getOrderNo)
            .set(userId).equalTo(record::getUserId)
            .set(userName).equalTo(record::getUserName)
            .set(commodityId).equalTo(record::getCommodityId)
            .set(commodityName).equalTo(record::getCommodityName)
            .set(commodityImg).equalTo(record::getCommodityImg)
            .set(specId).equalTo(record::getSpecId)
            .set(specName).equalTo(record::getSpecName)
            .set(specImg).equalTo(record::getSpecImg)
            .set(specAttrValue).equalTo(record::getSpecAttrValue)
            .set(payPrice).equalTo(record::getPayPrice)
            .set(activityPrice).equalTo(record::getActivityPrice)
            .set(userAddrId).equalTo(record::getUserAddrId)
            .set(userAddress).equalTo(record::getUserAddress)
            .set(payTime).equalTo(record::getPayTime)
            .set(payFlag).equalTo(record::getPayFlag)
            .set(createTime).equalTo(record::getCreateTime)
            .set(orderValidTime).equalTo(record::getOrderValidTime)
            .set(closeFlag).equalTo(record::getCloseFlag)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(OrderDetail record) {
        return update(c ->
            c.set(orderId).equalToWhenPresent(record::getOrderId)
            .set(orderNo).equalToWhenPresent(record::getOrderNo)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(userName).equalToWhenPresent(record::getUserName)
            .set(commodityId).equalToWhenPresent(record::getCommodityId)
            .set(commodityName).equalToWhenPresent(record::getCommodityName)
            .set(commodityImg).equalToWhenPresent(record::getCommodityImg)
            .set(specId).equalToWhenPresent(record::getSpecId)
            .set(specName).equalToWhenPresent(record::getSpecName)
            .set(specImg).equalToWhenPresent(record::getSpecImg)
            .set(specAttrValue).equalToWhenPresent(record::getSpecAttrValue)
            .set(payPrice).equalToWhenPresent(record::getPayPrice)
            .set(activityPrice).equalToWhenPresent(record::getActivityPrice)
            .set(userAddrId).equalToWhenPresent(record::getUserAddrId)
            .set(userAddress).equalToWhenPresent(record::getUserAddress)
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