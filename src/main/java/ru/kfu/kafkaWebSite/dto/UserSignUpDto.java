package ru.kfu.kafkaWebSite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDto {

    private String email;
    private String name;
    private String password;
    private String repeatPassword;
}
