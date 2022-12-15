package pack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pack.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
	User findOneByEmailAndPassword(String email, String password);

}
