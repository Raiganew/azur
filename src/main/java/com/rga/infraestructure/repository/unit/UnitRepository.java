package com.rga.infraestructure.repository.unit;

import com.rga.domain.gear.GearDTO;
import com.rga.domain.unit.UnitDTO;
import com.rga.domain.unit.UnitgateWay;
import com.rga.infraestructure.repository.gear.Gear;
import com.rga.infraestructure.repository.gear.GearDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UnitRepository implements UnitgateWay {

    @Autowired
    UnitDataRepository repository;
    @Autowired
    GearDataRepository repositoryGear;

    @Override
    public UnitDTO saveUnit(UnitDTO unit) {
        Unit find = repository.findByNameAndFaction(unit.getName(), unit.getFaction());
        Gear gearFind = repositoryGear.findByNameAndFaction(unit.getGear().get(0).getName(), unit.getGear().get(0).getFaction());
        Unit insert = repository.save(Unit.builder()
                .name(unit.getName())
                .faction(unit.getFaction())
                ._class(unit.get_class())
                .abilities(unit.getAbilities())
                .gear(Collections.singletonList(Gear.builder()
                        .id(gearFind.getId())
                        .build()))
                .id(find != null ? find.getId() : null)
                .build());
        return buildUnitDTOToUnit(insert);
    }

    @Override
    public List<UnitDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(UnitRepository::buildUnitDTOToUnit)
                .collect(Collectors.toList());
    }

    @Override
    public UnitDTO findByNameAndFaction(UnitDTO unit) {
        return buildUnitDTOToUnit(repository.findByNameAndFaction(unit.getName()
                , unit.getFaction()));
    }

    private static UnitDTO buildUnitDTOToUnit(Unit unit) {
        return UnitDTO.builder()
                .name(unit.getName())
                ._class(unit.get_class())
                .faction(unit.getFaction())
                .abilities(unit.getAbilities())
                .gear(unit.getGear().stream()
                        .map(UnitRepository::buildGearDTOByGear)
                        .collect(Collectors.toList()))
                .build();
    }

    private static GearDTO buildGearDTOByGear(Gear gear) {
        return GearDTO.builder()
                .name(gear.getName())
                .faction(gear.getFaction())
                .type(gear.getType())
                .build();
    }
}
