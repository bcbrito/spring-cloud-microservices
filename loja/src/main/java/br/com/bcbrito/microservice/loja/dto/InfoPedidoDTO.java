package br.com.bcbrito.microservice.loja.dto;

public class InfoPedidoDTO {
	private Long id;
	private Integer tempoDePreparo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}
	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}	
}
