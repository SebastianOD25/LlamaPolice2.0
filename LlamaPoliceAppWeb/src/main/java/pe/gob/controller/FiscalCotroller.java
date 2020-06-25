package pe.gob.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.service.IFiscalService;

@Controller
@RequestMapping("/fiscal")
public class FiscalCotroller {
	
	@Autowired
	private IFiscalService fService;
	
	@RequestMapping("/")
	public String irPaginaListadoFiscales(Map<String, Object> model) {
		model.put("listaFiscales", fService.listar());
		return "listFiscal";
	}
	
}
