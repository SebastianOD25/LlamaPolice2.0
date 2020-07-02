package pe.gob;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvnConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		/*registry.addViewController("/grupos").setViewName("grupos");
		registry.addViewController("/categorias").setViewName("categorias");*/
	}
	
}
