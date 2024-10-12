package com.rga.infraestructure.controllers;

import com.rga.domain.unit.UnitDTO;
import com.rga.domain.usecase.UnitUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unit")
public class UnitController {

    private final UnitUseCase useCase;

    @GetMapping("/findAll")
    public List<UnitDTO> findAll(){
        return useCase.findAll();
    }

    @PostMapping("/save")
    public UnitDTO saveUnit(@RequestBody UnitDTO unit){
        return useCase.saveUnit(unit);
    }
}
