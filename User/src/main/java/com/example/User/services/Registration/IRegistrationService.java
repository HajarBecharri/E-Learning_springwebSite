package com.example.User.services.Registration;

import com.example.User.dto.SignupDTO;
import com.example.User.dto.UserDTO;

public interface IRegistrationService {
    UserDTO createUser(SignupDTO signupDTO);
}
