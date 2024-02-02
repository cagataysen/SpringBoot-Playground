package com.springpractises.restdemo.controller;

import org.springframework.web.bind.annotation.*;
import com.springpractises.restdemo.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    /*
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){
            return new CloudVendor("C1", "Vendor1", "Address 1", "xxxxx");
        }
     */

    //This one is just getting with url
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){
            return cloudVendor;
        }

     //POST method and creating data (json - raw format at POSTMAN)
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return  "Cloud Vendor created successfully";
    }

    //PUT method and updating the data with json raw format at postman
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return  "Cloud Vendor updated successfully";
    }

    //DELETE method and deleting the data according to its id at the url
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(String vendorId){
        this.cloudVendor = null;
        return  "Cloud Vendor deleted successfully";
    }

        }