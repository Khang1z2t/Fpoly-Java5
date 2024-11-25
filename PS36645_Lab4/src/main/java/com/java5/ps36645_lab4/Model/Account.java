package com.java5.ps36645_lab4.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Account {
    @NotBlank(message = "Please enter User Name")
    String username;
    @NotBlank(message = "Please enter Password")
    String password;
    @NotBlank(message = "Please enter Full Name")
    @Email
    String email;
    MultipartFile avatar;
}
