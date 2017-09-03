package com.bsuir.agency.dao;

import com.bsuir.agency.entity.PersonEntity;
import com.bsuir.agency.entity.RoleEnum;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Олег Пятко on 14.04.2017.
 */
@Repository
@Transactional
public interface PersonRepository extends BaseRepository {
    List<PersonEntity> getAllUsers();
    PersonEntity findById(int id);
    PersonEntity findByLogin(String login);
    PersonEntity findByEmail(String email);
    Iterable<PersonEntity> findByRole(RoleEnum role);
    void create(PersonEntity personEntity);
    void update(PersonEntity personEntity);
    void delete(PersonEntity personEntity);
}
