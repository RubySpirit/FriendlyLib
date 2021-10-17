package com.spirituspoland.friendlylib.service;

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

    public Page<Facility> findAllFacilities(Pageable pageable){
        return facilityRepository.findAll(pageable);
    }
}
