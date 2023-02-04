package com.ugahacks.BestRoute;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ugahacks.BestRoute.data.ExportableUserData;
import com.ugahacks.BestRoute.data.ImportedUserData;


@RestController
@CrossOrigin(origins="*")
public class ApiController {
    //Will send data to the frontend
    @GetMapping("/receive")
    public ExportableUserData send(ExportableUserData data) {
        return data;
    }

    //Will receive data from the frontend
    @PostMapping("/send")
    public String receive(@RequestParam ImportedUserData data) {
        System.out.println(data.getCarMake());
        return "Received";
    }
}
