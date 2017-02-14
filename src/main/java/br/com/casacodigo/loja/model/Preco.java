package br.com.casacodigo.loja.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Preco {

	private BigDecimal valor;
	private TipoPreco tipo;

	public BigDecimal getValor() {
		return valor;
	}
	public void setPreco(BigDecimal preco) {
		this.valor = preco;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
}
