package com.facultate.evstud.converters;

import com.facultate.evstud.dto.UserDTO;
import com.facultate.evstud.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    @Autowired
    private ModelMapper mapper;

    public UserDTO documentToDto(User user) {

        return mapper.map(user, UserDTO.class);
    }

    public User dtoToDocument(UserDTO userDTO) {

        return mapper.map(userDTO, User.class);
    }

    public List<UserDTO> convertToListOfDto(List<User> users) {

        return mapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
