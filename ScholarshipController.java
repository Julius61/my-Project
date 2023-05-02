package com.jully.user_management.controller;

import com.jully.user_management.entity.Scholarship;
import com.jully.user_management.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/julius")
public class ScholarshipController {

    private UserService userService;

    //build create scholarship rest api
    @PostMapping
    public ResponseEntity<Scholarship> createScholarship(@RequestBody Scholarship scholarship){
        Scholarship savedScholarship=(userService.createScholarship(scholarship));
        return  new ResponseEntity<>(savedScholarship, HttpStatus.CREATED);
    }

    //build get scholarship by id rest api
    @GetMapping("{id")
    public  ResponseEntity<Scholarship> getScholarshipById(@PathVariable("id") Long scholarshipId){
        Scholarship savedScholarship=userService.getScholarshipById(scholarshipId);
        return new ResponseEntity<>(savedScholarship, HttpStatus.OK);
    }
    //build get all scholarshipd rest api
    @GetMapping
    public ResponseEntity<List<Scholarship>> getAllScholarships(){
        List<Scholarship> scholarships=userService.getAllScholarships();
        return new ResponseEntity<>(scholarships,HttpStatus.OK);
    }
    //build update scholarships rset api
    @PutMapping("{id}")
    public ResponseEntity<Scholarship> updateScholarship(@PathVariable("id") Long scholarshipId, @RequestBody Scholarship scholarship){
        scholarship.setId(scholarshipId);
        Scholarship updatedScholarship=userService.updateScholarship(scholarship);
        return new ResponseEntity<>(updatedScholarship, HttpStatus.OK);
    }
    //BUILD DELETE SCHOLARSHIP RSET API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteScholarship(@PathVariable("id") Long scholarshipId){
        userService.deleteScholarship(scholarshipId);
        return  new ResponseEntity<>("Shcolarship Deleted Successfully!",HttpStatus.OK);
    }
}
