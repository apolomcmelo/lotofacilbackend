package melo.mc.apolo.loto.facil.backend.interfaces;

import melo.mc.apolo.loto.facil.backend.model.Jogo;


/**
 * Interface para regras que validam a sequência de jogos
 * 
 * @since 2017-09-24
 * @author Apolo Mc Melo
 */
public interface Regra {	
	/**
	 * Verifica se a sequência de números do jogo é valida de acordo com a regra estipulada
	 * @param jogo
	 * @return <code>true</code> - se sequência for válida
	 * 	   <br><code>false</code> - se sequência não for válida 
	 */
	boolean isValido(Jogo jogo);
}