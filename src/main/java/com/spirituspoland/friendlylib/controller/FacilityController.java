package com.spirituspoland.friendlylib.controller;


import com.spirituspoland.friendlylib.dto.BasicFacilityDTO;
import com.spirituspoland.friendlylib.dto.CreateFacilityDTO;
import com.spirituspoland.friendlylib.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("facilities")
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;


    @GetMapping
    public Page<BasicFacilityDTO> getFacilities(Pageable pageable) {
        return facilityService.findAllFacilities(pageable);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public BasicFacilityDTO createFacility(@RequestBody CreateFacilityDTO facilityDTO) {
        return facilityService.addNewFacility(facilityDTO);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping
    public BasicFacilityDTO updateFacility(@RequestBody BasicFacilityDTO basicFacilityDTO) {
        return facilityService.updateFacility(basicFacilityDTO);
    }
}
