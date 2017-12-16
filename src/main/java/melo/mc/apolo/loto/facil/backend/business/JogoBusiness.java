package melo.mc.apolo.loto.facil.backend.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.converters.RegraConverter;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;
import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

import org.springframework.beans.factory.annotation.Autowired;

public class JogoBusiness {
	@Autowired
	private RegraConverter regraConverter;
	

	public List<Jogo> getJogos(TipoJogoEnum tipoJogo, List<RegraDTO> regras) {
		List<Jogo> jogos = new ArrayList<Jogo>();

		gerarTodasCombinacoes(getNumerosPossiveis(tipoJogo), tipoJogo.getQtdDezenasSorteadas(), 0, new int[tipoJogo.getQtdDezenasSorteadas()], jogos);
		
		jogos = getJogosValidadosPorRegras(jogos, regraConverter.converterDTOToModel(regras, true));
		
		return jogos;
	}

	private List<Jogo> getJogosValidadosPorRegras(List<Jogo> jogos, List<Regra> regras) {
		List<Jogo> jogosFiltrados = new ArrayList<Jogo>();

		for(int i=0; i<jogos.size(); i++) {
			for(int j=0; j<regras.size(); j++) {
				if(regras.get(j).isValido(jogos.get(i))){
					jogosFiltrados.add(jogos.get(i));
				} else {
					break;
				}
			}
		}
		
		return jogosFiltrados;
	}

	private void gerarTodasCombinacoes(int[] numPossiveis,
			int qtdPorCombinacao, int posicaoInicial, int[] resultado,
			List<Jogo> jogosPossiveis) {
		if (qtdPorCombinacao == 0) {
			int[] jogo = Arrays.copyOf(resultado, resultado.length);
			
			jogosPossiveis.add(new Jogo(jogo));
			return;
		}
		
		for (int i = posicaoInicial; i <= numPossiveis.length
				- qtdPorCombinacao; i++) {
			resultado[resultado.length - qtdPorCombinacao] = numPossiveis[i];
			gerarTodasCombinacoes(numPossiveis, qtdPorCombinacao - 1, i + 1,
					resultado, jogosPossiveis);
		}
	}

	private int[] getNumerosPossiveis(TipoJogoEnum tipoJogo) {
		int[] numerosPossiveis = new int[tipoJogo.getQtdDezenas()];
		for (int i = 1; i <= tipoJogo.getQtdDezenas(); i++) {
			numerosPossiveis[i - 1] = i;
		}

		return numerosPossiveis;
	}
}