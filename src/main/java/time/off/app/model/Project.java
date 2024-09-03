package time.off.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="TO_PROJECT")
@Data
@AllArgsConstructor
public class Project extends  SuperEntity{



    @Column(name="LABEL")
    private String label;
    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;

    @OneToMany(mappedBy = "project")
    private List<Line> lines;
}
