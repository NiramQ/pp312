package ru.avm.ex312.service;

import ru.avm.ex312.model.Person;

import java.util.List;

public interface UserService {

    void saveUser(Person user);

    void updateUser(Person user, int id);

    void removeUser(int id);

    Person getUserById(int id);

    List<Person> getListUsers();
}
