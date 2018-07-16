package shopadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //��ȡ���springsecurityFilterchain
@EnableGlobalMethodSecurity(prePostEnabled=true)//�������������Ȩ�޼���
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
}
