package com.zpi.transport_details;



import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransportDetailsMapper
{

    TransportDetailsMapper INSTANCE = Mappers.getMapper(TransportDetailsMapper.class);

    TransportDetailsDTO toTransportDetailsDTO(TransportDetails transportDetails);
    List<TransportDetailsDTO> toTransportDetailsDTOs(List<TransportDetails> transportDetails);
    TransportDetails toTransportDetails(TransportDetailsDTO transportDetailsDTO);

}
