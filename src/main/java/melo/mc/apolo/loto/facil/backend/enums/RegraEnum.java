package melo.mc.apolo.loto.facil.backend.enums;

import java.util.ArrayList;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.regras.RegraParesImpares;

/**
 * Enum que representa as regras definidas para filtrar os jogos a serem sorteados
 * 
 * @since 2017-09-24
 * @author Apolo Mc Melo
 */
public enum RegraEnum {
	REGRA_PARES_IMPARES(new RegraParesImpares(), "Pares e Ímpares", "O jogo será considerado válido se possuir de 5 a 10 dezenas pares");
	
	private Regra regra;
	private String nome;
	private String descricao;
	
	private RegraEnum(Regra regra, String nome, String descricao) {
		this.regra = regra;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static RegraEnum nomeToEnum(String strRegra) {
		if (REGRA_PARES_IMPARES.getNome().equals(strRegra)) {
			return REGRA_PARES_IMPARES;
		} else {
			return null;
		}
	}
	
	public static List<Regra> getTodasRegras() {
		List<Regra> regras = new ArrayList<Regra>();
		
		for(int i=0; i<RegraEnum.values().length; i++) {
			regras.add(RegraEnum.values()[i].getRegra());
		}
		
		return regras;
	}
}