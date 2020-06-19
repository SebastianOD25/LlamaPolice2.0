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
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("comisaria", new Comisaria());
		return "comisaria";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Comisaria objComisaria,
		BindingResult binRes, Model model) throws ParseException{
		if (binRes.hasErrors()) {
			return "comisaria";
		} else {
			boolean flag = cService.insertar(objComisaria);
				if (flag) {
					return "redirect:/comisaria/listar";
				} else {
					model.addAttribute("mensaje", "Ocurrio un problema");
					return "redirect:/comisaria/irRegistrar";
				}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model,
			RedirectAttributes objRedir) throws ParseException{
		Optional<Comisaria> objComisaria = cService.listarId(id);
		if (objComisaria == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/comisaria/listar";
		} else {
			model.addAttribute("comisaria",objComisaria);
			return "comisaria";
		}
	}
	
	@RequestMapping("/actualizar")
	private String actualizar(@ModelAttribute @Valid Comisaria objComisaria, BindingResult binRes,
			Model model,RedirectAttributes objRedir) throws ParseException{
		if (binRes.hasErrors()) {
			return "redirect:/comisaria/listar";
		} else {
			boolean flag = cService.modificar(objComisaria);
			if (flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizo");
				return "redirect:/comisaria/listar";
			} else {
				model.addAttribute("race", objComisaria);
				return "redirect:/comisaria/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/eliminar")
	private String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id ) {
		try {
			if (id!= null && id>0) {
				cService.eliminar(id);
				model.put("listaComisaria", cService.lista());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("listaComisaria", "Ocurrio un error");
		}
		return "listComisaria";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaComisaria", cService.lista());
		return "listRace";
	}

}

