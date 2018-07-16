package shopadmin.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@MapperScan("shop.mapper")
@ComponentScan("shop")
@PropertySource("classpath:jdbc.properties")
@EnableWebMvc//开启web MVC 基础设如(jsr-303校验)
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/",".jsp");//配置jsp路径:前缀和后缀
	}
	
	@Bean
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource ds = 
				new DriverManagerDataSource(
						env.getProperty("jdbc.url"), 
						env.getProperty("jdbc.user"), 
						env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	/**
	 * @param ds 数据源
	 * @return 会话工厂组件
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setConfigLocation(new ClassPathResource("Mybatis-Config.xml"));
		ssfb.setDataSource(ds);
		return ssfb;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public PlatformTransactionManager paltformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
