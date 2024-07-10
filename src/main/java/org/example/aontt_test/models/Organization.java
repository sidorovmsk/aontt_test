package org.example.aontt_test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"branches", "director"})
@EqualsAndHashCode(exclude = {"branches", "director"})
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String shortName;

    @Column(nullable = false, unique = true)
    private String inn;

    @Column(nullable = false, unique = true)
    private String ogrn;

    @Column(nullable = false)
    private String postalAddress;

    @Column(nullable = false)
    private String legalAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches;

    @JsonIgnore
    public Director getDirector() {
        return director;
    }

    @JsonIgnore
    public List<Branch> getBranches() {
        return branches;
    }
}
