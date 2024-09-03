package time.off.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import time.off.app.dto.EmployeeDTO;
import time.off.app.service.EmployeeService;

import java.util.List;

@RestController
@Tag(name = "Employee Service", description = "Handle employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Save new Employee", description = "Employee")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Good"),
            @ApiResponse(responseCode = "500", description = "error")
    })


    @RequestMapping(value = "employee/save",
            produces = "application/json", consumes = "application/json",
            method = RequestMethod.POST)
    public void saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);

    }

    @Operation(summary = "Search Employee By Matricule", description = "Employee")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "ERROR")
    })
    @RequestMapping(value = "employee/{matricule}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<EmployeeDTO> searchEmployeeByMatricule(@PathVariable String matricule) {

        EmployeeDTO employeeDTO = employeeService.findEmployeeByMatricule(matricule);
        if (employeeDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with matricule " + matricule + " Does not exist");
        }

        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
    @Operation(summary = "get All Employees", description = "employees")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "ERROR")
    })
    @RequestMapping(value = "employee/all", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<EmployeeDTO>> retrieveAllEmployees()
    {
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOS,HttpStatus.OK);
    }

}
