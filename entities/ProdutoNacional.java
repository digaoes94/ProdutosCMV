package entities;

public class ProdutoNacional extends Produto {
	private Double ipi;

	public ProdutoNacional(String produtoNome, Double produtoPreco, Double icms, Double ipi) {
		super(produtoNome, produtoPreco, icms);
		this.ipi = ipi;
	}

	// get set imposto sobre produto industrializado
	public Double getIpi() {
		return ipi;
	}
	public void setIpi(Double ipi) {
		this.ipi = ipi;
	}
}