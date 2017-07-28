package com.eeee.sh2.sales.services;

import java.util.List;
import java.util.Optional;

/**
 * Define common data operation
 * Created by Charles on 28/07/2017.
 */
public interface BaseDataService<T> {
    List<T> saveAll(List<T> rows);
    Optional<T> find(Long id);
}
