package time.off.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import time.off.app.model.Employee;
import time.off.app.model.Project;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineDTO {

    private Project project;
    private Employee employee;
    private String label;
}
