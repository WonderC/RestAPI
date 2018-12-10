package com.exmaple.cc.RestAPI.dao.service;

import com.exmaple.cc.RestAPI.dao.mapper.TvSeriesDaoMapper;
import com.exmaple.cc.RestAPI.model.bean.TvSeries;
import com.exmaple.cc.RestAPI.dao.TvSeriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesDaoService {

    @Autowired
    TvSeriesDaoMapper tvSeriesDaoMapper;

    public List<TvSeries> getAll(){
        return tvSeriesDaoMapper.getAll();
    }
}
