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
import pe.gob.service.ComisariaService;
import pe.gob.service.DelitosService;
import pe.gob.service.IDenunciasService;

@Controller
@RequestMapping("/denuncias")
public class DenunciaController {
	@Autowired
	private IDenunciasService pService;
	
	@Autowired
	private ComisariaService cService;
	
	@Autowired
	private DelitosService dService;
		
	@RequestMapping("/")
	public String irPaginaListadoDenuncias(Map<String, Object> model) {
		model.put("listaDenuncias", pService.listar());
		return "listDenuncias";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroMascotas(Model model) {
		model.addAttribute("listaComisaria", cService.lista());
		model.addAttribute("listaDelitos", dService.lista());		
		model.addAttribute("comisaria", new Comisaria());
		model.addAttribute("denuncias", new Denuncias());
		model.addAttribute("delitos", new Delitos());
		return "denuncia";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Denuncias objDenuncias, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaComisarias", cService.lista());
			model.addAttribute("listaDuenos", dService.lista());					
			return "denuncia";
		}
		else
		{
			boolean flag = pService.insertar(objDenuncias);
			if(flag) {
				return "redirect:/denuncias/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
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
		return "listDenuncias";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDenuncias", pService.listar());
		return "listDenuncias";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Denuncias denuncias)
	throws ParseException{
		pService.listarId(denuncias.getIdDenuncias());
		return "listDenuncias";
	}
	
}
