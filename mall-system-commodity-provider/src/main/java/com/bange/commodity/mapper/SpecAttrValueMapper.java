package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.SpecAttrValue;
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

import static com.bange.commodity.mapper.SpecAttrValueDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SpecAttrValueMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, specId, attrValueId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SpecAttrValue> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<SpecAttrValue> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SpecAttrValueResult")
    Optional<SpecAttrValue> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SpecAttrValueResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.BIGINT),
        @Result(column="attr_value_id", property="attrValueId", jdbcType=JdbcType.INTEGER)
    })
    List<SpecAttrValue> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, specAttrValue, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, specAttrValue, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(SpecAttrValue record) {
        return MyBatis3Utils.insert(this::insert, record, specAttrValue, c ->
            c.map(id).toProperty("id")
            .map(specId).toProperty("specId")
            .map(attrValueId).toProperty("attrValueId")
        );
    }

    default int insertMultiple(Collection<SpecAttrValue> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, specAttrValue, c ->
            c.map(id).toProperty("id")
            .map(specId).toProperty("specId")
            .map(attrValueId).toProperty("attrValueId")
        );
    }

    default int insertSelective(SpecAttrValue record) {
        return MyBatis3Utils.insert(this::insert, record, specAttrValue, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(specId).toPropertyWhenPresent("specId", record::getSpecId)
            .map(attrValueId).toPropertyWhenPresent("attrValueId", record::getAttrValueId)
        );
    }

    default Optional<SpecAttrValue> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, specAttrValue, completer);
    }

    default List<SpecAttrValue> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, specAttrValue, completer);
    }

    default List<SpecAttrValue> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, specAttrValue, completer);
    }

    default Optional<SpecAttrValue> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, specAttrValue, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(SpecAttrValue record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(specId).equalTo(record::getSpecId)
                .set(attrValueId).equalTo(record::getAttrValueId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(SpecAttrValue record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(specId).equalToWhenPresent(record::getSpecId)
                .set(attrValueId).equalToWhenPresent(record::getAttrValueId);
    }

    default int updateByPrimaryKey(SpecAttrValue record) {
        return update(c ->
            c.set(specId).equalTo(record::getSpecId)
            .set(attrValueId).equalTo(record::getAttrValueId)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(SpecAttrValue record) {
        return update(c ->
            c.set(specId).equalToWhenPresent(record::getSpecId)
            .set(attrValueId).equalToWhenPresent(record::getAttrValueId)
            .where(id, isEqualTo(record::getId))
        );
    }
}