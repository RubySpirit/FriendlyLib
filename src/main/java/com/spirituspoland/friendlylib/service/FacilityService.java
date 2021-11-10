package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import com.spirituspoland.friendlylib.mapper.FacilityMapper;
import com.spirituspoland.friendlylib.model.Facility;
import com.spirituspoland.friendlylib.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;
    public Page<BasicFacilityDTO> findAllFacilities(Pageable pageable){
        return facilityRepository.findAll(pageable).map(facilityMapper::toDto);
    }
    
    public Facility addNewFacility(Facility facility){
        return facilityRepository.save(facility);
    }

}
