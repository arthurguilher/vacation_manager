package vacationManager.vacationManager.repository;

import org.springframework.data.repository.CrudRepository;

import vacationManager.vacationManager.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
