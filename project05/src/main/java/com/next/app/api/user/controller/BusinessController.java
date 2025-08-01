package com.next.app.api.user.controller;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
@Tag(name = "Business Controller", description = "사업자 관리 API")
@CrossOrigin(origins = "http://localhost")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Operation(summary = "모든 사업자 조회", description = "등록된 모든 사업자 목록을 반환합니다.")
    @GetMapping
    public List<Business> getAll() {
        return businessService.getAllBusinesses();
    }

    @Operation(summary = "사업자 단건 조회", description = "사업자 ID로 특정 사업자 정보를 조회합니다.")
    @GetMapping("/{id}")
    public Business getById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }

    @Operation(summary = "사업자 등록", description = "새로운 사업자 정보를 등록합니다.")
    @PostMapping
    public Business create(@RequestBody Business business) {
        return businessService.createBusiness(business);
    }

    @Operation(summary = "사업자 정보 수정", description = "사업자 ID에 해당하는 정보를 수정합니다.")
    @PutMapping("/{id}")
    public Business update(@PathVariable Long id, @RequestBody Business updated) {
        return businessService.updateBusiness(id, updated);
    }

    @Operation(summary = "사업자 삭제", description = "사업자 ID에 해당하는 사업자 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }
}
