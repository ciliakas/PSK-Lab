package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Team;
import org.mybatis.cdi.Mapper;

@Mapper
public interface TeamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int insert(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    Team selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    List<Team> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int updateByPrimaryKey(Team record);
}