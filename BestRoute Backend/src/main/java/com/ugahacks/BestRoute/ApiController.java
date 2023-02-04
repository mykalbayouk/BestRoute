package com.ugahacks.BestRoute;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* 
 * NOTES:
 *  - When you want to send data to the frontend, you can use @GetMapping to return data.
 *  - When you want to receive data from the frontend, you can use @PostMapping to receive data.
 */
@RestController
@CrossOrigin(origins="*")
public class ApiController {
    @GetMapping("/action")
    public String action() {
        return "Hello World!";
    }
}
