package vacationManager.vacationManager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vacationManager.vacationManager.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Employee e where e.id=:id")
	void deleteById(@Param("id") Long id);
	
	@Query("select e from Employee e where e.id=:id")
	Employee findById(@Param("id") Long id);
	
	@Query("select max(e.registration) from Employee e")
	Long findLastRegistration();
}
