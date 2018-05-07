package com.lucasedc.cursomc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int codigo;
	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	private String descricao;
	
	private EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(codigo.equals(x.getCodigo()))
				return x;
		}
		
		throw new IllegalArgumentException("ID inválido: " + codigo);
	}

}
