package entities;

public class Produto {
	private String produtoNome;
	private Double produtoPreco;
	private Double icms;
	
	public Produto(String produtoNome, Double produtoPreco, Double icms) {
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.icms = icms;
	}

	// get set nome do produto
	public String getProdutoNome() {
		return produtoNome;
	}
	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	// get set preço do produto
	public Double getProdutoPreco() {
		return produtoPreco;
	}
	public void setProdutoPreco(Double produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	// get set ICMS do produto
	public Double getIcms() {
		return icms;
	}
	public void setIcms(Double icms) {
		this.icms = icms;
	}
}