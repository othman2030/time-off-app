package time.off.app.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import time.off.app.dto.EmployeeDTO;
import time.off.app.model.Employee;
import time.off.app.model.Line;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T15:38:23+0200",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstName( employee.getFirstName() );
        employeeDTO.setLastName( employee.getLastName() );
        employeeDTO.setMatricule( employee.getMatricule() );
        if ( employee.getBirthDate() != null ) {
            employeeDTO.setBirthDate( new SimpleDateFormat( "dd-MM-yyyy" ).format( employee.getBirthDate() ) );
        }
        if ( employee.getStartDate() != null ) {
            employeeDTO.setStartDate( new SimpleDateFormat( "dd-MM-yyyy" ).format( employee.getStartDate() ) );
        }

        return employeeDTO;
    }

    @Override
    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        String matricule = null;
        Date startDate = null;

        matricule = employeeDTO.getMatricule();
        try {
            if ( employeeDTO.getStartDate() != null ) {
                startDate = new SimpleDateFormat( "dd-MM-yyyy" ).parse( employeeDTO.getStartDate() );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        Line line = null;

        Employee employee = new Employee( startDate, line, matricule );

        employee.setFirstName( employeeDTO.getFirstName() );
        employee.setLastName( employeeDTO.getLastName() );
        try {
            if ( employeeDTO.getBirthDate() != null ) {
                employee.setBirthDate( new SimpleDateFormat( "dd-MM-yyyy" ).parse( employeeDTO.getBirthDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return employee;
    }
}
