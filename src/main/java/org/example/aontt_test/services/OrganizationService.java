package org.example.aontt_test.services;

import lombok.RequiredArgsConstructor;
import org.example.aontt_test.models.Organization;
import org.example.aontt_test.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }


    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }
}
