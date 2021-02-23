package storage;

import java.util.List;

public interface IGenaricSevice<T> {
    List<T> findAll();
    T findById(int id);

    boolean remove(int id);
    boolean save(T t);
}
