package com.rga.infraestructure.repository.gear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearDataRepository extends JpaRepository<Gear,Integer> {

    Gear findByNameAndFaction(String name, String faction);
}
