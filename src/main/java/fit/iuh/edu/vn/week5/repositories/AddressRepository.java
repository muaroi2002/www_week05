package fit.iuh.edu.vn.week5.repositories;

import fit.iuh.edu.vn.week5.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
