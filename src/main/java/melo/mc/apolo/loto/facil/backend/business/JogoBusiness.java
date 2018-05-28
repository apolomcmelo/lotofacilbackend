package melo.mc.apolo.loto.facil.backend.business;

import java.util.ArrayList;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.converters.RegraConverter;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RegraEnum;
import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;
import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.model.Jogo;
import melo.mc.apolo.loto.facil.backend.util.HtmFileReader;
import melo.mc.apolo.loto.facil.backend.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoBusiness {
	
	@Autowired
	private RegraConverter regraConverter;
	
	@Autowired
	private HtmFileReader reader;
	
	private List<Regra> regraModelList;
	
	private int qtdTodasCombinacoes = 0;
	private int qtdCombinacoesFiltradas = 0;
	
	private final String file = "C:/Users/Apolo/Downloads/logofacil_resultados.HTM";

	public List<Jogo> getJogos(TipoJogoEnum tipoJogo, List<RegraDTO> regras) {
		List<Jogo> jogos = new ArrayList<Jogo>();
		regraModelList = regraConverter.converterDTOToModel(regras, false);

		gerarJogos(Util.getNumerosPossiveis(tipoJogo), tipoJogo.getQtdDezenasSorteadas(), 0, new int[tipoJogo.getQtdDezenasSorteadas()], jogos);
		
		System.out.println("Quantidade de todas as combinações: " + qtdTodasCombinacoes);
		System.out.println("Quantidade de jogos após filtro de regras: " + qtdCombinacoesFiltradas);
		System.out.println("As regras eliminaram " + (qtdTodasCombinacoes - qtdCombinacoesFiltradas) + " jogos");
		
		qtdCombinacoesFiltradas = 0;
		qtdTodasCombinacoes = 0;
		return jogos;
	}
	
	public List<Jogo> listarJogos() {
		regraModelList = RegraEnum.getTodasRegras();
		return getJogosValidados(reader.readFile(file));
	}
	
	private List<Jogo> getJogosValidados(List<Jogo> jogos) {
		List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
		
		for (Jogo jogo : jogos) {
			if(isJogoValidoPelasRegras(jogo.getDezenas()) == true) {
				jogosFiltrados.add(jogo);
			}
		}
		
		return jogosFiltrados;
	}
	
	private boolean isJogoValidoPelasRegras(int[] jogo) {
		boolean isValido = true;
		
		for(int i=0; i<regraModelList.size(); i++) {
			if(regraModelList.get(i).isValido(new Jogo(jogo)) == false){
				isValido = false;
				break;
			}
		}
		
		return isValido;
	}

	private void gerarJogos(int[] numPossiveis,
			int qtdPorCombinacao, int posicaoInicial, int[] resultado,
			List<Jogo> jogosPossiveis) {
		if (qtdPorCombinacao == 0) {
			
			if(isJogoValidoPelasRegras(resultado)){
				int[] jogo = new int[resultado.length];
				for(int i=0; i<resultado.length; i++) {
					jogo[i] = resultado[i];
				}
				qtdCombinacoesFiltradas++;
//				jogosPossiveis.add(new Jogo(jogo));
			}

			qtdTodasCombinacoes++;

			return;
		}
		
		for (int i = posicaoInicial; i <= numPossiveis.length - qtdPorCombinacao; i++) {
			resultado[resultado.length - qtdPorCombinacao] = numPossiveis[i];
			gerarJogos(numPossiveis, qtdPorCombinacao - 1, i + 1, resultado, jogosPossiveis);
		}
	}
}