package com.example.springboot.repository;

import com.example.springboot.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer, Integer>
    //it takes <T,dt for key> -> id integer
    {

    }
