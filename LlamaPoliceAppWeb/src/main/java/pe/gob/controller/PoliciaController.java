package pe.gob.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.gob.model.Comisaria;
import pe.gob.model.Policia;
import pe.gob.service.ComisariaService;
import pe.gob.service.IPoliciaService;

@Controller
@RequestMapping("/policia")
public class PoliciaController {
	
	@Autowired
	private IPoliciaService pService;
	
	@Autowired
	private ComisariaService cService;
	
	@RequestMapping("/")
	public String irPaginaListadoPolicias(Map<String, Object> model) {
		model.put("listaPolicias", pService.listar());
		return "listPolicia";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroMascotas(Model model) {
		model.addAttribute("listaComisaria", cService.lista());	
		model.addAttribute("listaPolicias", pService.listar());		
		model.addAttribute("policia", new Policia());
		model.addAttribute("comisaria", new Comisaria());
		return "policia";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Policia objPolicia, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaComisaria", cService.lista());					
			return "policia";
		}
		else
		{
			boolean flag = pService.insertar(objPolicia);
			if(flag) {
				return "redirect:/policia/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/policia/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<Policia> objPolicia = pService.buscarId(id);
		
		if(objPolicia == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/policia/listar";
		}
		else 
		{
			model.addAttribute("listaComisaria", cService.lista());
			
			if (objPolicia.isPresent())
				objPolicia.ifPresent(o -> model.addAttribute("policia", o));
			
			return "policia";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				pService.eliminar(id);
				model.put("listaPolicias", pService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaPolicias", pService.listar());
		}
		return "listPolicia";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPolicias", pService.listar());
		return "listPolicia";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Policia policia)
	throws ParseException{
		pService.listarId(policia.getIdPolicia());
		return "listPolicia";
	}
	
}
