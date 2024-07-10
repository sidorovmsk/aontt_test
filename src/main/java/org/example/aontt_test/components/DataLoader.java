package org.example.aontt_test.components;

import lombok.RequiredArgsConstructor;
import org.example.aontt_test.models.Branch;
import org.example.aontt_test.models.BranchDirector;
import org.example.aontt_test.models.Director;
import org.example.aontt_test.models.Organization;
import org.example.aontt_test.repositories.BranchDirectorRepository;
import org.example.aontt_test.repositories.BranchRepository;
import org.example.aontt_test.repositories.DirectorRepository;
import org.example.aontt_test.repositories.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final OrganizationRepository organizationRepository;
    private final DirectorRepository directorRepository;
    private final BranchRepository branchRepository;
    private final BranchDirectorRepository branchDirectorRepository;

    @Override
    public void run(String... args) {
        init_director();
        init_branchDirector();
        init_branch();
        init_org();
        setBranchDirector();
        setDirector();
        addBranchToOrganization();
    }

    public void init_director() {
        for (int i = 0; i < 50; i++) {
            Director director = new Director();
            director.setLastName("Иванов" + i);
            director.setFirstName("Иван" + i);
            director.setMiddleName("Иванович");
            director.setDateOfBirth(LocalDate.of(1980, Month.JANUARY, 1));
            directorRepository.save(director);
        }
    }

    public void init_branchDirector() {
        for (int i = 0; i < 50; i++) {
            BranchDirector branchDirector = new BranchDirector();
            branchDirector.setLastName("Петров" + i);
            branchDirector.setFirstName("Петр" + i);
            branchDirector.setMiddleName("Петрович");
            branchDirector.setDateOfBirth(LocalDate.of(1985, Month.MAY, 5));
            branchDirectorRepository.save(branchDirector);
        }
    }

    public void init_branch() {
        for (int i = 0; i < 50; i++) {
            Branch branch = new Branch();
            branch.setName("Филиал " + i);
            branch.setPostalAddress("Почтовый адрес филиала " + i);
            branchRepository.save(branch);
        }
    }

    public void init_org() {
        for (int i = 0; i < 50; i++) {
            Organization organization = new Organization();
            organization.setFullName("Полное наименование организации " + i);
            organization.setShortName("Краткое наименование " + i);
            organization.setInn(String.format("%010d", i)); // INN with leading zeros
            organization.setOgrn(String.format("%013d", i)); // OGRN with leading zeros
            organization.setPostalAddress("Почтовый адрес " + i);
            organization.setLegalAddress("Юридический адрес " + i);
            organizationRepository.save(organization);
        }
    }

    public void setBranchDirector() {
        for (int i = 1; i < 51; i++) {
            Branch branch = branchRepository.findById((long) i).get();
            BranchDirector branchDirector = branchDirectorRepository.findById((long) i).get();
            branch.setBranchDirector(branchDirector);
            branchRepository.save(branch);
        }
    }

    public void setDirector() {
        for (int i = 1; i < 51; i++) {
            Organization organization = organizationRepository.findById((long) i).get();
            Director director = directorRepository.findById((long) i).get();
            organization.setDirector(director);
            organizationRepository.save(organization);
        }
    }

    public void addBranchToOrganization() {
        for (int i = 1; i < 51; i++) {
            Organization organization = organizationRepository.findById((long) i).get();
            Branch branch = branchRepository.findById((long) i).get();
            branch.setOrganization(organization);
            branchRepository.save(branch);
        }
    }
}