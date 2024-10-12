package com.rga.domain.unit;

import com.rga.domain.abilities.Abilitie;
import com.rga.domain.gear.GearDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UnitDTO {
    private String name;
    private String _class;
    private String faction;
    private List<Abilitie> abilities;
    private List<GearDTO> gear;
}
