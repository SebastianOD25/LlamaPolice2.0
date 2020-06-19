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

import pe.gob.model.Persona;
import pe.gob.service.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPersonas(Map<String, Object> model) {
		model.put("listaPersona", pService.listar());
		return "listPersona";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("persona", new Persona());
		return "persona";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Persona objPersona,
		BindingResult binRes, Model model) throws ParseException{
		if (binRes.hasErrors()) {
			return "persona";
		} else {
			boolean flag = pService.insertar(objPersona);
				if (flag) {
					return "redirect:/persona/listar";
				} else {
					model.addAttribute("mensaje", "Ocurrio un problema");
					return "redirect:/persona/irRegistrar";
				}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model,
			RedirectAttributes objRedir) throws ParseException{
		Optional<Persona> objPersona = pService.listarId(id);
		if (objPersona == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/persona/listar";
		} else {
			model.addAttribute("persona",objPersona);
			return "persona";
		}
	}
	
	@RequestMapping("/actualizar")
	private String actualizar(@ModelAttribute @Valid Persona objPersona, BindingResult binRes,
			Model model,RedirectAttributes objRedir) throws ParseException{
		if (binRes.hasErrors()) {
			return "redirect:/persona/listar";
		} else {
			boolean flag = pService.modificar(objPersona);
			if (flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizo");
				return "redirect:/persona/listar";
			} else {
				model.addAttribute("race", objPersona);
				return "redirect:/persona/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/eliminar")
	private String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id ) {
		try {
			if (id!= null && id>0) {
				pService.eliminar(id);
				model.put("listaPersona", pService.listar());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("listaPersona", "Ocurrio un error");
		}
		return "listPersona";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPersona", pService.listar());
		return "listPersona";
	}
	
}
