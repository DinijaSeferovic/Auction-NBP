package com.etf.nbp.domains;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private Date birthDate;

    private String phoneNumber;

    private Role role;

    private Location location;
}