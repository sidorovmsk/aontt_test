package org.example.aontt_test.repositories;

import org.example.aontt_test.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
