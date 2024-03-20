package com.etf.nbp.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoryDTO {

    private UUID id;

    private String name;
}