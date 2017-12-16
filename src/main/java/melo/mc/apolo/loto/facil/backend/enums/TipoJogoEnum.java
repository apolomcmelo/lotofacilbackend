package melo.mc.apolo.loto.facil.backend.enums;

/**
 * Enum que representa os jogos, contendo quantidade de dezenas a sortear e dezenas sorteadas
 * 
 * @since 2017-09-24
 * @author Apolo Mc Melo
 */
public enum TipoJogoEnum {
	QUADRA(40, 4, "Quadra"),
	QUINA(50, 5, "Quina"),
	SENA(60, 6, "MegaSena"),
	LOTO_FACIL(25, 15, "Loto-fácil"),
	TESTE(4, 3, "teste");	
	
	private int qtdDezenas;
	private int qtdDezenasSorteadas;
	private String descricao;
	
	private TipoJogoEnum(int qtdDezenas, int qtdDezenasSorteadas, String descricao) {
		this.qtdDezenas = qtdDezenas;
		this.qtdDezenasSorteadas = qtdDezenasSorteadas;
		this.descricao = descricao;
	}

	public int getQtdDezenas() {
		return qtdDezenas;
	}
	
	public void setQtdDezenas(int qtdDezenas) {
		this.qtdDezenas = qtdDezenas;
	}
	
	public int getQtdDezenasSorteadas() {
		return qtdDezenasSorteadas;
	}

	public void setQtdDezenasSorteadas(int qtdDezenasSorteadas) {
		this.qtdDezenasSorteadas = qtdDezenasSorteadas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoJogoEnum descricaoToEnum(String strJogo) {
		if (QUADRA.name().equals(strJogo)) {
			return QUADRA;
		} else if (QUINA.name().equals(strJogo)) {
			return QUINA;
		} else if (SENA.name().equals(strJogo)) {
			return SENA;
		} else if (LOTO_FACIL.name().equals(strJogo)) {
			return LOTO_FACIL;
		} else {
			return null;
		}
	}
	
	public static TipoJogoEnum qtdDezenasToEnum(int qtdDezenas) {
		switch (qtdDezenas) {
		case 40:
			return QUADRA;
		case 50:
			return QUINA;
		case 60:
			return SENA;
		case 25:
			return LOTO_FACIL;
		default:
			return null;
		}
	}
	
	public static TipoJogoEnum qtdDezenasSorteadasToEnum(int qtdDezenasSorteadas) {
		switch (qtdDezenasSorteadas) {
		case 4:
			return QUADRA;
		case 5:
			return QUINA;
		case 6:
			return SENA;
		case 15:
			return LOTO_FACIL;
		default:
			return null;
		}
	}
}