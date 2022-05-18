package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.EmployeeMapper;
import lt.vu.mybatis.model.Employee;
import lt.vu.services.ExternalIdGenerator;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class EmployeesMyBatis {
    @Inject
    EmployeeMapper employeeMapper;

    @Inject
    ExternalIdGenerator externalIdGenerator;

    @Getter @Setter
    private Employee employeeToCreate = new Employee();

    @Transactional
    public void createEmployee() {
        employeeToCreate.setExternalId(externalIdGenerator.generateExternalId());
        employeeMapper.insert(employeeToCreate);
    }
}
