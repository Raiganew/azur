package com.rga.domain.unit;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDTO implements Serializable {
    private int healt;
    private int firePorwer;
    private int torpedo;
    private int aviation;
    private int antiAir;
    private int reload;
    private int evasion;
    private String armor;
    private int speed;
    private int accuracy;
    private int luck;
    private int antiSubmarine;
    private int oilConsum;
}
