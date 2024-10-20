package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return mocklist
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * checks if correctly returns bool based on if city is in list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        assertFalse(list.hasCity("Edmonton"));
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity("Estevan"));
    }

    /**
    * checks if correctly deletes city if it is in the list
    * */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity("Edmonton"));
        list.deleteCity("Edmonton");
        assertFalse(list.hasCity("Edmonton"));
    }

    /**
     * checks if correctly counts number of cities in list
     * */
    @Test
    void testCount() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(1, list.count());
        list.addCity(new City("Victoria", "British Columbia"));
        assertEquals(2, list.count());
    }
}
