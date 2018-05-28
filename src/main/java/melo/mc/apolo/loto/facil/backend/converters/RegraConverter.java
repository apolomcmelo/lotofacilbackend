package melo.mc.apolo.loto.facil.backend.converters;

import java.util.ArrayList;
import java.util.List;

import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RegraEnum;
import melo.mc.apolo.loto.facil.backend.interfaces.Regra;

import org.springframework.stereotype.Component;

@Component
public class RegraConverter {

	public List<RegraDTO> converterModelToDTO(RegraEnum[] regras) {
		List<RegraDTO> dtos = new ArrayList<RegraDTO>();
		if(regras != null){
			for(int i=0; i<regras.length; i++) {
				RegraEnum regra = regras[i];
				
				RegraDTO dto = new RegraDTO();
				
				dto.setNome(regra.getNome());
				dto.setDescricao(regra.getDescricao());
				dto.setAtiva(true);
				
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
					regras.add(RegraEnum.nomeToEnum(dto.getNome()).getRegra());
				}
			}
		}
		
		return regras;
	}
}