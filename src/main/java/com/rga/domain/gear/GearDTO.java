package com.rga.domain.gear;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class GearDTO {
    private String name;
    private String faction;
    private String type;
}
