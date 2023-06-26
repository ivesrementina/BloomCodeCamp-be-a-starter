//package com.hcc.controllers;
//
//import com.hcc.entities.Assignment;
//import com.hcc.entities.User;
//import com.hcc.services.AssignmentService;
//import com.hcc.services.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/assignments")
//public class AssignmentController {
//
//    @Autowired
//    private final AssignmentService assignmentService;
//    @Autowired
//    private final UserService userService;
//
//    public AssignmentController(AssignmentService assignmentService, UserService userService) {
//        this.assignmentService = assignmentService;
//        this.userService = userService;
//    }
//
//    @PutMapping("{assignmentId}")
//    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long assignmentId, @RequestBody Assignment
//                                                       assignment, @AuthenticationPrincipal User user){
//        Assignment updatedAssignment = assignmentService.save(assignment);
//        return ResponseEntity.ok(updatedAssignment);
//    }
//
//    @GetMapping
//    public ResponseEntity<Assignment> getAssignment(@AuthenticationPrincipal User user) {
//        Set<Assignment> assignmentsByUser = assignmentService.findByUser(user);
//        return ResponseEntity.ok(assignmentsByUser);
//    }
//
//    @DeleteMapping("{assignmentId}")
//    public ResponseEntity<Assignment> deleteAssignment(@PathVariable Long assignmentId, @AuthenticationPrincipal
//                                                       User user) {
//        return assignmentService.delete(assignmentId);
//    }
//}
