package com.innova.training.spring.person.rest.mappers;

import com.innova.training.spring.person.models.Person;
import com.innova.training.spring.rest.models.PersonRest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IPersonMapper {

    IPersonMapper PERSON_MAPPER = Mappers.getMapper(IPersonMapper.class);

    Person toPerson(PersonRest personRest);

    PersonRest toPersonRest(Person person);

    List<Person> toPersons(List<PersonRest> personRests);

    List<PersonRest> toPersonRests(List<Person> person);

}
