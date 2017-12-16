package melo.mc.apolo.loto.facil.backend.regras;

import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.model.Jogo;

public class RegraParesImpares implements Regra {
	
	@Override
	public boolean isValido(Jogo jogo) {
		int pares = 0;

		for (int i = 0; i < jogo.getDezenas().length; i++) {
			if (jogo.getDezenas()[i] % 2 == 0) {
				pares++;
			}
		}
		
		return (pares >= 5) && (pares <= 10);
	}
}