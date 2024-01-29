package com.thinkconstructive.Jparestdemo.repository;

//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import com.thinkconstructive.Jparestdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    List<CloudVendor> findByVendorName(String vendorName);

}
