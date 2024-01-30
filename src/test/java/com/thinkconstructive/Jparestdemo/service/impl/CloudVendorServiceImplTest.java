package com.thinkconstructive.Jparestdemo.service.impl;

import com.thinkconstructive.Jparestdemo.controller.CloudVendorController;
import com.thinkconstructive.Jparestdemo.model.CloudVendor;
import com.thinkconstructive.Jparestdemo.repository.CloudVendorRepository;
import com.thinkconstructive.Jparestdemo.repository.CloudVendorRepositoryTest;
import com.thinkconstructive.Jparestdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor =  new CloudVendor("1", "Amazon", "USA", "xxxxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
    }

    @Test
    void createCloudVendor() {
    }

    @Test
    void testUpdateCloudVendor(){

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
    }
    @Test
    void updateCloudVendor() {
    }

    @Test
    void getCloudVendor() {

    }

    @Test
    void testGetCloudVendor(){

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void testGetByVendorName(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)
        ));

                assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());}


    @Test
    void testGetAllCLoudVendors(){

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());

    }

    @Test
    void testDeleteCloudVendor(){

        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());

        assertThat(cloudVendorService.deleteCloudVendor("i")).isEqualTo("Success");
    }
}