package com.bange.commodity.mapper;

import com.bange.mall.entity.commodity.CommodityAttr;
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

import static com.bange.commodity.mapper.CommodityAttrDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CommodityAttrMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, commdityId, attrId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CommodityAttr> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CommodityAttr> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommodityAttrResult")
    Optional<CommodityAttr> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommodityAttrResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="commdity_id", property="commdityId", jdbcType=JdbcType.BIGINT),
        @Result(column="attr_id", property="attrId", jdbcType=JdbcType.INTEGER)
    })
    List<CommodityAttr> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, commodityAttr, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, commodityAttr, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    default int insert(CommodityAttr record) {
        return MyBatis3Utils.insert(this::insert, record, commodityAttr, c ->
            c.map(id).toProperty("id")
            .map(commdityId).toProperty("commdityId")
            .map(attrId).toProperty("attrId")
        );
    }

    default int insertMultiple(Collection<CommodityAttr> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, commodityAttr, c ->
            c.map(id).toProperty("id")
            .map(commdityId).toProperty("commdityId")
            .map(attrId).toProperty("attrId")
        );
    }

    default int insertSelective(CommodityAttr record) {
        return MyBatis3Utils.insert(this::insert, record, commodityAttr, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(commdityId).toPropertyWhenPresent("commdityId", record::getCommdityId)
            .map(attrId).toPropertyWhenPresent("attrId", record::getAttrId)
        );
    }

    default Optional<CommodityAttr> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, commodityAttr, completer);
    }

    default List<CommodityAttr> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, commodityAttr, completer);
    }

    default List<CommodityAttr> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, commodityAttr, completer);
    }

    default Optional<CommodityAttr> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, commodityAttr, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(CommodityAttr record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(commdityId).equalTo(record::getCommdityId)
                .set(attrId).equalTo(record::getAttrId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(CommodityAttr record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(commdityId).equalToWhenPresent(record::getCommdityId)
                .set(attrId).equalToWhenPresent(record::getAttrId);
    }

    default int updateByPrimaryKey(CommodityAttr record) {
        return update(c ->
            c.set(commdityId).equalTo(record::getCommdityId)
            .set(attrId).equalTo(record::getAttrId)
            .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(CommodityAttr record) {
        return update(c ->
            c.set(commdityId).equalToWhenPresent(record::getCommdityId)
            .set(attrId).equalToWhenPresent(record::getAttrId)
            .where(id, isEqualTo(record::getId))
        );
    }
}