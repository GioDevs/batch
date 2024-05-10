package com.bacth.batch.batch;


import com.bacth.batch.entity.Person2Dto;
import com.bacth.batch.entity.PersonDto;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<PersonDto> jsonItemReader;

    @Autowired
    private JdbcBatchItemWriter<Person2Dto> jdbcItemWriter;

    @Autowired
    private ItemProcessor<PersonDto, Person2Dto> personaProcessor;

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<PersonDto, Person2Dto>chunk(10)
                .reader(jsonItemReader)
                .processor(personaProcessor)
                .writer(jdbcItemWriter)
                .build();
    }
}
