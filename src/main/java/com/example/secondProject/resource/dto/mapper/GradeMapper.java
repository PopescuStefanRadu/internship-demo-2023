package com.example.secondProject.resource.dto.mapper;

import com.example.secondProject.entity.StudentAttendedCourse;
import com.example.secondProject.resource.dto.Grade;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GradeMapper {
    public static Grade fromEntity(StudentAttendedCourse sac) {
        return new Grade()
                .setGrade(sac.getGrade())
                .setCourseName(sac.getCourse().getName());
    }
}
