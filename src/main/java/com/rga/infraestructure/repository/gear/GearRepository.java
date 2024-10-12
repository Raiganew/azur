package com.rga.infraestructure.repository.gear;

import com.rga.domain.gear.GearDTO;
import com.rga.domain.gear.GearGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GearRepository implements GearGateWay {

    @Autowired
    private GearDataRepository repository;

    @Override
    public List<GearDTO> findAll() {
        return repository.findAll().stream()
                .map(GearRepository::buildGearDTOByGear)
                .collect(Collectors.toList());
    }

    @Override
    public GearDTO save(GearDTO gear) {
        return buildGearDTOByGear(repository.save(
                Gear.builder()
                        .type(gear.getType())
                        .name(gear.getName())
                        .faction(gear.getFaction())
                        .build()
        ));
    }

    private static GearDTO buildGearDTOByGear(Gear gear) {
        return GearDTO.builder()
                .name(gear.getName())
                .faction(gear.getFaction())
                .type(gear.getType())
                .build();
    }
}
