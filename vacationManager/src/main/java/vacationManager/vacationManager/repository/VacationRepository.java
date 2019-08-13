package vacationManager.vacationManager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vacationManager.vacationManager.model.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Integer>{
	@Modifying
	@Transactional
	@Query("delete from Vacation v where v.id=:id")
	void deleteById(@Param("id") Long id);
	
	@Query("select v from Vacation v inner join v.employee e where e.registration=:registration")
	Vacation findByEmployeeRegistration(@Param("registration") Long registration);
}
