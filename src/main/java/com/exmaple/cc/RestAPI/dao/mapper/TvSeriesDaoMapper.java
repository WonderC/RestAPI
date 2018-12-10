package com.exmaple.cc.RestAPI.dao.mapper;

import com.exmaple.cc.RestAPI.model.bean.TvSeries;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvSeriesDaoMapper {

    @Select("SELECT * from tv_series")
    List<TvSeries> getAll();
}
