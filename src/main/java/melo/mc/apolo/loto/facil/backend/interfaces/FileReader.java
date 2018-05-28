package melo.mc.apolo.loto.facil.backend.interfaces;

import java.util.List;

import melo.mc.apolo.loto.facil.backend.model.Jogo;

public interface FileReader {
	List<Jogo> readFile(String fileName);
}
