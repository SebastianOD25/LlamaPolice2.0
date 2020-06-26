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

import pe.gob.model.Fiscal;
import pe.gob.service.IFiscalService;

@Controller
@RequestMapping("/fiscal")
public class FiscalController {
	
	@Autowired
	private IFiscalService fService;
	
	
	@RequestMapping("/")
	public String irPaginaListadoFiscal(Map<String, Object> model) {
		model.put("listaFiscal", fService.listar());
		return "listFiscal";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroFiscal(Model model) {
		model.addAttribute("listaFiscal", fService.listar());		
		model.addAttribute("fiscal", new Fiscal());
		return "fiscal";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Fiscal objFiscal, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{					
			return "fiscal";
		}
		else
		{
			boolean flag = fService.insertar(objFiscal);
			if(flag) {
				return "redirect:/fiscal/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/fiscal/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<Fiscal> objFiscal = fService.buscarId(id);
		
		if(objFiscal == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/fiscal/listar";
		}
		else 
		{
			model.addAttribute("fiscal",objFiscal);
			
			return "fiscal";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				fService.eliminar(id);
				model.put("listaFiscal", fService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaFiscal", fService.listar());
		}
		return "listFiscal";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaFiscal", fService.listar());
		return "listFiscal";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Fiscal fiscal)
	throws ParseException{
		fService.listarId(fiscal.getIdFiscal());
		return "listFiscal";
	}
	
}