package com.jully.user_management.service.impl;


import com.jully.user_management.entity.Scholarship;
import com.jully.user_management.repository.UserRepository;
import com.jully.user_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public Scholarship createScholarship(Scholarship scholarship) {
        return userRepository.save((scholarship));
    }

    @Override
    public Scholarship getScholarshipById(Long scholarshipId) {
        Optional<Scholarship> optionalScholarship=userRepository.findById((scholarshipId));
        return optionalScholarship.get();
    }

    @Override
    public List<Scholarship> getAllScholarships() {
        //Scholarship existingScholarship=userRepository.findBy((scholarship.getId()));
        return userRepository.findAll();
    }

    @Override
    public Scholarship updateScholarship(Scholarship scholarship) {
        Scholarship existingScholarship=userRepository.findById(scholarship.getId()).get();
        existingScholarship.setScholarshipName(scholarship.getScholarshipName());
        existingScholarship.setCountry(scholarship.getCountry());
        Scholarship updatedScholarship=userRepository.save(existingScholarship);
        return updatedScholarship;
    }

    @Override
    public void deleteScholarship(Long scholarshipId) {
        userRepository.deleteById(scholarshipId);
    }
}
