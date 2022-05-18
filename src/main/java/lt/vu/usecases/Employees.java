package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Employee;
import lt.vu.persistence.EmployeesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Employees {

    @Inject
    private EmployeesDAO employeesDAO;

    @Getter
    @Setter
    private Employee employeeToCreate = new Employee();

    @Getter
    private List<Employee> allEmployees;

    @PostConstruct
    public void init() {
        loadAllEmployees();
    }

    @Transactional
    public void createEmployee() {
        this.employeesDAO.persist(employeeToCreate);
    }

    private void loadAllEmployees() {
        this.allEmployees = employeesDAO.loadAll();
    }
}
