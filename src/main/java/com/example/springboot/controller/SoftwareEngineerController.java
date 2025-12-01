package com.example.springboot.controller;

import com.example.springboot.dto.SoftwareEngineerDto;
import com.example.springboot.service.SoftwareEngineerService;
import com.example.springboot.model.SoftwareEngineer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController
{
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){

        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineerDto getEngineerById(@PathVariable Integer id){

        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public SoftwareEngineerDto addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        return softwareEngineerService.insertSoftwareEngineer(softwareEngineer);

    }

    @DeleteMapping("{id}")
    public void deleteEngineerById(@PathVariable Integer id){

        softwareEngineerService.deleteSoftwareEngineerById(id);
    }

    @PutMapping("{id}")

    public void updateEngineerById(@RequestBody SoftwareEngineer softwareEngineer, @PathVariable Integer id){

        softwareEngineerService.updateSoftwareEngineerById(softwareEngineer,id);
    }
}
