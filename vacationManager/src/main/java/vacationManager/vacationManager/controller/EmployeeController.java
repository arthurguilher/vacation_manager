package vacationManager.vacationManager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vacationManager.vacationManager.dto.EmployeeDTO;
import vacationManager.vacationManager.model.Employee;
import vacationManager.vacationManager.repository.EmployeeRepository;
import vacationManager.vacationManager.repository.TeamRepository;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamRepository teamRepository;

	@PostMapping(path = "/add")
	public @ResponseBody ResponseEntity<?> add(@RequestBody Employee employee, @RequestParam String teamId) {
		employee.setTeam(teamRepository.findById(Long.valueOf(teamId)));
		employee.setRegistration(incrementRegisration());
		employeeRepository.save(employee);
		return ResponseEntity.ok().body("Inserido com sucesso");
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<EmployeeDTO>> list() {
		List<EmployeeDTO> employees = ((List<Employee>) employeeRepository.findAll()).stream().map(employee -> {
			return new EmployeeDTO(employee);
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(employees);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().body("Funcionário deletado com sucesso.");
	}
	
	private Long incrementRegisration() {
		Long lastRegistration = employeeRepository.findLastRegistration();
		return lastRegistration == null ? 1 : lastRegistration+1;
	}
}
