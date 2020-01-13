package com.fh.mapper;

import com.fh.model.Student;
import com.fh.model.StudentQuery;

import java.util.List;

public interface StudentMapper {
    Long queryStudentCount(StudentQuery studentQuery);

    List<Student> queryStudent(StudentQuery studentQuery);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> queryStudentListByIds(List<Integer> ids);

    void deleteStudentAll(List<Integer> ids);
}
