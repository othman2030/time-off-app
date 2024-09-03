package time.off.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import time.off.app.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
