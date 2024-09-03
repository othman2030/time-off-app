package time.off.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import time.off.app.dto.EmployeeDTO;
import time.off.app.service.EmployeeService;
import time.off.app.service.ReadExcel;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final ReadExcel readExcel;

    public DataLoader(EmployeeService employeeService,ReadExcel readExcel) {
        this.employeeService = employeeService;
        this.readExcel = readExcel;
    }

    @Override
    public void run(String... args) throws Exception {

        List<EmployeeDTO> employeeDTOS = readExcel.readEmployees();
        employeeService.saveManyEmployees(employeeDTOS);
    }
}
