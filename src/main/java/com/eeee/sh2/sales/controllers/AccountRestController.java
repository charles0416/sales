package com.eeee.sh2.sales.controllers;


import com.eeee.sh2.sales.exceptions.BadRequestException;
import com.eeee.sh2.sales.model.Account;
import com.eeee.sh2.sales.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Charles on 15/06/2017.
 */
@RestController
@RequestMapping("/api/users")
public class AccountRestController {

    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account add(@RequestBody Account input) {
        Account newUser = null;
        try {
            newUser = accountService.add(input);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        return newUser;
    }
}
