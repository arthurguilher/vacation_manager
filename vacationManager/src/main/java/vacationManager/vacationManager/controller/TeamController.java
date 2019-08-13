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
import org.springframework.web.bind.annotation.ResponseBody;

import vacationManager.vacationManager.dto.TeamDTO;
import vacationManager.vacationManager.model.Team;
import vacationManager.vacationManager.repository.TeamRepository;

@Controller
@RequestMapping(path = "/team")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@PostMapping(path = "/add")
	public @ResponseBody ResponseEntity<?> add(@RequestBody  Team team) {
		teamRepository.save(team);
		return ResponseEntity.ok().body("Inserido com sucesso");
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<TeamDTO>> list() {
		List<TeamDTO> teams = ((List<Team>) teamRepository.findAll()).stream().map(team -> {
			return new TeamDTO(team);
		}).collect(Collectors.toList());
		return ResponseEntity.ok().body(teams);
	}
	
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		   teamRepository.deleteById(id);
	      return ResponseEntity.ok().body("Equipe deletada com sucesso.");
	   }
}
