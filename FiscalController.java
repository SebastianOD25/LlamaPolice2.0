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
import pe.edu.upc.spring.model.Fiscal;
import pe.edu.upc.spring.service.IDenuncianteService;
import pe.edu.upc.spring.service.IFiscalService;


@Controller
@RequestMapping("/fiscal")
public class FiscalController {

	@Autowired
	private IFiscalService fService;
	
	@Autowired
	private IDenuncianteService dService;

	
	@RequestMapping("/bienvenidoinicio")
	private String irPaginaBienvenida() {
		return "bienvenidoinicio";
	}
	@RequestMapping("/")
	public String irPaginaListadoFiscal(Map<String, Object> model) {
		model.put("listaFiscal", fService.listar());
		return "listFiscal";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroFiscal(Model model) {
		model.addAttribute("listaDenunciante", dService.listar());		
		model.addAttribute("fiscal", new Fiscal());
		model.addAttribute("denunciante", new Denunciante());
		return "fiscal";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Fiscal objFiscal, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaDenunciante", dService.listar());					
			return "fiscal";
		}
		else
		{
			boolean flag = fService.insertar(objFiscal);
			if(flag) {
				return "redirect:/denunciante/listar";
			}
			else {
				model.addAttribute("mensaje ", "Error");
				return "redirect:/fiscal/irRegistrar";
			}
		}
	}
		/*
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
			model.addAttribute("listaFiscal", fService.listar());
			model.addAttribute("listaDenunciante", dService.listar());
			
			if (objFiscal.isPresent())
				objFiscal.ifPresent(o -> model.addAttribute("fiscal", o));
			
			return "fiscal";
		}		
	}
	*/
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
