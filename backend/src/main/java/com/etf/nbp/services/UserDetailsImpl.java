package com.etf.nbp.services;

import com.etf.nbp.domains.Card;
import com.etf.nbp.domains.Location;
import com.etf.nbp.domains.Role;
import com.etf.nbp.domains.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsImpl implements UserDetails {

    private UUID id;

    private String email;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String phoneNumber;

    private String picture;

    private Boolean active;

    private Location location;

    private Card card;

    private Set<Role> roles;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(UUID id, String email, String password, String firstName, String lastName,
                           Date dateOfBirth, String phoneNumber, String picture, Boolean active,
                           Location location, Card card, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
        this.active = active;
        this.location = location;
        this.card = card;
        this.roles = roles;
    }

    public UserDetailsImpl(UUID id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {

        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getPhoneNumber(),
                user.getImagePath(),
                user.getActive(),
                user.getLocation(),
                user.getCard(),
                user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPicture() {
        return picture;
    }

    public Boolean getActive() {
        return active;
    }

    public Location getLocation() {
        return location;
    }

    public Card getCard() {
        return card;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}