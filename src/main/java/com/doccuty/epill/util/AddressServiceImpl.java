package com.doccuty.epill.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"default", "heroku"})
public class AddressServiceImpl implements AddressService {
    @Value("${addressService.address}")
    private String serverAddress;

    @Override
    public String getServerURL() {
        return serverAddress;
    }
}
