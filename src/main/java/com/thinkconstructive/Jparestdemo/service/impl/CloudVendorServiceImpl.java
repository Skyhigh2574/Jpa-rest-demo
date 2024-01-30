package com.thinkconstructive.Jparestdemo.service.impl;
import com.thinkconstructive.Jparestdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.Jparestdemo.repository.CloudVendorRepository;
import com.thinkconstructive.Jparestdemo.model.CloudVendor;
import com.thinkconstructive.Jparestdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import  java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService
{
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {

        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {

        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){

            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {

        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName){

        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
