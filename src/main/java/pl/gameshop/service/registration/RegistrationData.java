package pl.gameshop.service.registration;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data @ToString(exclude = "password")
public class RegistrationData {

    @NotBlank @Size(min = 3, max = 12)
    private String username;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(min = 8, max = 12)
    private String password;
}