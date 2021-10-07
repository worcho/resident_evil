package com.example.Resident.Evil.repositories;

import com.example.Resident.Evil.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, Long> {

    List<Capital> findAll();

    Capital findByName(String name);
}
