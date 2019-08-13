package vacationManager.vacationManager.dto;

import vacationManager.vacationManager.model.Employee;
import vacationManager.vacationManager.util.GeneralUtils;

public class EmployeeDTO {

	private String id;
	
	private String name;

	private String birthday;

	private String address;

	private String hiringDate;

	private String registration;

	private String teamName;

	public EmployeeDTO(Employee employee) {
		this.id = employee.getId().toString();
		this.name = employee.getName();
		this.birthday = GeneralUtils.formatDate(employee.getBirthday());
		this.address = getAddress(employee);
		this.hiringDate = GeneralUtils.formatDate(employee.getHiringDate());
		this.registration = employee.getRegistration().toString();
		this.teamName = employee.getTeam().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress(Employee employee) {
		StringBuilder sb = new StringBuilder();
		if (employee.getStreet() != null) {
			sb.append(employee.getStreet());
		}
		if (employee.getAddressNumber() != null) {
			sb.append(", ").append(employee.getAddressNumber());
		}
		if (employee.getNeighborhood() != null) {
			sb.append(", ").append(employee.getNeighborhood());
		}
		if (employee.getCity() != null) {
			sb.append(", ").append(employee.getCity());
		}
		if (employee.getState() != null) {
			sb.append("-").append(employee.getState());
		}
		if (employee.getAddressComplement() != null) {
			sb.append(" - ").append(employee.getAddressComplement());
		}

		return sb.toString();
	}

}
