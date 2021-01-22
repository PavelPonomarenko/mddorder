package ua.com.mddorder.service;


import java.util.List;

public interface RootCrudService<T> {

    List<? extends T> getAll();

    T getOne(Long id);

    void create(T t);

    void update(Long id, T t);

    void delete(T t);
}
