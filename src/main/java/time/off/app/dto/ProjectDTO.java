package time.off.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
public class ProjectDTO {

    private String label;
    private Date startDate;

    private Date endDate;
}
