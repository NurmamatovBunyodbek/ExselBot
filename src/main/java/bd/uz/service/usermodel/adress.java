package bd.uz.service.usermodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class adress {

private String street;
private String suite;
private String city;
private String zipcode;
private geo geo;

}
