package pe.edu.upc.spring.controller;

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

import pe.edu.upc.spring.model.Denunciante;
import pe.edu.upc.spring.service.IDenuncianteService;

@Controller
@RequestMapping("/denunciante")
public class DenuncianteController {

	@Autowired
	private IDenuncianteService dService;
	
	@RequestMapping("/bienvenidoinicio")
	private String irPaginaBienvenida() {
		return "bienvenidoinicio";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDenunciante(Map<String,Object> model) {
		model.put("listaDenunciante",dService.listar());
		return "listDenunciante";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("denunciante", new Denunciante());
		return "denunciante";
	}
	
    @RequestMapping ("/registrar")
    public String registrar(@ModelAttribute @Valid Denunciante objDenunciante, BindingResult binRes, Model model) throws ParseException{
    	if(binRes.hasErrors())
          return "denunciante";
          else {
        	  boolean flag =dService.insertar(objDenunciante);
        	  if(flag) {
        		return"redirect:/denunciante/irRegistrar";  
        	  }
        	  else {
        		  model.addAttribute("mensaje", "Error");
        		  return "redirect:/denunciante/irRegistrar";
        	  }
        	  
          }
    }
    
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaDenunciante",dService.listar());
		return "listDenunciante";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDenunciante", dService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDenunciante", dService.listar());
		}
		return "listDenunciante";
	}
	
	
	
    
}
