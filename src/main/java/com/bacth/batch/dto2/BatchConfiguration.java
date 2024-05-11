package com.bacth.batch.dto2;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public JsonItemReader<Tienda> jsonItemReader() {
//        JacksonJsonObjectReader<Tienda> jsonObjectReader = new JacksonJsonObjectReader<>(Tienda.class);
//        jsonObjectReader.setMapper(new ObjectMapper());
//
//        return new JsonItemReaderBuilder<Tienda>()
//                .jsonObjectReader(jsonObjectReader)
//                .resource(new ClassPathResource("datos.json"))
//                .name("tiendaJsonItemReader")
//                .build();
//    }
//
////    @Bean
////    public ItemWriter<Tienda> multiItemWriter() {
////        CompositeItemWriter<Tienda> compositeItemWriter = new CompositeItemWriter<>();
////        compositeItemWriter.setDelegates(Arrays.asList(tiendaWriter(), direccionWriter(), clienteWriter()));
////        return compositeItemWriter;
////    }
//
//    @Bean
//    public CompositeItemWriter compositeWriter() throws Exception {
//        CompositeItemWriter compositeItemWriter = new CompositeItemWriter();
//        List<ItemWriter> writers = new ArrayList<ItemWriter>();
//        writers.add(tiendaWriter());
//        writers.add(direccionWriter());
//        writers.add(clienteWriter());
//        compositeItemWriter.setDelegates(writers);
//        return compositeItemWriter;
//    }
//
////    @Bean
////    public ItemWriter<Object> multiItemWriter() {
////        return new MultiItemWriter<>(Arrays.asList(tiendaWriter(), direccionWriter(), clienteWriter()));
////    }
//
//    @Bean
//    public JdbcBatchItemWriter<Tienda> tiendaWriter() {
//        JdbcBatchItemWriter<Tienda> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO tienda (nombre) VALUES (:nombreTienda)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Direccion> direccionWriter() {
//        JdbcBatchItemWriter<Direccion> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO direccion (calle, ciudad) VALUES (:calle, :ciudad)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Cliente> clienteWriter() {
//        JdbcBatchItemWriter<Cliente> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO cliente (nombre, apellido, edad) VALUES (:nombre, :apellido, :edad)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
//
//    @Bean
//    public Step step1() throws Exception {
//        return stepBuilderFactory.get("step1")
//                .<Tienda, Tienda>chunk(10)
//                .reader(jsonItemReader())
//                .writer(compositeWriter())
//                .build();
//    }
//
//    @Bean
//    public Job importTiendaJob() throws Exception {
//        return jobBuilderFactory.get("importTiendaJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(step1())
//                .end()
//                .build();
//    }
}
