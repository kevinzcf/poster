package com.kevinzcf.poster.dto;

import lombok.Data;

/**
 * @author kevinzcf
 * @version 2019
 */

@Data
public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private GeoDTO geo;
}
