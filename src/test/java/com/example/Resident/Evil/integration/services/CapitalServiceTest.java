package com.example.Resident.Evil.integration.services;


import com.example.Resident.Evil.entities.Capital;
import com.example.Resident.Evil.models.service.CapitalServiceModel;
import com.example.Resident.Evil.repositories.CapitalRepository;
import com.example.Resident.Evil.serivices.CapitalService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CapitalServiceTest {

    @Autowired
    CapitalService capitalService;

    @MockBean
    CapitalRepository capitalRepository;

    private List<Capital> capitals;
    @Before
    public void setupTest(){
        capitals = new ArrayList<>();
        when(capitalRepository.findAll())
                .thenReturn(capitals);
    }

    @Test
    public void findAllCapitals(){
        String capitalName = "Sofia";
        Long capitalId = 1L;
        Double capitalLatitude = 12.5;
        Double capitalLongitude = 10.5;

        Capital capital = new Capital();
        capital.setName(capitalName);
        capital.setCapitalId(capitalId);
        capital.setLatitude(capitalLatitude);
        capital.setLongitude(capitalLongitude);
        capitals.add(capital);

        var result = capitalService.getAllCapitals();
        CapitalServiceModel capitalResult = result.get(0);

        assertEquals(1, result.size());
        assertEquals(capitalName, capitalResult.getName());
        assertEquals(capitalId, capitalResult.getCapitalId());
        assertEquals(capitalLatitude, capitalResult.getLatitude());
        assertEquals(capitalLongitude, capitalResult.getLongitude());

    }
    @Test
    public void findAllCapitals_whenNoCapitals(){

        capitals.clear();
        var result = capitalService.getAllCapitals();

        assertTrue(result.isEmpty());
    }
}
