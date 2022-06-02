package br.edu.fpb.gti.model.enums;

public enum TipoVisitanteEnum {

	VISITANTE(1, "Visitante"),
	PRESTADOR(2, "Prestador");
	
	private Integer codigo;
	
	private String descricao;
	
	private TipoVisitanteEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoVisitanteEnum getByCodigo(Integer codigo) {
		for(TipoVisitanteEnum tipo : TipoVisitanteEnum.values()) {
			if(tipo.getCodigo() == codigo) {
				return tipo;
			}
		}
		
		return null;
	}
	
	public static TipoVisitanteEnum getByDescricao(String descricao) {
		for(TipoVisitanteEnum tipo : TipoVisitanteEnum.values()) {
			if(tipo.getDescricao() == descricao) {
				return tipo;
			}
		}
		
		return null;
	}
	
}
