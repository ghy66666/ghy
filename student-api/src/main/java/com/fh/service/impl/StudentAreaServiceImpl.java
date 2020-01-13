package com.fh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fh.mapper.StudentAreaMapper;
import com.fh.model.StudentArea;
import com.fh.service.StudentAreaService;
import com.fh.util.JedisConnectionPool;
import com.fh.util.RedisKeyConstant;
import com.fh.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class StudentAreaServiceImpl implements StudentAreaService {

    @Autowired
    private StudentAreaMapper studentAreaMapper;

    @Override
    public List<StudentArea> queryStudentArea() {
        if(RedisUtil.exists(RedisKeyConstant.KEY_AREA)){
            String areaListJson = RedisUtil.get(RedisKeyConstant.KEY_AREA);
            return JSONObject.parseArray(areaListJson,StudentArea.class);
        }
        List<StudentArea> studentAreaList = studentAreaMapper.queryStudentArea();
        String areaListJson = JSONObject.toJSONString(studentAreaList);
        RedisUtil.set(RedisKeyConstant.KEY_AREA,areaListJson);
        return studentAreaList;
    }
}
