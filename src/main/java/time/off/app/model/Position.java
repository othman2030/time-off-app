package time.off.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TO_REF_POSITION")
@AllArgsConstructor
@Data
public class Position  extends SuperEntity{

    @Column(name="LABEL")
    private String label;
    @Column(name="CODE")
    private String code;
    @OneToMany(mappedBy = "position")
    private List<Employee> employees;



}
