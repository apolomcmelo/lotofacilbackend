package melo.mc.apolo.loto.facil.backend.regras;

import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

public class RegraMaxSeguidos implements Regra {

	@Override
	public boolean isValido(Jogo jogo) {
		int countSeguidos = 1;

		for (int i = 0; i < jogo.getDezenas().length-1; i++) {
			if ((jogo.getDezenas()[i]+1) == jogo.getDezenas()[i+1]) {
				countSeguidos++;
				
				if(countSeguidos == 7) {
					return false;
				}
			} else {
				countSeguidos = 1;
			}
		}
		
		return true;
	}
}