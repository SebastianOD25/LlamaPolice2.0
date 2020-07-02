package pe.gob.controller;

import java.security.Principal;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.gob.model.Roles;
import pe.gob.model.Usuarios;
import pe.gob.service.IRolesService;
import pe.gob.service.IUsuariosService;

@Controller
public class LoginController {
	

	@Autowired
	private IUsuariosService uService;
	
	@Autowired
	private IRolesService rService;

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaRoles", rService.listar());
		model.addAttribute("usuario", new Usuarios());
		model.addAttribute("roles", new Roles());
		return "registrar";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Usuarios objUser, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaUsuarios", uService.listar());
			model.addAttribute("listaRoles", rService.listar());
			return "registrar";
		} else {
			boolean flag = uService.insertar(objUser);
			if (flag) {
				return "redirect:/login";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/irRegistrar";
			}
		}
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {
		
		if (principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			return "redirect:/comisaria/listar";
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta");
			return "login";
		}

		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito");
			return "login";
		}
		
		return "login";

	}
}
