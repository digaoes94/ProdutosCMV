package entities;

public class ProdutoNacional extends Produto {

	public ProdutoNacional(String produtoNome, Double produtoPreco, Double icms, Double alternativo) {
		super(produtoNome, produtoPreco, icms, alternativo);
	}

	// get set imposto sobre produto industrializado
	public Double getIpi() {
		return alternativo;
	}
	public void setIpi(Double alternativo) {
		this.alternativo = alternativo;
	}
	
	@Override
	public Double PrecoFinal() {
		Double precoFinal = getProdutoPreco() * (1 + getIcms() * (1 + getIpi()));
		return precoFinal;
	}
	
//	public String toString() {
//		String resumo = "";
//		resumo += "Produto: " + getProdutoNome() + ". ICMS: " + String.format("%.2f", getIcms() + ". IPI: " + String.format("%.2f", getIpi()) + ".\n");
//		resumo += "Preço sem imposto: R$ " + String.format("%.2f", getProdutoPreco()) + ". Produto com imposto: R$ " + String.format("%.2f", PrecoFinal()) + ".";
//		return resumo;
//	}
}