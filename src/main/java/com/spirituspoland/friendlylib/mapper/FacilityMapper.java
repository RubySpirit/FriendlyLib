package com.spirituspoland.friendlylib.mapper;

import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import com.spirituspoland.friendlylib.model.Facility;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  abstract class FacilityMapper {

    public abstract BasicFacilityDTO toDto(Facility facility);
    public abstract List<BasicFacilityDTO> toDto(List<Facility> facility);

}
