package pe.gob.controller;

import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.model.Denuncias;
import pe.gob.model.Reporte;
import pe.gob.model.Usuarios;
import pe.gob.service.IDenunciasService;
import pe.gob.service.IReporteService;
import pe.gob.service.IUsuariosService;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	private IReporteService rService;
	
	@Autowired
	private IDenunciasService dService;
	
	@Autowired
	private IUsuariosService uService;
	
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "HomePolicia";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoReporte(Map<String, Object> model) {
		model.put("listaReportes", rService.listar());
		return "policia/listReporte";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaDenuncias", dService.listar());
		model.addAttribute("listaUsuarios", uService.listar());		
		model.addAttribute("usuarios", new Usuarios());
		model.addAttribute("denuncias", new Denuncias());
		model.addAttribute("Reportes", new Reporte());
		return "policia/reporte";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Reporte objReporte, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaDenuncias", dService.listar());
			model.addAttribute("listaUsuarios", uService.listar());
			return "policia/reporte";
		}
		else
		{
			boolean flag = rService.insertar(objReporte);
			if(flag) {
				return "redirect:/reporte/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un problema");
				return "redirect:/reporte/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReporte", rService.listar());
		return "policia/listReporte";
	}
}
