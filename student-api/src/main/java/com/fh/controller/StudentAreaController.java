package com.fh.controller;

import com.fh.model.StudentArea;
import com.fh.service.StudentAreaService;
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
public class StudentAreaController {

    @Autowired
    private StudentAreaService studentAreaService;


    @RequestMapping(value = "/studentArea/query",method = RequestMethod.GET)
    public Map<String,Object> queryStudentArea(){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<StudentArea> studentAreaList = studentAreaService.queryStudentArea();
            resultMap.put("code",200);
            resultMap.put("data",studentAreaList);
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
