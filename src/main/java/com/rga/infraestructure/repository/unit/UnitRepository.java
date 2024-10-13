package com.rga.infraestructure.repository.unit;

import com.rga.domain.gear.GearDTO;
import com.rga.domain.unit.UnitDTO;
import com.rga.domain.unit.UnitgateWay;
import com.rga.infraestructure.repository.gear.Gear;
import com.rga.infraestructure.repository.gear.GearDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<Gear> gears = findGear(unit.getGear());
        Unit insert = repository.save(Unit.builder()
                .name(unit.getName())
                .faction(unit.getFaction())
                ._class(unit.get_class())
                .abilities(unit.getAbilities())
                .stats(unit.getStats())
                .gear(gears)
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
                .stats(unit.getStats())
                .gear(buildGearDTOByGear(unit.getGear()))
                .build();
    }

    private static List<GearDTO> buildGearDTOByGear(List<Gear> gear) {
        if (gear == null || gear.isEmpty()) {
            return new ArrayList<>();
        }
        return gear.stream().map(g -> {
            return GearDTO.builder()
                    .name(g.getName())
                    .faction(g.getFaction())
                    .type(g.getType())
                    .build();
        }).collect(Collectors.toList());
    }

    private List<Gear> findGear(List<GearDTO> gears) {
        if (gears == null || gears.isEmpty()) {
            return null;
        }
        return gears.stream().map(g -> {
            return repositoryGear.findByNameAndFaction(g.getName()
                    , g.getFaction());
        }).filter(Objects::nonNull).toList();
    }
}
