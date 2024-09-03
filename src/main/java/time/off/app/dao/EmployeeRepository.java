package time.off.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import time.off.app.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT m FROM Employee m where m.matricule = :matricule")
    Employee findIdByMatricule(@Param("matricule") String matricule);
}
