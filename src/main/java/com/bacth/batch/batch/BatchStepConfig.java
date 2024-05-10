package com.bacth.batch.batch;


import com.bacth.batch.dtos.DescripcionTiendaDto;
import com.bacth.batch.dtos.DireccionTiendaDto;
import com.bacth.batch.dtos.PersonDto;
import com.bacth.batch.dtos.TiendaInfoDto;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BatchStepConfig {

    //    @Autowired
//    private ItemReader<PersonDto> jsonItemReader;
//
//    @Autowired
//    private JdbcBatchItemWriter<Person2Dto> jdbcItemWriter;
//
//    @Autowired
//    private ItemProcessor<PersonDto, Person2Dto> personaProcessor;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Autowired
    private ItemReader<TiendaInfoDto> jsonGeneralItemReader;

    @Autowired
    private JdbcBatchItemWriter<DireccionTiendaDto> direccionTiendaWriter;

    @Autowired
    private JdbcBatchItemWriter<DescripcionTiendaDto> descripcionTiendaWriter;

    @Autowired
    private JdbcBatchItemWriter<PersonDto> personaWriter;


    @Autowired
    private ItemProcessor<TiendaInfoDto, List<Object>> tiendaInfoProcessor;


    @Bean
    public Step jsonGeneralStep() {


        return stepBuilderFactory.get("jsonGeneralStep")
                .<TiendaInfoDto, List<Object>>chunk(10)
                .reader(jsonGeneralItemReader)
                .processor(tiendaInfoProcessor)
                .writer(compositeItemWriter())
                .build();
    }

    @Bean
    public CompositeItemWriter compositeItemWriter() {
        List<ItemWriter> writers = new ArrayList<>();
        writers.add(direccionTiendaWriter);
        writers.add(descripcionTiendaWriter);

        CompositeItemWriter itemWriter = new CompositeItemWriter();

        itemWriter.setDelegates(writers);

        return itemWriter;
    }
}
