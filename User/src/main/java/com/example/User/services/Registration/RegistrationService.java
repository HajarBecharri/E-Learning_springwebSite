package com.example.User.services.Registration;

import com.example.User.Admin;
import com.example.User.Student;
import com.example.User.Teacher;
import com.example.User.User;
import com.example.User.dto.SignupDTO;
import com.example.User.dto.UserDTO;
import com.example.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class RegistrationService implements IRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        String role = signupDTO.getRole();
        User user;

        if ("STUDENT".equalsIgnoreCase(role)) {
            user = new Student();
            ((Student) user).setClass_id(signupDTO.getClass_id());
        } else if ("TEACHER".equalsIgnoreCase(role)) {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String shortDate = currentDate.format(dateFormatter);
            user = new Teacher();
            ((Teacher) user).setSpeciality(signupDTO.getSpeciality());
            ((Teacher) user).setAffectationDate(shortDate);
        } else if ("ADMIN".equalsIgnoreCase(role)) {
            user = new Admin();
        } else {
            return new UserDTO();
        }

        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));

        User createdUser = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getName());
        userDTO.setRole(role);

        return userDTO;
    }}