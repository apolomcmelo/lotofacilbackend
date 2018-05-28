package melo.mc.apolo.loto.facil.backend.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;
import melo.mc.apolo.loto.facil.backend.interfaces.FileReader;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class HtmFileReader implements FileReader {

	// Constantes de posicionamento da tabela do arquivo htm
	private final int INICIO_DADOS = 1;
	private final int PRIMEIRA_DEZENA = 2;
	private final int ULTIMA_DEZENA = 16;

	private List<Jogo> listaJogos = new ArrayList<Jogo>();

	@Override
	public List<Jogo> readFile(String fileName) {
		try {
			File file = new File(fileName);
		
			return importarSorteios(file);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Jogo>();
		}
	}
	
	/**
	 * Importa os sorteios de jogos já realizados para a base de dados
	 * 
	 * @param arquivoSorteios
	 * @throws Exception
	 */
	public List<Jogo> importarSorteios(File arquivoSorteios) throws Exception {
		Document doc = Jsoup.parse(arquivoSorteios, "UTF-8", "");

		// Varre o arquivo HTML em busca das linhas da tabela, onde contém os
		// dados dos jogos
		Elements concursos = doc.getElementsByTag("tr");

		// Obtém os dados dentro de cada célula
		for (int i = INICIO_DADOS; i < concursos.size(); i++) {
			Element e = concursos.get(i);

			if(e.childNodeSize() > 15) {
				
				int[] dezenas = new int[TipoJogoEnum.LOTO_FACIL
						.getQtdDezenasSorteadas()];
	
				// Obtém os números das dezenas sorteadas
				for (int j = PRIMEIRA_DEZENA; j <= ULTIMA_DEZENA; j++) {
					dezenas[j-PRIMEIRA_DEZENA] = Integer.parseInt(e.child(j).text().trim());
				}
				
				Arrays.sort(dezenas);
				
				listaJogos.add(new Jogo(dezenas));
			}
		}
		
		return listaJogos;

	}
}