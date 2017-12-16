package melo.mc.apolo.loto.facil.backend.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonAutoDetect
@Data
@AllArgsConstructor
public class Jogo {
	private int[] dezenas;
}
