package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.services.AssignmentService;
import com.hcc.services.UserService;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private final AssignmentService assignmentService;
    @Autowired
    private final UserService userService;

    public AssignmentController(AssignmentService assignmentService, UserService userService) {
        this.assignmentService = assignmentService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment,
                                                       @AuthenticationPrincipal User user) {
        assignment.setUser(user);
        assignment.setCodeReviewer(user);
        Assignment createdAssignment = assignmentService.save(assignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
    }
    @PutMapping("{assignmentId}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long assignmentId, @RequestBody Assignment
                                                       assignment, @AuthenticationPrincipal User user){
        Assignment updatedAssignment = assignmentService.save(assignment);
        return ResponseEntity.ok(updatedAssignment);
    }
    @GetMapping
    public ResponseEntity<?> getAssignmentByUser(@AuthenticationPrincipal User user) {
        List<Assignment> assignmentsByUser = assignmentService.findByUser(user);
        return ResponseEntity.ok(assignmentsByUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<Assignment> getAssignmentById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        Optional<Assignment> optionalAssignment = assignmentService.findById(id);
        if (optionalAssignment.isPresent()) {
            Assignment assignment = optionalAssignment.get();
            return ResponseEntity.ok(assignment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
