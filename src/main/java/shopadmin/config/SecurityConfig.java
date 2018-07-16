package shopadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //获取组件springsecurityFilterchain
@EnableGlobalMethodSecurity(prePostEnabled=true)//开启方法级别的权限检验
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
}
