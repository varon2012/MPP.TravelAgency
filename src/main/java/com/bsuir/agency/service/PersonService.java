package com.bsuir.agency.service;

import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.entity.RoleEnum;

import java.util.List;

/**
 * Created by Олег Пятко on 14.04.2017.
 */
public interface PersonService {
    List<PersonEntity> getAllPersons();
    PersonEntity findById(int id);
    PersonEntity findByLogin(String login);
    PersonEntity findByEmail(String email);
    Iterable<PersonEntity> findByRole(RoleEnum role);
    void create(PersonEntity personEntity);
    void update(PersonEntity personEntity);
    void delete(PersonEntity personEntity);
}
