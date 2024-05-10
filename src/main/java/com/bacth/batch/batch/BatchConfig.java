package com.bacth.batch.batch;

import com.bacth.batch.entity.Person2Dto;
import com.bacth.batch.entity.PersonDto;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Bean
    public ItemReader<PersonDto> jsonItemReader() {

        String jsonString = "[{\"id\":\"1\",\"nombre\":\"Juan\",\"edad\":25},{\"id\":\"2\",\"nombre\":\"María\",\"edad\":30},{\"id\":\"3\",\"nombre\":\"Pedro\",\"edad\":40}]";


        return new JsonItemReaderBuilder<PersonDto>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(PersonDto.class))
                .resource(new ByteArrayResource(jsonString.getBytes()))
                .name("jsonItemReader")
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person2Dto> jdbcItemWriter(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Person2Dto>()
                .dataSource(dataSource)
                .sql("INSERT INTO people (id, nombre, edad) VALUES (:id, :nombreCompleto, :edad)")
                .beanMapped()
                .build();
    }

    @Bean
    public ItemProcessor<PersonDto, Person2Dto> personaProcessor() {
        return new Person2DtoProcessor();
    }



}
