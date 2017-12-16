package melo.mc.apolo.loto.facil.backend.business;

import java.util.List;

import melo.mc.apolo.loto.facil.backend.converters.RegraConverter;
import melo.mc.apolo.loto.facil.backend.dtos.RegraDTO;
import melo.mc.apolo.loto.facil.backend.enums.RegraEnum;

import org.springframework.beans.factory.annotation.Autowired;

public class RegraBusiness {
	@Autowired
	private RegraConverter regraConverter;
	
	public List<RegraDTO> getRegras() {
		return regraConverter.converterModelToDTO(RegraEnum.getTodasRegras());
	}
}
