package com.next.app.api.user.service;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사업자를 찾을 수 없습니다. id: " + id));
    }

    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }

    public Business updateBusiness(Long id, Business updated) {
        Business business = getBusinessById(id);
        business.setBusinessNumber(updated.getBusinessNumber());
        business.setCompanyName(updated.getCompanyName());
        business.setRepresentativeName(updated.getRepresentativeName());
        business.setContactEmail(updated.getContactEmail());
        business.setContactPhone(updated.getContactPhone());
        business.setAddress(updated.getAddress());
        business.setRegisteredAt(updated.getRegisteredAt());
        return businessRepository.save(business);
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
