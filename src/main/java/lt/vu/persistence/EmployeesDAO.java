package lt.vu.persistence;

import lt.vu.entities.Employee;
import lt.vu.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class EmployeesDAO {

    @Inject
    private EntityManager em;

    public List<Employee> loadAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Employee employee) {
        this.em.persist(employee);
    }

    public Employee findOne(Integer id) {
        return em.find(Employee.class, id);
    }

    public Employee update(Employee employee){
        return em.merge(employee);
    }
}
