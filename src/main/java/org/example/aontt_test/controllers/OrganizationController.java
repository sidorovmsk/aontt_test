package org.example.aontt_test.controllers;

import lombok.RequiredArgsConstructor;
import org.example.aontt_test.models.Organization;
import org.example.aontt_test.services.OrganizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    /**
     * Get all organizations
     *
     * @param filter - filter by organization name
     * @return list of organizations
     */
    @GetMapping("/organizations")
    public List<Organization> getAllOrganizations(@RequestParam(required = false) String filter) {
        List<Organization> organizations = organizationService.findAll();

        if (filter != null && !filter.isEmpty()) {
            organizations = organizations.stream()
                    .filter(org -> org.getFullName().toLowerCase().contains(filter.toLowerCase()) ||
                            org.getShortName().toLowerCase().contains(filter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return organizations;
    }

    /**
     * Get organization by id
     *
     * @param id - organization id
     * @return organization
     */
    @GetMapping("/organization")
    public Optional<Organization> getOrganizationById(@RequestParam Long id) {
        return organizationService.findById(id);
    }

}
