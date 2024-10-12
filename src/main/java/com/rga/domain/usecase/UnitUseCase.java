package com.rga.domain.usecase;

import com.rga.domain.Factions;
import com.rga.domain.unit.UnitDTO;
import com.rga.domain.unit.UnitgateWay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UnitUseCase {

    private final UnitgateWay unitgateWay;

    public UnitDTO saveUnit(UnitDTO unit) {
        if (!Factions.validFaction(unit.getFaction())) {
            throw new RuntimeException("La faccion "
                    .concat(unit.getFaction())
                    .concat(" no esta registrada"));
        }
        return unitgateWay.saveUnit(unit);
    }

    public List<UnitDTO> findAll() {
        return unitgateWay.findAll();
    }

    public UnitDTO findByNameAndFaction(UnitDTO unit) {
        return unitgateWay.findByNameAndFaction(unit);
    }
}
