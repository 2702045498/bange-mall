package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Stock;
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

import static com.bange.commodity.mapper.StockDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface StockMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, specId, specCode, stockCount, manufacturer, productDate, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Stock> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Stock> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StockResult")
    Optional<Stock> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StockResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.BIGINT),
        @Result(column="spec_code", property="specCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_count", property="stockCount", jdbcType=JdbcType.INTEGER),
        @Result(column="manufacturer", property="manufacturer", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_date", property="productDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Stock> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, stock, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, stock, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Stock record) {
        return MyBatis3Utils.insert(this::insert, record, stock, c ->
            c.map(id).toProperty("id")
            .map(specId).toProperty("specId")
            .map(specCode).toProperty("specCode")
            .map(stockCount).toProperty("stockCount")
            .map(manufacturer).toProperty("manufacturer")
            .map(productDate).toProperty("productDate")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<Stock> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, stock, c ->
            c.map(id).toProperty("id")
            .map(specId).toProperty("specId")
            .map(specCode).toProperty("specCode")
            .map(stockCount).toProperty("stockCount")
            .map(manufacturer).toProperty("manufacturer")
            .map(productDate).toProperty("productDate")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(Stock record) {
        return MyBatis3Utils.insert(this::insert, record, stock, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(specId).toPropertyWhenPresent("specId", record::getSpecId)
            .map(specCode).toPropertyWhenPresent("specCode", record::getSpecCode)
            .map(stockCount).toPropertyWhenPresent("stockCount", record::getStockCount)
            .map(manufacturer).toPropertyWhenPresent("manufacturer", record::getManufacturer)
            .map(productDate).toPropertyWhenPresent("productDate", record::getProductDate)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<Stock> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, stock, completer);
    }

    default List<Stock> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, stock, completer);
    }

    default List<Stock> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, stock, completer);
    }

    default Optional<Stock> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, stock, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Stock record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(specId).equalTo(record::getSpecId)
                .set(specCode).equalTo(record::getSpecCode)
                .set(stockCount).equalTo(record::getStockCount)
                .set(manufacturer).equalTo(record::getManufacturer)
                .set(productDate).equalTo(record::getProductDate)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Stock record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(specId).equalToWhenPresent(record::getSpecId)
                .set(specCode).equalToWhenPresent(record::getSpecCode)
                .set(stockCount).equalToWhenPresent(record::getStockCount)
                .set(manufacturer).equalToWhenPresent(record::getManufacturer)
                .set(productDate).equalToWhenPresent(record::getProductDate)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(Stock record) {
        return update(c ->
            c.set(specId).equalTo(record::getSpecId)
            .set(specCode).equalTo(record::getSpecCode)
            .set(stockCount).equalTo(record::getStockCount)
            .set(manufacturer).equalTo(record::getManufacturer)
            .set(productDate).equalTo(record::getProductDate)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Stock record) {
        return update(c ->
            c.set(specId).equalToWhenPresent(record::getSpecId)
            .set(specCode).equalToWhenPresent(record::getSpecCode)
            .set(stockCount).equalToWhenPresent(record::getStockCount)
            .set(manufacturer).equalToWhenPresent(record::getManufacturer)
            .set(productDate).equalToWhenPresent(record::getProductDate)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}