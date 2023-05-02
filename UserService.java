package com.jully.user_management.service;

import com.jully.user_management.entity.Scholarship;

import java.util.List;

public interface UserService {
    Scholarship createScholarship(Scholarship scholarship);
    Scholarship getScholarshipById(Long scholarshipId);
    List<Scholarship> getAllScholarships();
    Scholarship updateScholarship(Scholarship scholarship);
    void deleteScholarship(Long scholarshipId);
}
