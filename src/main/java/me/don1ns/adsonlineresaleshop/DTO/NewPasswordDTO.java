package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class NewPasswordDTO {
    private String currentPassword;
    private String newPassword;
}
