package time.off.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TO_EMPLOYEE")
@AllArgsConstructor
@Data
public class Employee extends  Person{

    @Column(name="START_DATE")
    private Date startDate;
    @OneToOne(mappedBy = "employee")
    private Line line ;
    @Column(name="MATRICULE")
    private String matricule;

    @ManyToOne
    @JoinColumn(name="POSITION_ID")
    private Position position;
}
