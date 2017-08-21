package com.eeee.sh2.sales.services;

import com.eeee.sh2.sales.exceptions.RecordNotFoundException;
import com.eeee.sh2.sales.model.PersistentObject;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Charles on 18/2017.
 */
public abstract class DefaultDataServiceImpl<T extends PersistentObject> implements BaseDataService<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    @Override
    public T add(T t) {
        t.setId(null);
        return getRepository().save(t);
    }

    @Override
    public Optional<T> find(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> listAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Order
    public T update(T t) throws RecordNotFoundException {
        T oldRecord = this.find(t.getId()).orElseThrow(RecordNotFoundException::new);
        BeanUtils.copyProperties(t, oldRecord);
        return getRepository().save(oldRecord);
    }


    @Override
    public List<T> saveAll(List<T> rows) {
        return rows.stream().map(row -> this.save(row)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        try {
            getRepository().deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
