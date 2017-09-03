package com.bsuir.agency.service.impl;

import com.bsuir.agency.dao.PersonRepository;
import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.entity.RoleEnum;
import com.bsuir.agency.service.ServiceException;
import com.bsuir.agency.utils.HelpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public PersonEntity findById(int id) {
        return personRepository.findById(id);
    }


    @Transactional
    @Override
    public PersonEntity findByLogin(String login) {
        return personRepository.findByLogin(login);
    }


    @Transactional
    @Override
    public PersonEntity findByEmail(String email) {
        return personRepository.findByEmail(email);
    }


    @Transactional
    @Override
    public Iterable<PersonEntity> findByRole(RoleEnum role) {
        return personRepository.findByRole(role);
    }


    @Transactional
    @Override
    public void create(PersonEntity personEntity) {
        checkUserCredentials(personEntity);
        personEntity.setRole(RoleEnum.user);
        personRepository.create(personEntity);
    }


    @Transactional
    @Override
    public void update(PersonEntity personEntity) {

    }


    @Transactional
    @Override
    public void delete(PersonEntity personEntity) {

    }

    private void checkUserCredentials(PersonEntity person){
        if (person == null){
            throw new ServiceException("user cant be null");
        }

        if (HelpUtils.isNullOrEmpty(person.getEmail())){
            throw new ServiceException("invalid email");
        }

        if (personRepository.findByEmail(person.getEmail()) != null){
            throw new ServiceException("user with such email exists");
        }

        if (HelpUtils.isNullOrEmpty(person.getLogin())){
            throw new ServiceException("invalid login");
        }

        if (personRepository.findByLogin(person.getLogin()) != null){
            throw new ServiceException("user with such login exists");
        }

        if (HelpUtils.isNullOrEmpty(person.getPasswordHash())){
            throw new ServiceException("invalid password");
        }
    }

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
