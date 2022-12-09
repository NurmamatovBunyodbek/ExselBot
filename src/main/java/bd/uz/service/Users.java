package bd.uz.service;

import bd.uz.service.usermodel.adress;
import bd.uz.service.usermodel.company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    private Long id;
    private String name;
    private String username;
    private adress address;
    private String email;
    private String phone;
    private String website;
    private company company;

}
