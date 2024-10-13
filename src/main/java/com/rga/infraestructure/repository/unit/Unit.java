package com.rga.infraestructure.repository.unit;

import com.rga.domain.abilities.Abilitie;
import com.rga.domain.unit.StatsDTO;
import com.rga.infraestructure.converters.AbilitieListConverter;
import com.rga.infraestructure.converters.StatsConverter;
import com.rga.infraestructure.repository.gear.Gear;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "class")
    private String _class;
    private String faction;
    @Convert(converter = AbilitieListConverter.class)
    private List<Abilitie> abilities;
    @ManyToMany
    private List<Gear> gear;
    @Convert(converter = StatsConverter.class)
    private StatsDTO stats;
}
