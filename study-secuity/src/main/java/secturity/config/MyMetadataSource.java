package secturity.config;

import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import secturity.dao.entity.Menu;
import secturity.dao.entity.Role;
import secturity.dao.mapper.MenuMapper;

/**
 * FileName: MyMetadataSource Description:
 *
 * @author xiaofengczy
 * @create 19-9-10
 */
@Component
public class MyMetadataSource implements FilterInvocationSecurityMetadataSource {

  AntPathMatcher antPathMatcher = new AntPathMatcher();

  @Resource
  MenuMapper menuMapper;

  @Override
  public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
    String requestUrl = ((FilterInvocation) obj).getRequestUrl();
    List<Menu> allMenus = menuMapper.getAllMenus();
    for (Menu menu : allMenus) {
      if(antPathMatcher.match(menu.getPattern(),requestUrl)){
        List<Role> roles = menu.getRoles();
        String[] roleArr = new String[roles.size()];
        for (int i = 0; i < roleArr.length; i++) {
          roleArr[i] = roles.get(i).getName();
        }
        return SecurityConfig.createList(roleArr);
      }
    }
    return SecurityConfig.createList("ROLE_LOGIN");
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return FilterInvocation.class.isAssignableFrom(clazz);
  }
}
