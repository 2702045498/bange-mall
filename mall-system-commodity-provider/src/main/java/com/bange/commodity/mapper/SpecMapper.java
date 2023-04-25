package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Spec;
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

import static com.bange.commodity.mapper.SpecDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SpecMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, specCode, specName, markImg, displayMark, commodityId, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Spec> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Spec> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SpecResult")
    Optional<Spec> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SpecResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="spec_code", property="specCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_name", property="specName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark_img", property="markImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="display_mark", property="displayMark", jdbcType=JdbcType.INTEGER),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Spec> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, spec, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, spec, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Spec record) {
        return MyBatis3Utils.insert(this::insert, record, spec, c ->
            c.map(id).toProperty("id")
            .map(specCode).toProperty("specCode")
            .map(specName).toProperty("specName")
            .map(markImg).toProperty("markImg")
            .map(displayMark).toProperty("displayMark")
            .map(commodityId).toProperty("commodityId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<Spec> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, spec, c ->
            c.map(id).toProperty("id")
            .map(specCode).toProperty("specCode")
            .map(specName).toProperty("specName")
            .map(markImg).toProperty("markImg")
            .map(displayMark).toProperty("displayMark")
            .map(commodityId).toProperty("commodityId")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(Spec record) {
        return MyBatis3Utils.insert(this::insert, record, spec, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(specCode).toPropertyWhenPresent("specCode", record::getSpecCode)
            .map(specName).toPropertyWhenPresent("specName", record::getSpecName)
            .map(markImg).toPropertyWhenPresent("markImg", record::getMarkImg)
            .map(displayMark).toPropertyWhenPresent("displayMark", record::getDisplayMark)
            .map(commodityId).toPropertyWhenPresent("commodityId", record::getCommodityId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<Spec> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, spec, completer);
    }

    default List<Spec> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, spec, completer);
    }

    default List<Spec> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, spec, completer);
    }

    default Optional<Spec> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, spec, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Spec record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(specCode).equalTo(record::getSpecCode)
                .set(specName).equalTo(record::getSpecName)
                .set(markImg).equalTo(record::getMarkImg)
                .set(displayMark).equalTo(record::getDisplayMark)
                .set(commodityId).equalTo(record::getCommodityId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Spec record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(specCode).equalToWhenPresent(record::getSpecCode)
                .set(specName).equalToWhenPresent(record::getSpecName)
                .set(markImg).equalToWhenPresent(record::getMarkImg)
                .set(displayMark).equalToWhenPresent(record::getDisplayMark)
                .set(commodityId).equalToWhenPresent(record::getCommodityId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(Spec record) {
        return update(c ->
            c.set(specCode).equalTo(record::getSpecCode)
            .set(specName).equalTo(record::getSpecName)
            .set(markImg).equalTo(record::getMarkImg)
            .set(displayMark).equalTo(record::getDisplayMark)
            .set(commodityId).equalTo(record::getCommodityId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Spec record) {
        return update(c ->
            c.set(specCode).equalToWhenPresent(record::getSpecCode)
            .set(specName).equalToWhenPresent(record::getSpecName)
            .set(markImg).equalToWhenPresent(record::getMarkImg)
            .set(displayMark).equalToWhenPresent(record::getDisplayMark)
            .set(commodityId).equalToWhenPresent(record::getCommodityId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}