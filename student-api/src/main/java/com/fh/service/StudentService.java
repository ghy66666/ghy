package com.fh.service;

import com.fh.model.DataTableResult;
import com.fh.model.Student;
import com.fh.model.StudentQuery;

import java.util.List;

public interface StudentService {
    DataTableResult queryStudent(StudentQuery studentQuery);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> queryStudentListByIds(List<Integer> ids);

    void deleteStudentAll(List<Integer> ids);
}
