package storage;

import model.User;

import java.util.List;

public interface IGenaricSevice<T> {
    List<T> findAll();
    T findById(int id);

    boolean remove(int id);
    User save(T t);
}
