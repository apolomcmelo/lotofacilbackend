package melo.mc.apolo.loto.facil.backend.enums;

public enum RequestResponseStatusEnum {
	INTERNAL_ERROR(500),
	SUCCESS_OK(200);

	private int status;

	RequestResponseStatusEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}