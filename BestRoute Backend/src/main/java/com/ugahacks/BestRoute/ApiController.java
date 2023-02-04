package com.ugahacks.BestRoute;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public @ResponseBody ExportableUserData receive(ImportedUserData data) {
        Manager manager = new Manager(data);
            manager.process();
            return manager.export();
    }
}
