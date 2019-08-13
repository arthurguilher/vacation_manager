package vacationManager.vacationManager.dto;

import vacationManager.vacationManager.model.Team;

public class TeamDTO {

	private String id;
	
	private String name;

	public TeamDTO(Team team) {
		this.id = team.getId().toString();
		this.name = team.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
