package pe.gob.controller;

import java.text.ParseException;
import java.util.Map;

import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.gob.model.Informe;
import pe.gob.model.Reporte;
import pe.gob.model.Usuarios;
import pe.gob.service.IInformeService;
import pe.gob.service.IReporteService;
import pe.gob.service.IUsuariosService;

@Controller
@Table(name = "/informe")
public class InformeController {
	
	@Autowired
	private IReporteService rService;
	
	@Autowired
	private IUsuariosService aService;
	
	@Autowired
	private IInformeService iService;
	
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "HomeFiscal";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoInformes(Map<String, Object> model) {
		model.put("listaInformes", iService.listar());
		return "fiscal/listInformes";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaUsuarios", aService.listar());
		model.addAttribute("listaReportes", rService.listar());		
		model.addAttribute("reportes", new Reporte());
		model.addAttribute("usuarios", new Usuarios());
		model.addAttribute("informes", new Informe());
		return "fiscal/informe";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Informe objInfo, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaUsuarios", aService.listar());
			model.addAttribute("listaReportes", rService.listar());
			return "fiscal/informe";
		}
		else
		{
			boolean flag = iService.insertar(objInfo);
			if(flag) {
				return "redirect:/informe/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un problema");
				return "redirect:/informe/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaInformes", iService.listar());
		return "fiscal/listInforme";
	}
	
}
