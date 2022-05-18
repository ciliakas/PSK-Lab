package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Player;
import org.mybatis.cdi.Mapper;

@Mapper
public interface PlayerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int insert(Player record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    Player selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    List<Player> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue May 17 19:34:23 EEST 2022
     */
    int updateByPrimaryKey(Player record);
}