package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Employee;
import lt.vu.entities.Player;
import lt.vu.entities.Team;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.EmployeesDAO;
import lt.vu.persistence.PlayersDAO;
import lt.vu.persistence.TeamsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateEmployeeDetails implements Serializable {

    private Employee employee;

    @Inject
    private EmployeesDAO employeesDAO;

    @Inject
    private TeamsDAO teamsDao;

    @Getter
    @Setter
    private int managerId;

    @Getter
    @Setter
    private int[] teamsId;

    @PostConstruct
    private void init() {
        System.out.println("UpdateEmployeeDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer employeeId = Integer.parseInt(requestParameters.get("employeeId"));
        this.employee = employeesDAO.findOne(employeeId);
    }

    @Transactional
    @LoggedInvocation
    public String updateExternalId() {
        try{
            employeesDAO.update(this.employee);
        } catch (Exception e) {
            return "/employeeDetails.xhtml?faces-redirect=true&employeeId=" + this.employee.getId() + "&error=optimistic-lock-exception";
        }
        return "employeeDetails.xhtml?employeeId=" + this.employee.getId() + "&faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String setManagerById() {
        try{
            Employee manager = employeesDAO.findOne(managerId);
            employee.setManager(manager);
            employeesDAO.update(employee);
        } catch (Exception e) {
            return "/employeeDetails.xhtml?faces-redirect=true&employeeId=" + this.employee.getId() + "&error=optimistic-lock-exception";
        }
        return "employeeDetails.xhtml?employeeId=" + this.employee.getId() + "&faces-redirect=true";
    }

    @Transactional
    @LoggedInvocation
    public String setTeamById() {
        try{
            for (int id : teamsId) {
                Team team = teamsDao.findOne(id);
                team.getEmployees().add(employee);
                teamsDao.update(team);
            }
        } catch (Exception e) {
            return "/employeeDetails.xhtml?faces-redirect=true&employeeId=" + this.employee.getId() + "&error=optimistic-lock-exception";
        }
        return "employeeDetails.xhtml?employeeId=" + this.employee.getId() + "&faces-redirect=true";

    }
}
