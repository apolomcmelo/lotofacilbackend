package melo.mc.apolo.loto.facil.backend.util;

import java.util.Arrays;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.enums.TipoJogoEnum;

/**
 * Classe utilitária para operações padrões que podem ser utilizadas por muitas classes, servindo de apoio para um processamento mais específico
 * 
 * @since 2015-03-10
 * @author Apolo Mc Melo
 */
public class Util {
	
	// Constantes com caminho de imagens dos ícones principais
	public static String ICONE_CHECK = "/images/check_icone.png";
	public static String ICONE_ERRO = "/images/erro_icone.png";
	
	/**
	 * A partir de um número, realiza a soma dos dígitos que compõem o mesmo.
	 * <p>Ex.:
	 * <br>	<table border>
	 * 			<tr>
	 * 				<td><b>Número</b></td> <td><b>Soma</b></td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>6</td> <td>6</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>123</td> <td>6</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>41</td> <td>5</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>45</td> <td>9</td>
	 * 			</tr>
	 * 			<tr>
	 * 				<td>54</td> <td>9</td>
	 * 			</tr>
	 * 	    </table>
	 * @param n - Número desejado saber a soma dos dígitos
	 * @return Soma dos dígitos que compõem o número
	 * 
	 * @since 18-02-2015
	 * @author Apolo Mc Melo
	 */
	public static int somarDigitos(int n) {
		String nTxt = String.valueOf(n);
		int s = 0x0;
		
		for(int i=0; i<nTxt.length(); i++) {
			s += (nTxt.codePointAt(i) - 0x30);
		}
		
		return s;
	}
	 
	/**
	 * Desenha o jogo escolhido na forma do volante de jogo, imprimindo-o no console
	 * <p>Ex.:
	 * <br><i>Mega-Sena</i>
	 * <br>Jogo escolhido: 8, 14, 21, 22, 46, 59
	 * <br>Resultado:
	 * <pre>0  0  0  0  0 | 0  0  8  0  0
	 *0  0  0 14  0 | 0  0  0  0  0  
	 *21 22 0  0  0 | 0  0  0  0  0
	 *--------------|--------------
	 *0  0  0  0  0 | 0  0  0  0  0
	 *0  0  0  0  0 |46  0  0  0  0
	 *0  0  0  0  0 | 0  0  0 59  0
	 *
	 * @param sj - Sequência do jogo
	 * @param qtL - Quantidade de linhas no volante de jogo
	 * @param qtC - Quantidade de colunas no volante de jogo
	 * 
	 * @since 2015-03-10
	 * @author Apolo Mc Melo
	 */
	public static void desenharJogo(int[] sj, int qtL, int qtC) {
		int[][] vol = new int[qtL][qtC];
		int l, c;
	
		for(int i=0; i<sj.length; i++) {
			c = sj[i] % qtC;
			l = sj[i] / qtC;
			
			if(c == 0) {
				c = 10;
				l -= 1;
			}
			
			vol[l][c - 1] = sj[i];
		}
		
		imprimirVolanteConsole(vol);
	}
	
	/**
	 * Imprime no console o volante do jogo
	 * 
	 * @param vol - Volante do jogo
	 * 
	 * @since 2015-03-10
	 * @author Apolo Mc Melo
	 */
	public static void imprimirVolanteConsole(int[][] vol) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<vol.length; i++) {
			for(int j=0; j<vol[i].length; j++) {
				sb.append(vol[i][j] + " ");
				
				if(String.valueOf(vol[i][j]).length() == 1) {	
					sb.append(" ");
				}
				
				sb.append("");
				
				if(j==4) {
					sb.append("|");
				}
			}
			
			sb.append("\n");
			
			if(i==2) {
				sb.append("\n---------------|--------------\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	/**
	 * Verifica se a string passada por parâmetro é formada apenas por números, ou contém caracteres alfanumérico
	 * @param texto - Texto desejado saber o tipo de caracter que o compõe
	 * @return<code>true</code> - Caso o texto seja formado apenas por caracteres numéricos
	 *
	 * @since 2015-04-22
	 * @author Apolo Mc Melo
	 */
	public static boolean isNumero(String texto) {
		if(texto == null || "".equals(texto)) {
			return false;
		}
		
		return texto.matches("[0-9]+");
	}
	
	/**
	 * Ordena as dezenas sorteadas de cada jogo em ordem crescente.
	 * @param jogos - Lista de jogos
	 *
	 * @since 2015-04-22
	 * @author Apolo Mc Melo
	 */
	public static void ordenarDezenasJogos(List<int[]> jogos) {
		for(int i=0; i<jogos.size(); i++) {
			Arrays.sort(jogos.get(i));
		}
	}
	
	/**
	 * Gera vetor contendo todos os possíveis números de um tipo de jogo para serem sorteados
	 * @param qtdNumeros
	 * @return Vetor de int contendo todos os possíveis números para serem sorteados
	 *
	 * @since 2015-05-13
	 * @author Apolo Mc Melo
	 */
	public static int[] getNumerosPossiveis(TipoJogoEnum tipoJogo) {
		int[] numPos = new int[tipoJogo.getQtdDezenas()];
		
		for(int i=0; i<tipoJogo.getQtdDezenas(); i++) {
			numPos[i] = i+1;
		}
		
		return numPos;
	}

	public static double calcularMedia(List<int[]> numeros) {
		double media = 0d;
		
		for(int i=0; i<numeros.size(); i++) {
			for(int j=0; j<numeros.get(i).length; j++) {
				media += numeros.get(i)[j];
			}
		}
		
		return media/(numeros.size() * numeros.get(0).length);
	}
}