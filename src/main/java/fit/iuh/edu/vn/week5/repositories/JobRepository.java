package fit.iuh.edu.vn.week5.repositories;

import fit.iuh.edu.vn.week5.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
