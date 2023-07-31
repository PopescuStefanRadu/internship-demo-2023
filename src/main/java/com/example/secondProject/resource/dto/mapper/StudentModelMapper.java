package com.example.secondProject.resource.dto.mapper;

import com.example.secondProject.entity.Student;
import com.example.secondProject.resource.dto.StudentModel;

public final class StudentModelMapper {

    private StudentModelMapper() {}

    public static StudentModel fromEntity(final Student stud) {
        return new StudentModel()
                .setCnp(stud.getCnp())
                .setName(stud.getName())
                .setUniversity(stud.getUniversity())
                .setGrades(stud.getCourses().stream().map(GradeMapper::fromEntity).toList());
    }
}
