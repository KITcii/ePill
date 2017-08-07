package com.doccuty.epill.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.doccuty.epill.util.AddressService;

/**
 * Note that this is a CONSTRUCTED example since in this particular case we would simple change the definition
 * in application.properties.
 */
@Service
@Profile("test")
public class AddressServiceTestImpl implements AddressService {
    @Value("${addressService.address}")
    private String serverAddress;

    @Override
    public String getServerURL() {
        return serverAddress;
    }
}
