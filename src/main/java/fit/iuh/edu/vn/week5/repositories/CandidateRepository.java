package fit.iuh.edu.vn.week5.repositories;

import fit.iuh.edu.vn.week5.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
