package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Oders;

public interface OrderRepository extends JpaRepository<Oders, Integer>{

	@Query(value = "select g from Oders g where g.users.id = ?1")
	Oders getOrder(Integer id);
	
}
