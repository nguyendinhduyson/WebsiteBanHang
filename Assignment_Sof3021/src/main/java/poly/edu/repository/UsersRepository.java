package poly.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findByUsernameAndPassword(String username, String password);

//	@Query("select ID from ORDERS where ID_USERS = ?1")
//	List<Users> getUsers(Integer id);
}
