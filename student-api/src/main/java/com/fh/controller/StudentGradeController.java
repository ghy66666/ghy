package com.fh.controller;

import com.fh.model.StudentGrade;
import com.fh.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentGradeController {

    @Autowired
    private StudentGradeService studentGradeService;

    @RequestMapping(value = "/studentGrade/query",method = RequestMethod.GET)
    public Map<String,Object> queryStudentGrade(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<StudentGrade> studentGradeList = studentGradeService.queryStudentGrade();
            resultMap.put("code",200);
            resultMap.put("data",studentGradeList);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","请求失败");
        }
        return resultMap;
    }

}
