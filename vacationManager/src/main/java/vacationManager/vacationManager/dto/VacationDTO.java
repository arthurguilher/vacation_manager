package vacationManager.vacationManager.dto;

import vacationManager.vacationManager.model.Vacation;
import vacationManager.vacationManager.util.GeneralUtils;

public class VacationDTO {

	private String id;
	
	private String employeeName;

	private String period;

	public VacationDTO(Vacation vacation) {
		this.id = vacation.getId().toString();
		this.employeeName = vacation.getEmployee().getName();
		this.period = GeneralUtils.formatDate(vacation.getStartDate()) + " à " + GeneralUtils.formatDate(vacation.getEndDate());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
