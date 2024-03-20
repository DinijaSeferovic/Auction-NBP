package com.etf.nbp.dto;

public interface AuthDTO {

    public ErrorDTO validateInput();

    public String getEmail();

    public String getPassword();
}
