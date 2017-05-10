package com.bsuir.agency.service.impl;

import com.bsuir.agency.dao.PersonRepository;
import com.bsuir.agency.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Олег Пятко on 14.04.2017.
 */
@org.springframework.stereotype.Service
public class PersonServiceImpl implements com.bsuir.agency.service.PersonService {
    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.getAllUsers();
    }

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
