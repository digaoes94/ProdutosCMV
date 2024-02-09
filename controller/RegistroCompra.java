package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoNacional;

public class RegistroCompra {
	// System.out.println("");
	private Scanner scan = new Scanner(System.in);
	protected List<Produto> produtosRevenda = new ArrayList<Produto>();

	// ADICIONAR PRODUTO
	public void AdicionarProduto(boolean imp) {
		String produtoNome;
		Double produtoPreco, icms, ipi, impostoAlfandega;

		if (imp == true) {
			System.out.println("Digite o nome do produto:");
			produtoNome = scan.next();
			System.out.println("Digite o preço do produto:");
			produtoPreco = scan.nextDouble();
			System.out.println("Digite o imposto de entrada, no país, do produto:");
			impostoAlfandega = scan.nextDouble();
			System.out.println("Digite o ICMS do produto:");
			icms = scan.nextDouble();

			Produto produtoImp = new ProdutoImportado(produtoNome, produtoPreco, icms, impostoAlfandega);
			produtosRevenda.add(produtoImp);
		} 
		if (imp == false) {
			System.out.println("Digite o nome do produto:");
			produtoNome = scan.next();
			System.out.println("Digite o preço do produto:");
			produtoPreco = scan.nextDouble();
			System.out.println("Digite o IPI do produto:");
			ipi = scan.nextDouble();
			System.out.println("Digite o ICMS do produto:");
			icms = scan.nextDouble();

			Produto produtoNac = new ProdutoNacional(produtoNome, produtoPreco, icms, ipi);
			produtosRevenda.add(produtoNac);
		}

	}

	// REMOVER PRODUTO
	public void RemoverProduto() {
		System.out.println("Qual o nome do produto a ser removido?");
		String removerProduto = scan.next();

		for (Produto prod : produtosRevenda) {
			if (prod.getProdutoNome() == removerProduto) {
				produtosRevenda.remove(prod);
			}
		}
	}

	// CONSULTAR PRODUTO
	public String ConsultarProduto(String consultarProduto) {
		String retorna = "";

		for (Produto prod : produtosRevenda) {
			if (prod.getProdutoNome() == consultarProduto) {
				retorna = prod.toString();
			}
		}
		return retorna;
	}

	// RESUMO DA COMPRA ATÉ O MOMENTO
	public void ResumoCompra() {
		double valorTotal = 0;

		for (Produto prod : produtosRevenda) {
			valorTotal = valorTotal + prod.PrecoFinal();
			System.out.println(prod.toString());
		}

		System.out.println("Valor final da CMV: R$ " + String.format("%.2f", valorTotal));
	}
}