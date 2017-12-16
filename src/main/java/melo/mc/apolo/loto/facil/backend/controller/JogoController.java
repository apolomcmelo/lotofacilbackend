package melo.mc.apolo.loto.facil.backend.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import melo.mc.apolo.loto.facil.backend.business.JogoBusiness;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RequestResponseStatusEnum;
import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

import org.springframework.stereotype.Component;

@Component
@Path("/jogo")
public class JogoController {
	private JogoBusiness jogoBusiness = new JogoBusiness();
	
	// Serviços expostos
	@POST
	@Path("/gerar")
	@Consumes("application/json")
	public Response gerarJogos(List<RegraDTO> regras) {
		return getJogos(regras);
	}
	
	private Response getJogos(List<RegraDTO> regras) {
		try {
			List<Jogo> jogos = jogoBusiness.getJogos(TipoJogoEnum.LOTO_FACIL, regras);
			
			System.out.println("Quantidade de jogos:" + jogos.size());
			return Response
					.status(RequestResponseStatusEnum.SUCCESS_OK.getStatus())
					.entity("Jogos gerados com sucesso.").build();
		} catch (Exception e) {
			return Response
					.status(RequestResponseStatusEnum.INTERNAL_ERROR
							.getStatus())
					.entity("Erro ao gerar lista de jogos: " + e.getMessage()).build();
		}
	}
}