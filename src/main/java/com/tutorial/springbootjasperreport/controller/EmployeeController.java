package com.tutorial.springbootjasperreport.controller;

import com.tutorial.springbootjasperreport.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/report/{format}")
    public String generatorReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return employeeService.exportReport(format);
    }
}
