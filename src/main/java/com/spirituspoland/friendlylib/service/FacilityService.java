package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import com.spirituspoland.friendlylib.dto.CreateFacilityDTO;
import com.spirituspoland.friendlylib.mapper.FacilityMapper;
import com.spirituspoland.friendlylib.model.Facility;
import com.spirituspoland.friendlylib.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;

    public Page<BasicFacilityDTO> findAllFacilities(Pageable pageable) {
        return facilityRepository.findAll(pageable).map(facilityMapper::toDto);
    }

    public BasicFacilityDTO addNewFacility(CreateFacilityDTO facility) {
        Facility createdFacility = facilityRepository.save(facilityMapper.toEntity(facility));
        return facilityMapper.toDto(createdFacility);
    }

    public BasicFacilityDTO getFacility(long id) {
        return facilityMapper.toDto(
                facilityRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new));
    }

    public BasicFacilityDTO updateFacility(BasicFacilityDTO facilityDTO) {
        Facility facility = facilityRepository.findById(facilityDTO.id())
                .orElseThrow(EntityNotFoundException::new);
        Facility updatedFacility = facilityMapper.toEntity(facilityDTO);
        updatedFacility.setId(facility.getId());
        return facilityMapper.toDto(facilityRepository.save(updatedFacility));
    }

}
