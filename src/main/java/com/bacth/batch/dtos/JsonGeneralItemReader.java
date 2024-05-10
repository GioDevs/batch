package com.bacth.batch.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class JsonGeneralItemReader implements ItemReader<TiendaInfoDto> {
    private final ObjectMapper objectMapper;
    private final Resource[] resources;
    private int currentResourceIndex = 0;

    public JsonGeneralItemReader(ObjectMapper objectMapper, Resource[] resources) {
        this.objectMapper = objectMapper;
        this.resources = resources;
    }

    @Override
    public TiendaInfoDto read() throws Exception {
        if (currentResourceIndex < resources.length) {
            try {
                TiendaInfoDto tiendaInfo = objectMapper.readValue(resources[currentResourceIndex].getInputStream(), TiendaInfoDto.class);
                currentResourceIndex++;
                return tiendaInfo;
            } catch (IOException e) {
                throw new RuntimeException("Error al leer el JSON", e);
            }
        } else {
            return null;
        }
    }
}
