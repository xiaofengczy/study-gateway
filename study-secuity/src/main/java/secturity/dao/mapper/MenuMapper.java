package secturity.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import secturity.dao.entity.Menu;

/**
 * @author zycao
 * @create 2019-09-10
 */
@Mapper
public interface MenuMapper {

  List<Menu> getAllMenus();

}
