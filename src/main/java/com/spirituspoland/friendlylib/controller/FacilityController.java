package com.spirituspoland.friendlylib.controller;


import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import com.spirituspoland.friendlylib.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("facilities")
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    public Page<BasicFacilityDTO> getFacilities(Pageable pageable){
        return facilityService.findAllFacilities(pageable);
    }
}
