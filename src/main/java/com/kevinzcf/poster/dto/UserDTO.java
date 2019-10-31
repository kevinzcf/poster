package com.kevinzcf.poster.dto;

import lombok.Data;

/**
 * @author kevinzcf
 * @version 2019
 */
@Data
public class UserDTO {
    private String id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
}
