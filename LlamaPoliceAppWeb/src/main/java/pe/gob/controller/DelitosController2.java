package pe.gob.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.service.DelitosService;



@Controller
@RequestMapping("/delitos2")
public class DelitosController2 {
	
	@Autowired
	private DelitosService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDelitoss(Map<String, Object> model) {
		model.put("listaDelitos", cService.lista());
		return "policia/listDelitos2";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDelitos", cService.lista());
		return "policia/listDelitos2";
	}
	
}
