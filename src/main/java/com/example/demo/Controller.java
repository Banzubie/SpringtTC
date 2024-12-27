package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    private Map<String, Device> db = new HashMap<>() {{
        put("1", new Device("1", "HVAC"));
    }};

    @GetMapping("/")
    public String mainPage() {

        return "Hello World!";
    }

    @GetMapping("/getDevices")
    public Collection<Device> getDevices() {
        return db.values();
    }

    @GetMapping("/getDevice/{id}")
    public String getDevice(@PathVariable @Valid String id) {
        return "Find device " + id;
    }


    @GetMapping("/command/{id}/{action}")
    public String commandDevice(@PathVariable @Valid String id, @PathVariable @Valid String action) {

        return "Device: " + id + ", Command: " + action;
    }

    @GetMapping("/stop/{id}")
    public String stopDevice(@PathVariable @Valid String id) {
        Device device = db.get(id);
        if (device == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return "Device " + id + " Stopped";
    }
}
