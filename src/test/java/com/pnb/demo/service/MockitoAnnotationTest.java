package com.pnb.demo.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MockitoAnnotationTest {

    @Mock
    private ArrayList<String> mockList;

    @Spy
    private ArrayList<String> spyList;

    @Test
     void whenNotUseMockAnnotation_thenCorrect() {
        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @Test
    void spyListTest() {
        spyList.add("one");
        assertEquals(1, spyList.size());
        //call doReturn for Spy
        doReturn(100).when(spyList).size();
        System.out.println("test checkin");
        assertEquals(100, spyList.size());
    }

    @Test
    public void throw_NPE() {

        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    System.out.println("test checkin");
                    System.out.println("test checkin");
                    System.out.println(mockList.size());
                    mockList.get(200);
                });
    }
}
