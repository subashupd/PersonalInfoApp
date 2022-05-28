package com.example.Personaldetail.Service;

import com.example.Personaldetail.Model.Address;
import com.example.Personaldetail.Model.InfoRequest;
import com.example.Personaldetail.Model.InfoResponse;
import com.example.Personaldetail.Model.Name;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class InfoService {
    public InfoResponse processInfo(InfoRequest infoRequest) {
        InfoResponse infoResponse = new InfoResponse();
        Name name = new Name();
        name.setFirstName(infoRequest.getFirstName());
        name.setLastName(infoRequest.getLastName());
        infoResponse.setName(name);
        Address address = new Address();
        address.setStreet(infoRequest.getStreet());
        address.setCity(infoRequest.getCity());
        address.setState(infoRequest.getState());
        address.setZipCode(infoRequest.getZipCode());
        infoResponse.setAddress(address);

        infoResponse.setPhone(infoRequest.getPhone());
        infoResponse.setId(generateId(infoRequest.getFirstName(), infoRequest.getLastName(), infoRequest.getPhone()));

        return infoResponse;

    }

    // use libraries -> StringUtils. lastFourDigits = input.substring(input.length()-4);
   private static String generateId(String firstName, String lastName, int phoneNumber) {

        String value = String.valueOf(phoneNumber).substring(5,9);
        String id = String.valueOf(firstName.charAt(0)).toUpperCase() + String.valueOf(lastName.charAt(0)).toUpperCase() + value;
        return id;
    }
}