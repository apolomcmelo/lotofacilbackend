package melo.mc.apolo.loto.facil.backend.controller;

import java.util.ArrayList;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.business.JogoBusiness;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogo")
public class JogoController {
	
	@Autowired
	private JogoBusiness jogoBusiness;

	// Serviços expostos
	@RequestMapping(method = RequestMethod.POST, value = "/gerar")
	public List<String> gerarJogos(@RequestBody List<RegraDTO> regras) {
		List<Jogo> jogos = jogoBusiness.getJogos(TipoJogoEnum.LOTO_FACIL, regras);
		
		List<String> jogosGerados = new ArrayList<String>();
		
		jogos.forEach(j -> jogosGerados.add(j.toString()));
		
		return jogosGerados;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listar")
	public List<String> listar() {
		List<Jogo> jogos = jogoBusiness.listarJogos();

		List<String> jogosSorteados = new ArrayList<String>();

		jogosSorteados.add("********* Total de jogos já sorteados - " + jogos.size() + " *********");
		
		jogos.forEach(j -> jogosSorteados.add(j.toString()));
		
		return jogosSorteados;	
	}

}