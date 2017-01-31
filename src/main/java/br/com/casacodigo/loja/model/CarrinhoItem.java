package br.com.casacodigo.loja.model;

import java.math.BigDecimal;

public class CarrinhoItem {
	private TipoPreco tipoPreco;
	private Produto produto;
	
	public CarrinhoItem(Produto produto, TipoPreco tipoPreco){
		this.produto = produto;
		this.tipoPreco = tipoPreco;
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public BigDecimal getPreco(){
		return produto.precoPara(tipoPreco);
	}
	
	//Existe um erro nesse método!!!!!
	public BigDecimal getTotal(int quantidade) {
//		BigDecimal total = getPreco().multiply(new BigDecimal(quantidade));
//		System.out.println("Método getTotal da classe CarrinhoItem: " + total);
		return (new BigDecimal(5.2));//this.getPreco().multiply(new BigDecimal(quantidade));
	   	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((tipoPreco == null) ? 0 : tipoPreco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoItem other = (CarrinhoItem) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (tipoPreco != other.tipoPreco)
			return false;
		return true;
	}

		
}
