package com.rga.domain.gear;

import java.util.List;

public interface GearGateWay {
    List<GearDTO> findAll();
    GearDTO save(GearDTO gear);
}
