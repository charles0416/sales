package com.eeee.sh2.sales.services;

import com.eeee.sh2.sales.model.Commodity;
import com.eeee.sh2.sales.repositories.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Charles on 28/07/2017.
 */
@Service
public class CommodityServiceImpl extends DefaultDataServiceImpl<Commodity> implements CommodityService {

    @Autowired
    CommodityRepository commodityRepository;

    @Override
    protected JpaRepository<Commodity, Long> getRepository() {
        return commodityRepository;
    }
}
