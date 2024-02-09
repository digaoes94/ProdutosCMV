package entities;

public class ProdutoImportado extends Produto {

	public ProdutoImportado(String produtoNome, Double produtoPreco, Double icms, Double alternativo) {
		super(produtoNome, produtoPreco, icms, alternativo);
	}

	// get set imposto alfândega
	public Double getImpostoAlfandega() {
		return alternativo;
	}
	public void setImpostoAlfandega(Double alternativo) {
		this.alternativo = alternativo;
	}
	
	@Override
	public Double PrecoFinal() {
		Double precoFinal = getProdutoPreco() * (1 + getIcms() * (1 + getImpostoAlfandega()));
		return precoFinal;
	}
	
//	public String toString() {
//		String resumo = "";
//		resumo += "Produto: " + getProdutoNome() + ". ICMS: " + String.format("%.2f", getIcms() + ". Imposto na Alfândega: " + String.format("%.2f", getImpostoAlfandega()) + ".\n");
//		resumo += "Preço sem imposto: R$ " + String.format("%.2f", getProdutoPreco()) + ". Produto com imposto: R$ " + String.format("%.2f", PrecoFinal()) + ".";
//		return resumo;
//	}
}