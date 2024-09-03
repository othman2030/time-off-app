package time.off.app.service;

import org.springframework.stereotype.Service;
import time.off.app.dao.EmployeeRepository;
import time.off.app.dto.EmployeeDTO;
import time.off.app.mapper.EmployeeMapper;
import time.off.app.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper)
    {
       this.employeeRepository = employeeRepository;
       this.employeeMapper = employeeMapper;
    }

    public void saveEmployee(EmployeeDTO employeeDTO)
    {
      Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);

      employeeRepository.save(employee);
    }

    public EmployeeDTO findEmployeeByMatricule(String matricule)
    {

        Employee employee = employeeRepository.findIdByMatricule(matricule);

        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    public void saveManyEmployees(List<EmployeeDTO> employeeDTOS)
    {
        List<Employee> employees = new ArrayList<>();
        employeeDTOS.forEach(employeeDTO -> {
            Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
            employees.add(employee);
        });

        employeeRepository.saveAll(employees);
    }

   public List<EmployeeDTO> getAllEmployees()
    {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();

        employees.forEach(employee ->{
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
            employeeDTOS.add(employeeDTO);
        });
        return employeeDTOS;
    }

}
