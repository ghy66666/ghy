package com.fh.service.impl;

import com.fh.mapper.StudentMapper;
import com.fh.model.DataTableResult;
import com.fh.model.Student;
import com.fh.model.StudentQuery;
import com.fh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public DataTableResult queryStudent(StudentQuery studentQuery) {
        Long count = studentMapper.queryStudentCount(studentQuery);
        List<Student> studentList = studentMapper.queryStudent(studentQuery);
        return new DataTableResult(studentQuery.getDraw(),count,count,studentList);
    }


    @Override
    public void addStudent(Student student) {
        student.setCreateDate(new Date());
        studentMapper.addStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> queryStudentListByIds(List<Integer> ids) {
        return studentMapper.queryStudentListByIds(ids);
    }

    @Override
    public void deleteStudentAll(List<Integer> ids) {
        studentMapper.deleteStudentAll(ids);
    }
}
