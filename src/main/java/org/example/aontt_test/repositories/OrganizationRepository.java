package org.example.aontt_test.repositories;

import org.example.aontt_test.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
