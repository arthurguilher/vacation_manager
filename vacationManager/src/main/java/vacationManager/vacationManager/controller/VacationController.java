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

import vacationManager.vacationManager.dto.VacationDTO;
import vacationManager.vacationManager.exception.SystemException;
import vacationManager.vacationManager.model.Vacation;
import vacationManager.vacationManager.repository.EmployeeRepository;
import vacationManager.vacationManager.repository.VacationRepository;

@Controller
@RequestMapping(path = "/vacation")
public class VacationController {

	@Autowired
	private VacationRepository vacationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/add")
	public @ResponseBody ResponseEntity<?> add(@RequestBody Vacation vacation, @RequestParam String employeeId)
			throws SystemException {
		vacation.setEmployee(employeeRepository.findById(Long.valueOf(employeeId)));
		vacation.validateInsert(((List<Vacation>) vacationRepository.findAll()));
		vacationRepository.save(vacation);
		return ResponseEntity.ok().body("Inserido com sucesso");
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<VacationDTO>> list() {
		List<VacationDTO> vacations = ((List<Vacation>) vacationRepository.findAll()).stream().map(vacation -> {
			return new VacationDTO(vacation);
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(vacations);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		vacationRepository.deleteById(id);
		return ResponseEntity.ok().body("Férias deletada com sucesso.");
	}
}
