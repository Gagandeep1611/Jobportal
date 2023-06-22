package com.project.Jobportal.Repository;


import com.project.Jobportal.Models.Internship;
import com.project.Jobportal.Models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    @Query(value = "SELECT * FROM internships s WHERE s.title LIKE %:keyword% OR s.company LIKE %:keyword% OR s.location LIKE %:keyword%",
            countQuery = "SELECT COUNT(*) FROM internships s WHERE s.title LIKE %:keyword% OR s.company LIKE %:keyword% OR s.location LIKE %:keyword%",
            nativeQuery = true)
    Page<Internship> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

}