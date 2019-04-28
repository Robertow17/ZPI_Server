package com.zpi.user;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper
{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target="login", source="login"),
            @Mapping(target="password", source="password"),
            @Mapping(target="gender", source="gender"),
            @Mapping(target="type", source="type")

    })
    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);

    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);

}