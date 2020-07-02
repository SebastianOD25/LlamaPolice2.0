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

import pe.gob.model.Comisaria;
import pe.gob.model.Delitos;
import pe.gob.model.Denuncias;
import pe.gob.model.Usuarios;
import pe.gob.service.ComisariaService;
import pe.gob.service.DelitosService;
import pe.gob.service.IDenunciasService;
import pe.gob.service.IUsuariosService;

@Controller
@RequestMapping("/denuncias")
public class DenunciaController {
	@Autowired
	private IDenunciasService pService;
	
	@Autowired
	private ComisariaService cService;
	
	@Autowired
	private DelitosService dService;
	
	@Autowired
	private IUsuariosService aService;
		
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "HomePersona";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDenuncias(Map<String, Object> model) {
		model.put("listaDenuncias", pService.listar());
		return "persona/listDenuncias";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaComisaria", cService.lista());
		model.addAttribute("listaUsuarios", aService.listar());
		model.addAttribute("listaDelitos", dService.lista());		
		model.addAttribute("comisarias", new Comisaria());
		model.addAttribute("usuarios", new Usuarios());
		model.addAttribute("denuncias", new Denuncias());
		model.addAttribute("delitos", new Delitos());
		return "persona/denuncia";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Denuncias objDenuncias, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaComisarias", cService.lista());
			model.addAttribute("listaDuenos", dService.lista());
			model.addAttribute("listaUsuarios", aService.listar());
			return "persona/denuncia";
		}
		else
		{
			boolean flag = pService.insertar(objDenuncias);
			if(flag) {
				return "redirect:/denuncias/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un problema");
				return "redirect:/denuncias/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				pService.eliminar(id);
				model.put("listaDenuncias", pService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaDenuncias", pService.listar());
		}
		return "persona/listDenuncias";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDenuncias", pService.listar());
		return "persona/listDenuncias";
	}
	
	
}
