package secturity.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import secturity.dao.entity.Role;
import secturity.dao.entity.User;

/**
 * FileName: UserMapper Description:
 *
 * @author xiaofengczy
 * @create 19-9-10
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper{

  User loadUserByUsername(@Param("username") String username);

  List<Role> getUserRolesByUid(@Param("id") Integer id);

  int saveUser(User user);

  User getUserById(Integer userId);
}
