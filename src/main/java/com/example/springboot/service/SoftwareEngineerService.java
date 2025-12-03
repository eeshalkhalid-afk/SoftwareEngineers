package com.example.springboot.service;

//make this class available as a bean
//so that spring instantiate sit an dmakes it available withing other classes for use

import com.example.springboot.dto.SoftwareEngineerDto;
import com.example.springboot.model.SoftwareEngineer;
import com.example.springboot.repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoftwareEngineerService
{
    private final SoftwareEngineerRepository softwareEngineerRepository;
    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository)
    {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    //usually instead of ur class SoftwareEngineer u have a dto,
    //bcz by using ur class u r exposing user to very pvt details
    //that u might not want the user to know.
    public List<SoftwareEngineerDto> getAllSoftwareEngineers()
    {
        List<SoftwareEngineer> allSoftwareEngineers= softwareEngineerRepository.findAll();
        List<SoftwareEngineerDto> softwareEngineerDtos = new ArrayList<>();
        allSoftwareEngineers.forEach(softwareEngineer ->
        {
            softwareEngineerDtos.add(mapToDto(softwareEngineer));
        }
        );
        return softwareEngineerDtos;
    }


    public SoftwareEngineerDto insertSoftwareEngineer(SoftwareEngineerDto softwareEngineerDto) {
        SoftwareEngineer softwareEngineer = mapToModel(softwareEngineerDto);
        return mapToDto(softwareEngineerRepository.save(softwareEngineer));
    }


    public SoftwareEngineerDto getSoftwareEngineerById(Integer id) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
        return mapToDto(softwareEngineer);
    }

    private SoftwareEngineer mapToModel(SoftwareEngineerDto softwareEngineerDto) {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        softwareEngineer.setName(softwareEngineerDto.getName());
        softwareEngineer.setTechStack(softwareEngineerDto.getTechStack());
        return softwareEngineer;
    }


    private SoftwareEngineerDto mapToDto(SoftwareEngineer softwareEngineer) {
        SoftwareEngineerDto softwareEngineerDto = new SoftwareEngineerDto();
        softwareEngineerDto.setId(softwareEngineer.getId());
        softwareEngineerDto.setName(softwareEngineer.getName());
        softwareEngineerDto.setTechStack(softwareEngineer.getTechStack());
        return softwareEngineerDto;
    }

    public void deleteSoftwareEngineerById(Integer id) {

        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineerDto updateSoftwareEngineerById(SoftwareEngineerDto softwareEngineerDto, Integer id) {

        SoftwareEngineer softwareEngineerById = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
        //maptomodel function
        softwareEngineerById.setName(softwareEngineerDto.getName());
        softwareEngineerById.setTechStack(softwareEngineerDto.getTechStack());

        return mapToDto(softwareEngineerRepository.save(softwareEngineerById));

    }
}

