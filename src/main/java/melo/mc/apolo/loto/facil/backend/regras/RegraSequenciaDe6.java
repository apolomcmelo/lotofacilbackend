package melo.mc.apolo.loto.facil.backend.regras;

import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

public class RegraSequenciaDe6 implements Regra {

	@Override
	public boolean isValido(Jogo jogo) {
		int qtdSequencia = 0;
		int countSeguidos = 1;
		
		for (int i = 0; i < jogo.getDezenas().length-1; i++) {
			if ((jogo.getDezenas()[i]+1) == jogo.getDezenas()[i+1]) {
				countSeguidos++;
				
				if(countSeguidos == 6) {
					qtdSequencia++;
					countSeguidos = 1;
				}
			} else {
				countSeguidos = 1;
			}
		}

		return qtdSequencia < 2;
	}
}