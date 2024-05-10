package com.bacth.batch.batch;

import com.bacth.batch.dtos.Person2Dto;
import com.bacth.batch.dtos.PersonDto;
import org.springframework.batch.item.ItemProcessor;

public class Person2DtoProcessor implements ItemProcessor<PersonDto, Person2Dto> {

    @Override
    public Person2Dto process(PersonDto personDto){

        return new Person2Dto(personDto.getId(), personDto.getNombre().concat(" apellido"), personDto.getEdad());
    }
}
