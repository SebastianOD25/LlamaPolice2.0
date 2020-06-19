package pe.gob.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import pe.gob.service.ComisariaService;

@Controller
@RequestMapping("/comisaria")
public class ComisariaController {

	@Autowired
	private ComisariaService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoComisarias(Map<String, Object> model) {
		model.put("listaComisaria", cService.lista());
		return "listComisaria";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaComisaria", cService.lista());
		return "listRace";
	}

}

