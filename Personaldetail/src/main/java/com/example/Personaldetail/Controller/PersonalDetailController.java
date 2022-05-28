package com.example.Personaldetail.Controller;

import com.example.Personaldetail.Model.Address;
import com.example.Personaldetail.Model.InfoRequest;
import com.example.Personaldetail.Model.InfoResponse;
import com.example.Personaldetail.Model.Name;
import com.example.Personaldetail.Service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDetailController {

    @Autowired
    InfoService infoService;

    @PostMapping("/create-info")
    public InfoResponse createPersonalInfo(@RequestBody InfoRequest infoRequest) {
        InfoService infoService = new InfoService();
        return infoService.processInfo(infoRequest);
    }

}

