package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class UserDTO {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String image;
}
