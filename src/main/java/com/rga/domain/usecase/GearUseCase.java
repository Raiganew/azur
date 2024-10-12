package com.rga.domain.usecase;

import com.rga.domain.gear.GearDTO;
import com.rga.domain.gear.GearGateWay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GearUseCase {
    private final GearGateWay gearGateWay;

    public List<GearDTO> findAll(){
        return gearGateWay.findAll();
    }

    public GearDTO save(GearDTO gear){
        return gearGateWay.save(gear);
    }
}
