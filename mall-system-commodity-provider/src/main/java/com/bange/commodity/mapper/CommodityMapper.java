package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.Commodity;
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

import static com.bange.commodity.mapper.CommodityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CommodityMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, commdityCode, commdityName, commdodityImg, createTime, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Commodity> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Commodity> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommodityResult")
    Optional<Commodity> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommodityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="commdity_code", property="commdityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="commdity_name", property="commdityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="commdodity_img", property="commdodityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Commodity> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, commodity, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, commodity, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(Commodity record) {
        return MyBatis3Utils.insert(this::insert, record, commodity, c ->
            c.map(id).toProperty("id")
            .map(commdityCode).toProperty("commdityCode")
            .map(commdityName).toProperty("commdityName")
            .map(commdodityImg).toProperty("commdodityImg")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<Commodity> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, commodity, c ->
            c.map(id).toProperty("id")
            .map(commdityCode).toProperty("commdityCode")
            .map(commdityName).toProperty("commdityName")
            .map(commdodityImg).toProperty("commdodityImg")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(Commodity record) {
        return MyBatis3Utils.insert(this::insert, record, commodity, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(commdityCode).toPropertyWhenPresent("commdityCode", record::getCommdityCode)
            .map(commdityName).toPropertyWhenPresent("commdityName", record::getCommdityName)
            .map(commdodityImg).toPropertyWhenPresent("commdodityImg", record::getCommdodityImg)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<Commodity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, commodity, completer);
    }

    default List<Commodity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, commodity, completer);
    }

    default List<Commodity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, commodity, completer);
    }

    default Optional<Commodity> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, commodity, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Commodity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(commdityCode).equalTo(record::getCommdityCode)
                .set(commdityName).equalTo(record::getCommdityName)
                .set(commdodityImg).equalTo(record::getCommdodityImg)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Commodity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(commdityCode).equalToWhenPresent(record::getCommdityCode)
                .set(commdityName).equalToWhenPresent(record::getCommdityName)
                .set(commdodityImg).equalToWhenPresent(record::getCommdodityImg)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(Commodity record) {
        return update(c ->
            c.set(commdityCode).equalTo(record::getCommdityCode)
            .set(commdityName).equalTo(record::getCommdityName)
            .set(commdodityImg).equalTo(record::getCommdodityImg)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(Commodity record) {
        return update(c ->
            c.set(commdityCode).equalToWhenPresent(record::getCommdityCode)
            .set(commdityName).equalToWhenPresent(record::getCommdityName)
            .set(commdodityImg).equalToWhenPresent(record::getCommdodityImg)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}