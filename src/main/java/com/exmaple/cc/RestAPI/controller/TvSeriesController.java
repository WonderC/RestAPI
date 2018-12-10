package com.exmaple.cc.RestAPI.controller;

import com.exmaple.cc.RestAPI.model.bean.TvSeries;
import com.exmaple.cc.RestAPI.dao.service.TvSeriesDaoService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    /**
     * 日志
     */
    public static final Log log = LogFactory.getLog(TvSeriesController.class);

    @GetMapping
    public List<TvSeries> getAll(){
        if (log.isTraceEnabled()){
            log.trace("getAll（）调用了");
        }
        List<TvSeries> list = new ArrayList<>();
        list.add(this.createPoi());
        list.add(this.createWest());
        return list;
    }

    @Autowired
    private TvSeriesDaoService tvSeriesDaoService;

    @GetMapping("/all")
    public List<TvSeries> all(){
        if (log.isTraceEnabled()){
            log.trace("all（）调用了");
        }
        List<TvSeries> list = tvSeriesDaoService.getAll();
        return list;
    }

    //GET接受参数
    @GetMapping("/{id}")
    public TvSeries getOne(@PathVariable int id){
        if (log.isTraceEnabled()){
            log.trace("getOne（）调用了");
        }
        if (id ==  101){
            return  this.createPoi();
        }else if (id == 102){
            return this.createWest();
        }else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping
    public TvSeries insertOne(@RequestBody TvSeries tvSeries){
        if (log.isTraceEnabled()){
            log.trace("插入..." + tvSeries);
        }
        tvSeries.setId(999);
        return tvSeries;
    }

    @PutMapping("/{id}")
    public TvSeries updateOne(@PathVariable int id , @RequestBody TvSeries tvSeries){
        if (log.isTraceEnabled()){
            log.trace("update id " + id);
        }
        if (id == 101 || id == 102){
            return createWest();
        }else {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public Map<String,String> deleteOne(@PathVariable int id, HttpServletRequest request, @RequestParam(value = "reason",required = false) String reason) throws Exception{
        if (log.isTraceEnabled()){
            log.trace("delete id " + id);
        }

        Map<String,String> map = new HashMap<>();
        if (id == 101){
            map.put("message","101" + request.getRemoteAddr()+"原因" + reason);
        }else if (id == 102){
            throw new RuntimeException("不能删除");
        }else {
            throw new ResourceNotFoundException();
        }
        return map;
    }



    private TvSeries createWest(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,2);
        return new TvSeries(1,"west world",1,calendar.getTime());
    }

    private TvSeries createPoi(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011,Calendar.SEPTEMBER,2);
        return new TvSeries(1,"Person Of Interest",5,calendar.getTime());
    }
}
