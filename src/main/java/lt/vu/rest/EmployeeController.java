package lt.vu.rest;
import lombok.Getter;
import lombok.Setter;
import lombok.var;
import lt.vu.entities.Employee;
import lt.vu.persistence.EmployeesDAO;
import lt.vu.rest.contracts.EmployeeDto;
import lt.vu.rest.contracts.TeamDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/employees")

public class EmployeeController {

    @Inject
    @Setter @Getter
    private EmployeesDAO employeesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Employee employee = employeesDAO.findOne(id);

        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setExternalId(employee.getExternalId());

        return Response.ok(employeeDto).build();
    }

    @Path("/teams/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeamsById(@PathParam("id") final Integer id) {
        Employee employee = employeesDAO.findOne(id);

        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<TeamDto> teamsDto = new ArrayList<>();
        for (var team : employee.getTeams()) {
            TeamDto teamDto = new TeamDto();
            teamDto.setId(team.getId());
            teamDto.setName(team.getName());

            teamsDto.add(teamDto);
        }

        return Response.ok(teamsDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(EmployeeDto employeeDto)
    {
        try{
            Employee employee = new Employee();
            employee.setName(employeeDto.getName());
            employee.setExternalId(employeeDto.getExternalId());

            employeesDAO.persist(employee);
            employeeDto.setId(employee.getId());

            return Response.ok(employeeDto).build();
        }
        catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer employeeId,
                           EmployeeDto employeeDto)
    {
        try {
            Employee existingEmployee = employeesDAO.findOne(employeeId);
            if (existingEmployee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingEmployee.setName(employeeDto.getName());
            existingEmployee.setExternalId(employeeDto.getExternalId());

            employeesDAO.update(existingEmployee);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}