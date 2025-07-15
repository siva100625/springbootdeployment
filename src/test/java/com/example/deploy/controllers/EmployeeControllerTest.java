package com.example.deploy.controllers;

import com.example.deploy.models.RegisterDetails;
import com.example.deploy.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private RegisterDetailsRepository repo;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(repo.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> result = employeeController.getAll();
        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void testDelete() {
        int id = 1;
        doNothing().when(repo).deleteById(id);

        String response = employeeController.delete(id);
        assertEquals("Employee deleted", response);
        verify(repo, times(1)).deleteById(id);
    }
}
