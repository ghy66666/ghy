package com.fh.controller;

import com.fh.model.DataTableResult;
import com.fh.model.Student;
import com.fh.model.StudentQuery;
import com.fh.service.StudentService;
import com.fh.util.AliyunOSSUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/student/query",method = RequestMethod.POST)
    public Map<String,Object> queryStudent(@RequestBody StudentQuery studentQuery){
        Map<String,Object> result = new HashMap<>();
        try {
            DataTableResult dataTableResult = studentService.queryStudent(studentQuery);
            result.put("code",200);
            result.put("data",dataTableResult);
            result.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code",500);
            result.put("data",null);
            result.put("message","请求失败");
        }
        return result;
    }


    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Map<String,Object> addStudent(@RequestBody Student student){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            studentService.addStudent(student);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","请求失败");
        }
        return resultMap;
    }



    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteStudent(@PathVariable("id") Integer id){
        Map<String,Object> resultMap = new HashMap<>();
        try {

            Student oldStudent = studentService.getStudentById(id);
            if (StringUtils.isNotBlank(oldStudent.getPosterPath())){
                AliyunOSSUtil.deleteFile(oldStudent.getPosterPath());
            }

            studentService.deleteStudent(id);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","请求失败");
        }
        return resultMap;
    }



    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Map<String,Object> getStudentById(@PathVariable("id") Integer id){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Student student = studentService.getStudentById(id);
            resultMap.put("code",200);
            resultMap.put("data",student);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","请求失败");
        }
        return resultMap;
    }


    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public Map<String,Object> updateStudent(@RequestBody Student student){
        Map<String,Object> resultMap = new HashMap<>();
        try {

            Student oldStudent = studentService.getStudentById(student.getId());
            if (StringUtils.isNotBlank(oldStudent.getPosterPath())){
                AliyunOSSUtil.deleteFile(oldStudent.getPosterPath());
            }

            studentService.updateStudent(student);
            resultMap.put("code",200);
            resultMap.put("data",null);
            resultMap.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
            resultMap.put("data",null);
            resultMap.put("message","请求失败");
        }
        return resultMap;
    }


    @RequestMapping(value = "/student/uploadPhoto",method = RequestMethod.POST)
    public Map<String,Object> uploadPhoto(@RequestParam("poster") MultipartFile file, HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            String originalFileName = file.getOriginalFilename();
            String url = AliyunOSSUtil.uploadFile(file.getInputStream(), originalFileName, "image");
            resultMap.put("filePath",url);
            resultMap.put("code",200);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",500);
        }
        return resultMap;
    }


    @RequestMapping(value = "/student/{idArr}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteUserAll(@PathVariable("isArr[]") List<Integer> ids){
        Map<String,Object> result = new HashMap<>();
        try {
            List<Student> studentList = studentService.queryStudentListByIds(ids);
            for(Student student : studentList){
                if(StringUtils.isNotBlank(student.getPosterPath())){
                    AliyunOSSUtil.deleteFile(student.getPosterPath());
                }
            }
            studentService.deleteStudentAll(ids);
            result.put("code",200);
            result.put("data",null);
            result.put("message","请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code",500);
            result.put("data",null);
            result.put("message","请求失败");
        }
        return result;
    }

}
