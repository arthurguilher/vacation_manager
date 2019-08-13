package vacationManager.vacationManager.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import vacationManager.vacationManager.exception.SystemException;
import vacationManager.vacationManager.util.GeneralUtils;

@Entity
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void validateInsert(List<Vacation> vacations) throws SystemException {
		if (GeneralUtils.daysBetweenDates(getEmployee().getHiringDate(), new Date()) < 365) {
			throw new SystemException("Não é possível solicitar férias antes de 1 ano de contratação.");
		}

		if (getEmployee().getTeam().getEmployees().size() <= 4) {
			if (vacations.stream().anyMatch(vacation -> vacation.getStartDate().after(this.getStartDate())
					&& vacation.getEndDate().before(this.getEndDate()))) {
				throw new SystemException("Não é permitido duas pessoas tirarem férias em períodos que tenha ao menos um dia coincidente.");
			}
		}
	}

}
