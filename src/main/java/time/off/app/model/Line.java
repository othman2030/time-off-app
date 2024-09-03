package time.off.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)

@Table(name="TO_LINE")
@Entity
@Data
public class Line extends  SuperEntity{

    @ManyToOne
    @JoinColumn( name="ID_PROJECT" )
    private Project project;
    @OneToOne
    @JoinColumn(name="ID_EMPLOYEE")
    private Employee employee;
    @Column(name="LABEL")
    private String label;
}
