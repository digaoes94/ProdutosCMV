package entities;

public class Produto {
	private String produtoNome;
	private Double produtoPreco, icms;
	protected Double alternativo;
	
	public Produto(String produtoNome, Double produtoPreco, Double icms, Double alternativo) {
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.icms = icms;
		this.alternativo = alternativo;
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
	
	//  get set IPI/ALFANDEGA
	public Double getAlternativo() {
		return alternativo;
	}
	public void setAlternativo(Double alternativo) {
		this.alternativo = alternativo;
	}
	
	public Double PrecoFinal() {
		Double precoFinal = getProdutoPreco() * (1 + getIcms());
		return precoFinal;
	}
}