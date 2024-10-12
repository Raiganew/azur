package com.rga.domain.unit;

import java.util.List;

public interface UnitgateWay {

    UnitDTO saveUnit(UnitDTO unit);
    List<UnitDTO> findAll();
    UnitDTO findByNameAndFaction(UnitDTO unit);
}
