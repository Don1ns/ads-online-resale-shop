package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

@Data
public class RegisterReqDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
}
