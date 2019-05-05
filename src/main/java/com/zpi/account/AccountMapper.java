package com.zpi.account;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper
{
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);


    @Mappings({
            @Mapping(target="user", source="user"),
            @Mapping(target="service", source="service")
    })
    AccountDTO toAccountDTO(Account favourite);

    List<AccountDTO> toAccountDTOs(List<Account> favourites);

    @InheritInverseConfiguration
    Account toAccount(AccountDTO favouriteDTO);

}
