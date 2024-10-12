package com.rga.infraestructure.controllers;

import com.rga.domain.gear.GearDTO;
import com.rga.domain.usecase.GearUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gear")
@RequiredArgsConstructor
public class GearController {

    private final GearUseCase useCase;

    @GetMapping("/findAll")
    public List<GearDTO> findAll() {
        return useCase.findAll();
    }

    @PostMapping("/save")
    public GearDTO save(@RequestBody GearDTO gearDTO){
        return useCase.save(gearDTO);
    }
}
