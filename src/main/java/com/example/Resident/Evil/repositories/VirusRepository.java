package com.example.Resident.Evil.repositories;

import com.example.Resident.Evil.entities.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VirusRepository extends JpaRepository<Virus,Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into viruses_capitals(virus_id,capital_id) values(?1,?2)"
    , nativeQuery = true)
    void saveManyToMany(Long virusId, Long capitalId);

    @Query(value = "SELECT virus_id FROM virus where name=?1"
            ,nativeQuery = true)
    Long getIdByName(String name);

    List<Virus> findAll();
}
