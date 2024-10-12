package com.rga.infraestructure.repository.unit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitDataRepository extends JpaRepository<Unit, Integer> {

    Unit findByNameAndFaction(String name, String faction);
}
