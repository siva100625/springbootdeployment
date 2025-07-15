package com.example.deploy.services;

import com.example.deploy.models.RegisterDetails;
import com.example.deploy.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    @Mock
    private RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();

        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> res = employeeService.getMethod();  // assuming getMethod() internally calls findAll()

        assertEquals(2, res.size());
    }
}
