package lt.vu.mybatis.model;

public class TeamEmployee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TEAM_EMPLOYEE.TEAMS_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    private Integer teamsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TEAM_EMPLOYEE.EMPLOYEES_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    private Integer employeesId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TEAM_EMPLOYEE.TEAMS_ID
     *
     * @return the value of PUBLIC.TEAM_EMPLOYEE.TEAMS_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    public Integer getTeamsId() {
        return teamsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TEAM_EMPLOYEE.TEAMS_ID
     *
     * @param teamsId the value for PUBLIC.TEAM_EMPLOYEE.TEAMS_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    public void setTeamsId(Integer teamsId) {
        this.teamsId = teamsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TEAM_EMPLOYEE.EMPLOYEES_ID
     *
     * @return the value of PUBLIC.TEAM_EMPLOYEE.EMPLOYEES_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    public Integer getEmployeesId() {
        return employeesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TEAM_EMPLOYEE.EMPLOYEES_ID
     *
     * @param employeesId the value for PUBLIC.TEAM_EMPLOYEE.EMPLOYEES_ID
     *
     * @mbg.generated Wed May 18 13:38:54 EEST 2022
     */
    public void setEmployeesId(Integer employeesId) {
        this.employeesId = employeesId;
    }
}