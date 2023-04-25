package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.AttributeValue;
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

import static com.bange.commodity.mapper.AttributeValueDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface AttributeValueMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, attrId, attrValue);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AttributeValue> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AttributeValue> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AttributeValueResult")
    Optional<AttributeValue> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AttributeValueResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="attr_id", property="attrId", jdbcType=JdbcType.INTEGER),
        @Result(column="attr_value", property="attrValue", jdbcType=JdbcType.VARCHAR)
    })
    List<AttributeValue> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, attributeValue, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, attributeValue, completer);
    }

    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(AttributeValue record) {
        return MyBatis3Utils.insert(this::insert, record, attributeValue, c ->
            c.map(id).toProperty("id")
            .map(attrId).toProperty("attrId")
            .map(attrValue).toProperty("attrValue")
        );
    }

    default int insertMultiple(Collection<AttributeValue> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, attributeValue, c ->
            c.map(id).toProperty("id")
            .map(attrId).toProperty("attrId")
            .map(attrValue).toProperty("attrValue")
        );
    }

    default int insertSelective(AttributeValue record) {
        return MyBatis3Utils.insert(this::insert, record, attributeValue, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(attrId).toPropertyWhenPresent("attrId", record::getAttrId)
            .map(attrValue).toPropertyWhenPresent("attrValue", record::getAttrValue)
        );
    }

    default Optional<AttributeValue> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, attributeValue, completer);
    }

    default List<AttributeValue> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, attributeValue, completer);
    }

    default List<AttributeValue> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, attributeValue, completer);
    }

    default Optional<AttributeValue> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, attributeValue, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(AttributeValue record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(attrId).equalTo(record::getAttrId)
                .set(attrValue).equalTo(record::getAttrValue);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(AttributeValue record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(attrId).equalToWhenPresent(record::getAttrId)
                .set(attrValue).equalToWhenPresent(record::getAttrValue);
    }

    default int updateByPrimaryKey(AttributeValue record) {
        return update(c ->
            c.set(attrId).equalTo(record::getAttrId)
            .set(attrValue).equalTo(record::getAttrValue)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(AttributeValue record) {
        return update(c ->
            c.set(attrId).equalToWhenPresent(record::getAttrId)
            .set(attrValue).equalToWhenPresent(record::getAttrValue)
            .where(id, isEqualTo(record::getId))
        );
    }
}