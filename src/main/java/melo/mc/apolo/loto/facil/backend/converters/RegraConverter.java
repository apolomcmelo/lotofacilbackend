package melo.mc.apolo.loto.facil.backend.converters;

import java.util.ArrayList;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RegraEnum;
import melo.mc.apolo.loto.facil.backend.interfaces.Regra;
import melo.mc.apolo.loto.facil.backend.regras.RegraParesImpares;

public class RegraConverter {

	public List<RegraDTO> converterModelToDTO(List<Regra> regras) {
		List<RegraDTO> dtos = new ArrayList<RegraDTO>();
		if(regras != null){
			for(int i=0; i<regras.size(); i++) {
				Regra regra = regras.get(i);
				RegraDTO dto = new RegraDTO();
				
				if(regra instanceof RegraParesImpares) {
					dto.setNome(RegraEnum.REGRA_PARES_IMPARES.getNome());
					dto.setDescricao(RegraEnum.REGRA_PARES_IMPARES.getDescricao());
					dto.setAtiva(true);
				}
				
				dtos.add(dto);
			}
		}
		
		return dtos;
	}
	
	public List<Regra> converterDTOToModel(List<RegraDTO> dtos, boolean converterTodas) {
		List<Regra> regras = new ArrayList<Regra>();
		if(dtos != null){
			for(int i=0; i<dtos.size(); i++) {
				RegraDTO dto = dtos.get(i);
				
				if(converterTodas || dto.isAtiva()) {
					
					if(RegraEnum.REGRA_PARES_IMPARES.getNome().equals(dto.getNome())) {
						regras.add(RegraEnum.REGRA_PARES_IMPARES.getRegra());
					}
				}
			}
		}
		
		return regras;
	}
}