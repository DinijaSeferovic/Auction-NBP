package com.etf.nbp.controllers;

import com.etf.nbp.services.RoleService;
import com.etf.nbp.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //TODO
}
