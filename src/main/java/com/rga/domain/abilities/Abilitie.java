package com.rga.domain.abilities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abilitie implements Serializable {
    private String name;
    private String type;
    private String description;
}
