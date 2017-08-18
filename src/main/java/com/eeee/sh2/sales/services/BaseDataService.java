package com.eeee.sh2.sales.services;

import java.util.List;
import java.util.Optional;

/**
 * Define common data operation
 * Created by Charles on 28/07/2017.
 */
public interface BaseDataService<T> {
    T add(T t);

    Optional<T> find(Long id);

    List<T> listAll();

    T save(T t);

    List<T> saveAll(List<T> rows);

    boolean delete(Long id);
}
