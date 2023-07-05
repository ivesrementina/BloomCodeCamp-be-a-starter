package com.hcc.repositories;

import com.hcc.entities.Assignment;
import com.hcc.entities.Hello;
import com.hcc.entities.User;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// this is an example repository feel free to delete this once you have created your own.
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByUser(User user);
}