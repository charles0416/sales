package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.model.Commodity;
import com.eeee.sh2.sales.services.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Charles on 8/18/2017.
 */
@RestController
@RequestMapping("/api/commodities")
public class CommodityRestController extends AbstractDataRestController<CommodityService, Commodity> {

    @Autowired
    CommodityService commodityService;

    @Override
    protected CommodityService getService() {
        return this.commodityService;
    }
}
