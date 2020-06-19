package pe.gob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.gob.auth.handler.LoginSuccessHandler;
import pe.gob.serviceimpl.JpaUserDetailsService;


@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
				.antMatchers("/comisaria/**").access("hasRole('Usuario')")
				.antMatchers("/delito/**").access("hasRole('Usuario')")
				.antMatchers("/persona/**").access("hasRole('Usuario')")
				.antMatchers("/policia/**").access("hasRole('Usuario')")
				.antMatchers("/denuncias/**").access("hasRole('Usuario')").and()
				.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/persona/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}
