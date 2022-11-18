package ru.avm.ex312.dao;

import ru.avm.ex312.model.Person;

import java.util.List;

public interface UserDAO {

    void saveUser(Person user);

    void updateUser(Person user, int id);

    void removeUser(int id);

    Person getUserById(int id);

    List<Person> getListUsers();
}
