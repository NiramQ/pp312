package ru.avm.ex312.dao;

import org.springframework.stereotype.Component;
import ru.avm.ex312.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getListUsers() {
        return entityManager.createQuery("SELECT x FROM Person x", Person.class).getResultList();
    }

    @Override
    public void saveUser(Person user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Person user, int id) {
        Person userToBeUpdate = getUserById(id);
        userToBeUpdate.setName(user.getName());
        userToBeUpdate.setAge(user.getAge());
        userToBeUpdate.setEmail(user.getEmail());
        entityManager.merge(userToBeUpdate);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(entityManager.contains(getUserById(id)) ? getUserById(id) : entityManager.merge(getUserById(id)));
    }

    @Override
    public Person getUserById(int id) {
        return entityManager.find(Person.class, id);
    }
}
