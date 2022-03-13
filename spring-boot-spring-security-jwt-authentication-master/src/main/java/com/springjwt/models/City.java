package com.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City extends Auditable<String> implements Serializable {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = RelationshipConstants.STATE_ID)
    private State state;

    @Getter
    @Setter
    private Double latitude;

    @Getter
    @Setter
    private Double longitude;

}
