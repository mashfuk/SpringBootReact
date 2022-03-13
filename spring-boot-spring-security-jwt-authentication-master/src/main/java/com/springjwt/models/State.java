package com.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "states")
public class State extends Auditable<String> implements Serializable {

    @Getter
    @Setter
    private String name;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = RelationshipConstants.COUNTRY_ID)
    private Country country;
}
