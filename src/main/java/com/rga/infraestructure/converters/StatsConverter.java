package com.rga.infraestructure.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rga.domain.unit.StatsDTO;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class StatsConverter implements AttributeConverter<StatsDTO, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(StatsDTO statsDTO) {
        if (statsDTO == null) {
            return "";
        }
        try {
            return objectMapper.writeValueAsString(statsDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Stats to JSON ", e);
        }
    }

    @Override
    public StatsDTO convertToEntityAttribute(String stats) {
        if (stats == null || stats.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(stats,
                    objectMapper.getTypeFactory().constructType(StatsDTO.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Stats to JSON ", e);
        }
    }
}
