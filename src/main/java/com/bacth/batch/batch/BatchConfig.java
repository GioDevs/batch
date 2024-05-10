package com.bacth.batch.batch;

import com.bacth.batch.dtos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {


    @Bean
    public ItemReader<TiendaInfoDto> jsonGeneralItemReader(ObjectMapper objectMapper) {
        Resource[] resources = getResources();
        return new JsonGeneralItemReader(objectMapper, resources);
    }

    private Resource[] getResources() {
        return new Resource[]{
                new ByteArrayResource("{\"direccionTienda\":{\"id\":\"1\", \"calle\":\"Calle Principal\",\"ciudad\":\"Ciudad Principal\"},\"descripcionTienda\":{\"id\":\"1\", \"nombre\":\"Mi Tienda\"},\"personas\":[{\"id\":\"1\", \"nombre\":\"Juan\",\"edad\":30},{\"id\":\"2\", \"nombre\":\"María\",\"edad\":25}]}".getBytes())
        };
    }
    @Bean
    public ItemProcessor<TiendaInfoDto, List<Object>>  tiendaInfoProcessor() {
        return new TiendaInfoProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<DireccionTiendaDto> direccionTiendaWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<DireccionTiendaDto>()
                .dataSource(dataSource)
                .sql("INSERT INTO direccion_tienda (id, calle, ciudad) VALUES (:id, :calle, :ciudad)")
                .beanMapped()
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<DescripcionTiendaDto> descripcionTiendaWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<DescripcionTiendaDto>()
                .dataSource(dataSource)
                .sql("INSERT INTO descripcion_tienda (nombre) VALUES (:nombre)")
                .beanMapped()
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<PersonDto> personaWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PersonDto>()
                .dataSource(dataSource)
                .sql("INSERT INTO persona (nombre, edad) VALUES (:nombre, :edad)")
                .beanMapped()
                .build();
    }

//    @Bean
//    public ItemProcessor<TiendaInfoDto, List<Object>> tiendaInfoProcessor() {
//        return new TiendaInfoProcessor();
//    }

/*       @Bean
    public ItemReader<PersonDto> jsonItemReader() {

        String jsonString = "[{\"id\":\"1\",\"nombre\":\"Juan\",\"edad\":25},{\"id\":\"2\",\"nombre\":\"María\",\"edad\":30},{\"id\":\"3\",\"nombre\":\"Pedro\",\"edad\":40}]";


        return new JsonItemReaderBuilder<PersonDto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(PersonDto.class))
                .resource(new ByteArrayResource(jsonString.getBytes()))
                .name("jsonItemReader")
                .build();
    }*/

//    @Bean
//    public JdbcBatchItemWriter<Person2Dto> jdbcItemWriter(DataSource dataSource) {
//
//        return new JdbcBatchItemWriterBuilder<Person2Dto>()
//                .dataSource(dataSource)
//                .sql("INSERT INTO people (id, nombre, edad) VALUES (:id, :nombreCompleto, :edad)")
//                .beanMapped()
//                .build();
//    }

//    @Bean
//    public ItemProcessor<PersonDto, Person2Dto> personaProcessor() {
//        return new Person2DtoProcessor();
//    }
//


}
