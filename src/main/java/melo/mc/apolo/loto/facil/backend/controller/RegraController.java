package melo.mc.apolo.loto.facil.backend.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import melo.mc.apolo.loto.facil.backend.business.RegraBusiness;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RequestResponseStatusEnum;

@Path("/regra")
public class RegraController {
	private RegraBusiness regraBusiness = new RegraBusiness();
	
	// Serviços expostos
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<RegraDTO> listar() {
		try {
			return regraBusiness.getRegras();
		} catch (Exception e) {
			throw new WebApplicationException(
					RequestResponseStatusEnum.INTERNAL_ERROR.getStatus());
		}
	}
}