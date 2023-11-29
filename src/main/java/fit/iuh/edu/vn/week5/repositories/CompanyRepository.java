package fit.iuh.edu.vn.week5.repositories;

import fit.iuh.edu.vn.week5.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
