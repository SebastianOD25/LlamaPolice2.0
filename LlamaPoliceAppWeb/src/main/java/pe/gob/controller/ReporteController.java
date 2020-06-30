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
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.model.Policia;
import pe.gob.model.Denuncias;
import pe.gob.model.Reporte;
import pe.gob.service.IPoliciaService;
import pe.gob.service.IDenunciasService;
import pe.gob.service.IReporteService;


@Controller
@RequestMapping("/reporte")
public class ReporteController {
	@Autowired
	private IReporteService rService;
	
	@Autowired
	private IPoliciaService pService;
	
	@Autowired
	private IDenunciasService dService;
		
	@RequestMapping("/")
	public String irPaginaListadoReporte(Map<String, Object> model) {
		model.put("listaReporte", rService.listar());
		return "listReporte";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroReporte(Model model) {
		model.addAttribute("listaPolicia", pService.lista());
		model.addAttribute("listaDenuncias", dService.listar());		
		model.addAttribute("policia", new Policia());
		model.addAttribute("denuncias", new Denuncias());
		model.addAttribute("reporte", new Reporte());
		return "reporte";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Reporte objReporte, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaPolicia", pService.lista());
			model.addAttribute("listaDenuncias", dService.listar());					
			return "reporte";
		}
		else
		{
			boolean flag = rService.insertar(objReporte);
			if(flag) {
				return "redirect:/reporte/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/reporte/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				rService.eliminar(id);
				model.put("listaReporte", rService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaReporte", rService.listar());
		}
		return "listReporte";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReporte", rService.listar());
		return "listReporte";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Reporte reporte)
	throws ParseException{
		rService.listarId(reporte.getIdReporte());
		return "listReporte";
	}
	
}