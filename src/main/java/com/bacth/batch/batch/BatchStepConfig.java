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
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ItemWriter<DireccionTiendaDto> direccionTiendaWriter;

    @Autowired
    private ItemWriter<DescripcionTiendaDto> descripcionTiendaWriter;

    @Autowired
    private ItemWriter<PersonDto> personaWriter;


    @Autowired
    private ItemProcessor<TiendaInfoDto, List<Object>> tiendaInfoProcessor;


    @Bean
    public Step jsonGeneralStep() {

        List<ItemWriter<List<Object>>> itemWriters = new ArrayList<>();

//        List<ItemWriter<?>> writerList = new ArrayList<>();
//        writerList.add(direccionTiendaWriter);
//        writerList.add(descripcionTiendaWriter);
//        writerList.add(personaWriter);

//        ItemWriter<List<Object>> compositeItemWriter = new CompositeItemWriterBuilder<List<Object>>()
//                .delegates(Arrays.asList(
//                        direccionTiendaWriter,
//                        descripcionTiendaWriter,
//                        personaWriter))
//                .build();

        return stepBuilderFactory.get("jsonGeneralStep")
                .<TiendaInfoDto, List<Object>>chunk(10)
                .reader(jsonGeneralItemReader)
                .processor(tiendaInfoProcessor)
                .writer(compositeItemWriter())
                .build();
    }

//    @Bean
//    public ItemWriter<List<Object>> compositeItemWriter() {
//        // Crear el CompositeItemWriter combinando todos los escritores requeridos
//        return new CompositeItemWriterBuilder<List<Object>>()
//                .delegates(Arrays.asList(direccionTiendaWriter))
//                .build();
//    }

    @Bean
    public CompositeItemWriter compositeItemWriter() {
        List<ItemWriter<?>> writerList = new ArrayList<>();
        writerList.add(direccionTiendaWriter);
        writerList.add(descripcionTiendaWriter);

        CompositeItemWriter itemWriter = new CompositeItemWriter();

        itemWriter.setDelegates(writerList);

        return itemWriter;
    }
}
