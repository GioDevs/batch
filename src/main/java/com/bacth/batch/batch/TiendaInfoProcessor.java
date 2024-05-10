package com.bacth.batch.batch;

import com.bacth.batch.dtos.TiendaInfoDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class TiendaInfoProcessor implements ItemProcessor<TiendaInfoDto, List<Object>> {

    @Override
    public List<Object> process(TiendaInfoDto tiendaInfo)  {
        tiendaInfo.getPersonas().forEach(personDto -> log.info("persona: {}", personDto));
        log.info("direccion: {}", tiendaInfo.getDireccionTienda());


        return Arrays.asList(tiendaInfo.getDireccionTienda(), tiendaInfo.getDescripcionTienda(), tiendaInfo.getPersonas());
    }
}
