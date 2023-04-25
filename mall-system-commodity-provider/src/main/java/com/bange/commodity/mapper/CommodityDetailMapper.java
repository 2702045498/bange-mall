package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.CommodityDetail;
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

import static com.bange.commodity.mapper.CommodityDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CommodityDetailMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, bannerUrl, bannerName, commodityId, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CommodityDetail> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CommodityDetail> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommodityDetailResult")
    Optional<CommodityDetail> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommodityDetailResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="banner_url", property="bannerUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner_name", property="bannerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommodityDetail> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, commodityDetail, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, commodityDetail, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(CommodityDetail record) {
        return MyBatis3Utils.insert(this::insert, record, commodityDetail, c ->
            c.map(id).toProperty("id")
            .map(bannerUrl).toProperty("bannerUrl")
            .map(bannerName).toProperty("bannerName")
            .map(commodityId).toProperty("commodityId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<CommodityDetail> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, commodityDetail, c ->
            c.map(id).toProperty("id")
            .map(bannerUrl).toProperty("bannerUrl")
            .map(bannerName).toProperty("bannerName")
            .map(commodityId).toProperty("commodityId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(CommodityDetail record) {
        return MyBatis3Utils.insert(this::insert, record, commodityDetail, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(bannerUrl).toPropertyWhenPresent("bannerUrl", record::getBannerUrl)
            .map(bannerName).toPropertyWhenPresent("bannerName", record::getBannerName)
            .map(commodityId).toPropertyWhenPresent("commodityId", record::getCommodityId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<CommodityDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, commodityDetail, completer);
    }

    default List<CommodityDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, commodityDetail, completer);
    }

    default List<CommodityDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, commodityDetail, completer);
    }

    default Optional<CommodityDetail> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, commodityDetail, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(CommodityDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(bannerUrl).equalTo(record::getBannerUrl)
                .set(bannerName).equalTo(record::getBannerName)
                .set(commodityId).equalTo(record::getCommodityId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(CommodityDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(bannerUrl).equalToWhenPresent(record::getBannerUrl)
                .set(bannerName).equalToWhenPresent(record::getBannerName)
                .set(commodityId).equalToWhenPresent(record::getCommodityId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(CommodityDetail record) {
        return update(c ->
            c.set(bannerUrl).equalTo(record::getBannerUrl)
            .set(bannerName).equalTo(record::getBannerName)
            .set(commodityId).equalTo(record::getCommodityId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(CommodityDetail record) {
        return update(c ->
            c.set(bannerUrl).equalToWhenPresent(record::getBannerUrl)
            .set(bannerName).equalToWhenPresent(record::getBannerName)
            .set(commodityId).equalToWhenPresent(record::getCommodityId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}