package time.off.app.service;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import time.off.app.dto.EmployeeDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadExcel {

    public List<EmployeeDTO> readEmployees()
    {

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        Workbook workbook = null;

        try {
            workbook = WorkbookFactory.create(ResourceUtils.getFile("classpath:DATA_EMPLOYEES.xlsx"));
            workbook.forEach(sheet ->
            {
                int index = 0;
                for (Row row : sheet) {
                    if (index++ == 0) continue;
                    EmployeeDTO employeeDTO = new EmployeeDTO();

                    if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.STRING) {

                        employeeDTO.setMatricule(row.getCell(0).getStringCellValue());
                    }
                    if (row.getCell(1) != null && row.getCell(1).getCellType() == CellType.STRING) {

                        employeeDTO.setFirstName(row.getCell(1).getStringCellValue());
                    }
                    if (row.getCell(2) != null && row.getCell(2).getCellType() == CellType.STRING) {

                        employeeDTO.setLastName(row.getCell(2).getStringCellValue());
                    }

                    if (row.getCell(3) != null && row.getCell(3).getCellType() == CellType.STRING) {

                        employeeDTO.setBirthDate(row.getCell(3).getStringCellValue());
                    }
                    if (row.getCell(4) != null && row.getCell(4).getCellType() == CellType.STRING) {

                        employeeDTO.setStartDate(row.getCell(4).getStringCellValue());
                    }
                    employeeDTOS.add(employeeDTO);
                }
            });
        }catch (IOException e) {

        }
       finally {
            try {
                if (workbook != null) workbook.close();
            } catch (IOException e) {
            }
        }

            return employeeDTOS;
    }
}
