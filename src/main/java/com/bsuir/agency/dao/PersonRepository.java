package com.bsuir.agency.dao;

import com.bsuir.agency.entity.PersonEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 14.04.2017.
 */
@Repository
@Transactional
public interface PersonRepository {
    List<PersonEntity> getAllUsers();
    PersonEntity findById(int id);
    PersonEntity findByLogin(String login);
    Iterable<PersonEntity> findByRole(String role);
    void create(PersonEntity personEntity);
    void update(PersonEntity personEntity);
    void delete(PersonEntity personEntity);
}
