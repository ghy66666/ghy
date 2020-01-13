package com.fh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fh.mapper.StudentGradeMapper;
import com.fh.model.StudentGrade;
import com.fh.service.StudentGradeService;
import com.fh.util.JedisConnectionPool;
import com.fh.util.RedisKeyConstant;
import com.fh.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {

    @Autowired
    private StudentGradeMapper studentGradeMapper;

    @Override
    public List<StudentGrade> queryStudentGrade() {
        if(RedisUtil.exists(RedisKeyConstant.KEY_GRADE)){
            String gradeListJson = RedisUtil.get(RedisKeyConstant.KEY_GRADE);
            return JSONObject.parseArray(gradeListJson,StudentGrade.class);
        }
        List<StudentGrade> studentGradeList = studentGradeMapper.queryStudentGrade();
        String gradeListJson = JSONObject.toJSONString(studentGradeList);
        RedisUtil.set(RedisKeyConstant.KEY_GRADE,gradeListJson);
        return studentGradeList;
    }
}
