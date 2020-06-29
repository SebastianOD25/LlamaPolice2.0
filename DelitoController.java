package pe.edu.upc.spring.controller;

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

import pe.edu.upc.spring.model.Delito;
import pe.edu.upc.spring.service.IDelitoService;

@Controller
@RequestMapping("/delito")
public class DelitoController {
	
	@Autowired
	private IDelitoService dService;
	
	
	@RequestMapping("/")
	public String irPaginaListadoDelito(Map<String,Object> model) {
		model.put("listaDelito",dService.listar());
		return "listDelito";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("delito", new Delito());
		return "delito";
	}
	
    @RequestMapping ("/registrar")
    public String registrar(@ModelAttribute @Valid Delito objDelito, BindingResult binRes, Model model) throws ParseException{
    	if(binRes.hasErrors())
          return "delito";
          else {
        	  boolean flag =dService.insertar(objDelito);
        	  if(flag) {
        		return"redirect:/delito/listar";  
        	  }
        	  else {
        		  model.addAttribute("mensaje", "Error");
        		  return "redirect:/delito/irRegistrar";
        	  }
        	  
          }
    }
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Delito> objDelito = dService.listarId(id);
		if (objDelito == null ) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/delito/listar";
		}
		else {
			model.addAttribute("delito", objDelito);
			return "delito";
		}
	}
	
    
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaDelito",dService.listar());
		return "listDelito";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDelito", dService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDelito", dService.listar());
		}
		return "listDelito";
	}
}
