package com.bacth.batch.batch;

import com.bacth.batch.dtos.DireccionTiendaDto;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

//@Component
public class DireccionTiendaItemWriter extends JdbcBatchItemWriter<DireccionTiendaDto> {

//    public DireccionTiendaItemWriter(DataSource dataSource) {
//        setDataSource(dataSource);
//        setSql("INSERT INTO direccion_tienda (calle, ciudad) VALUES (:calle, :ciudad)");
//        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//    }
}
