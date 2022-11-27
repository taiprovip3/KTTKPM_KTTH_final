package com.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long>{
}
