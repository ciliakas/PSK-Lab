package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select a from Employee as a")
})
@Table(name = "Employee")
@Getter @Setter
public class Employee  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EXTERNAL_ID")
    private Integer externalId;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "employees", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Team> teams = new ArrayList<>();

    @ManyToOne
    private Employee manager;

    @OneToMany(mappedBy="manager")
    private List<Employee> subordinates = new ArrayList<>();

    @OneToMany(mappedBy="teamLead")
    private List<Team> leadTeams = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Integer version;

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee player = (Employee) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name);
    }
}
