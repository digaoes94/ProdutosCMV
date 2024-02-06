package entities;

public class ProdutoImportado extends Produto {
	private Double impostoAlfandega;

	public ProdutoImportado(String produtoNome, Double produtoPreco, Double icms, Double impostoAlfandega) {
		super(produtoNome, produtoPreco, icms);
		this.impostoAlfandega = impostoAlfandega;
	}

	// get set imposto alfândega
	public Double getImpostoAlfandega() {
		return impostoAlfandega;
	}
	public void setImpostoAlfandega(Double impostoAlfandega) {
		this.impostoAlfandega = impostoAlfandega;
	}
}