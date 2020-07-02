package pe.gob.controller;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.model.Comisaria;
import pe.gob.service.ComisariaService;

@Controller
@RequestMapping("/comisaria3")
public class ComisariaController3 {

	@Autowired
	private ComisariaService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaComisaria", cService.lista());
		return "fiscal/listComisaria3";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Comisaria comisaria) throws ParseException {
		List<Comisaria> listaComisarias;
		comisaria.setNomComisaria(comisaria.getNomComisaria());
		listaComisarias = cService.buscarNombre(comisaria.getNomComisaria());
		if (listaComisarias.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaComisarias", listaComisarias);
		return "fiscal/listComisaria3";
	}
	

}

