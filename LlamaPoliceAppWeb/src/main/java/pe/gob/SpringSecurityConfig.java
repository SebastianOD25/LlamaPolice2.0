package pe.gob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import pe.gob.serviceimpl.JpaUsuarioDetailsService;


@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private JpaUsuarioDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Autowired
    public SpringSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
				.antMatchers("/registros/**").permitAll()
				.antMatchers("/", "/css/**", "/js/**", "/imagenes/**", "/irRegistrar", "/registrar","/login").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").successHandler(authenticationSuccessHandler).permitAll().and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/error");

			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
