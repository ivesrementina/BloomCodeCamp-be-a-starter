package com.hcc.repositories;

import com.hcc.entities.Assignment;
import com.hcc.entities.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

// this is an example repository feel free to delete this once you have created your own.
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}