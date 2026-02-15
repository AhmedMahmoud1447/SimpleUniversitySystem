package com.pioneers.universitysystem.utils.mappers;

import com.pioneers.universitysystem.models.dtos.StudentSignup;
import com.pioneers.universitysystem.models.dtos.response.StudentInfo;
import com.pioneers.universitysystem.models.entities.Student;

import static com.pioneers.universitysystem.utils.NameHelper.buildFullName;
import static com.pioneers.universitysystem.utils.UuidHelper.generateRandomId;

public final class StudentMapper {

    private StudentMapper() {
        throw new IllegalStateException("This is a utility class!");
    }

    public static Student toStudent(final StudentSignup studentSignup) {
        final String id = generateRandomId();
        final String fullName = buildFullName(studentSignup.getFirstName(), studentSignup.getLastName());

        final Student student = new Student();
        student.setId(id);
        student.setFullName(fullName);
        student.setEmail(studentSignup.getEmail());
        student.setPhone(studentSignup.getPhoneNumber());
        student.setPassword(studentSignup.getPassword());
        student.setLogin(false);
        return student;
    }

    public static StudentInfo toStudentInfo(final Student student) {
        final StudentInfo studentInfo = new StudentInfo();
        studentInfo.setFullName(student.getFullName());
        studentInfo.setEmail(student.getEmail());
        studentInfo.setPhone(student.getPhone());
        return studentInfo;
    }

}
