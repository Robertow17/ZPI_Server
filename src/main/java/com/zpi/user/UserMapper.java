package com.zpi.user;


import com.zpi.favourite.FavouriteDTO;
import com.zpi.user.enums.Gender;
import com.zpi.user.enums.UserType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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
            @Mapping(target="type", source="type"),
            @Mapping(target="favourites", source="favourites")

    })
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOs(List<User> users);


    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);

}