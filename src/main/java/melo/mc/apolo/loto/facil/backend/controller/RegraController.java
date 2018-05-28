package melo.mc.apolo.loto.facil.backend.controller;

import java.util.List;

import melo.mc.apolo.loto.facil.backend.business.RegraBusiness;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regra")
public class RegraController {
	
	@Autowired
	private RegraBusiness regraBusiness;
	
	// Serviços expostos
	@RequestMapping(method = RequestMethod.GET, value = "/listar")
	public List<RegraDTO> listar() {
		return regraBusiness.getRegras();
	}
}