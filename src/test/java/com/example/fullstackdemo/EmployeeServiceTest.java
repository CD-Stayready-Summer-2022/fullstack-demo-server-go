package com.example.fullstackdemo;

import com.example.fullstackdemo.domain.employee.models.Employee;
import com.example.fullstackdemo.domain.employee.repos.EmployeeRepo;
import com.example.fullstackdemo.domain.employee.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    public void createTest(){
        Employee mockEmployee = new Employee("first" , "name", "email");
        Employee afterEmployee = new Employee("first" , "name", "email");
        afterEmployee.setId(1l);
        BDDMockito.doReturn(afterEmployee).when(employeeRepo).save(mockEmployee);
        Employee actual = employeeService.create(mockEmployee);
        Assertions.assertEquals(afterEmployee, actual);
    }

    @Test
    public void getByIdTest(){
        Employee mockEmployee = new Employee("first" , "name", "email");
        mockEmployee.setId(1l);
        BDDMockito.doReturn(mockEmployee).when(employeeRepo).findById(1l);
        Employee actual = employeeService.getById(1l);
        Assertions.assertEquals(mockEmployee, actual);
    }
}
