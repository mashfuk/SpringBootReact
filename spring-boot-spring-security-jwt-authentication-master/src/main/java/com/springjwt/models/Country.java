package com.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends Auditable<String> implements Serializable {
    @Getter
    @Setter
    @Column(name = "sortname")
    private String sortName;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "phonecode")
    private String phoneCode;

    @JsonIgnore
    @Getter
    @Setter
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<State> states = new HashSet<>();
}
