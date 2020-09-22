package ${basepackage}.mapper;

import ${basepackage}.dao.UserDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper {

    int insert(UserDAO user);

    int updateById(UserDAO user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    UserDAO selectById(@Param("id") Integer id);

    UserDAO selectByUsername(@Param("username") String username);

    List<UserDAO> selectByIds(@Param("ids") Collection<Integer> ids);

}
