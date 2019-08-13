package vacationManager.vacationManager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vacationManager.vacationManager.model.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>{

	@Modifying
	@Transactional
	@Query("delete from Team t where t.id=:id")
	void deleteById(@Param("id") Long id);
	
	@Query("select t from Team t where t.id=:id")
	Team findById(@Param("id") Long id);
}
