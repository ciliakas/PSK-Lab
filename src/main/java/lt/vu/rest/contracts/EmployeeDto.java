package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDto {

    private String Name;

    private Integer ExternalId;

    private String ManagerName;
}
