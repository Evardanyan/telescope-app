package com.epam.telescope.repository;

import com.epam.telescope.model.PastProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastProjectRepository extends JpaRepository<PastProject, Long> {
}
