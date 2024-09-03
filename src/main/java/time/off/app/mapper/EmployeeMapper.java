package time.off.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import time.off.app.dto.EmployeeDTO;
import time.off.app.model.Employee;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "employee.firstName", target = "firstName")
    @Mapping(source = "employee.lastName", target = "lastName")
    @Mapping(source = "employee.matricule", target = "matricule")
    @Mapping(source = "employee.birthDate", target = "birthDate",dateFormat = "dd-MM-yyyy")
    @Mapping(source = "employee.startDate", target = "startDate",dateFormat = "dd-MM-yyyy")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(source = "employeeDTO.firstName", target = "firstName")
    @Mapping(source = "employeeDTO.lastName", target = "lastName")
    @Mapping(source = "employeeDTO.matricule", target = "matricule")
    @Mapping(source = "employeeDTO.birthDate", target = "birthDate",dateFormat = "dd-MM-yyyy")
    @Mapping(source = "employeeDTO.startDate", target = "startDate",dateFormat = "dd-MM-yyyy")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
