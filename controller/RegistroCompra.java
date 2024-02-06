package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoNacional;

public class RegistroCompra {
	//  System.out.println("");
	private Scanner scan = new Scanner(System.in);
	protected List<Produto> produtosRevenda = new ArrayList<Produto>();
	
	//  ADICIONAR PRODUTO
	public void AdicionarProduto() {
		System.out.println("Quantos produtos serão adicionados?");
		int quantidadeProdutos = scan.nextInt();
		
		for (int a = 0; a < quantidadeProdutos; a++) {
			System.out.println("O produto é importado? Digite SIM ou NÃO");
			String importado = scan.nextLine().toLowerCase();
			
			if (importado == "sim") {
				produtosRevenda.add(InstanciaProdutoImportado());
			}
			if (importado == "não"){
				produtosRevenda.add(InstanciaProdutoNacional());
			}
		}
	}
	
	//  REMOVER PRODUTO
	public void RemoverProduto() {
		System.out.println("Qual o nome do produto a ser removido?");
		String removerProduto = scan.nextLine();
		
		for (Produto prod : produtosRevenda) {
			if (prod.getProdutoNome() == removerProduto) {
				produtosRevenda.remove(prod);
			}
		}
	}
	
	//  CONSULTAR PRODUTO
	public void ConsultarProduto() {
		System.out.println("Qual o nome do produto a ser consultado?");
		String consultarProduto = scan.nextLine();
		
		for (Produto prod : produtosRevenda) {
			if (prod.getProdutoNome() == consultarProduto) {
				System.out.println(prod.toString());
			}
		}
	}
	
	//  RESUMO DA COMPRA ATÉ O MOMENTO
	public void ResumoCompra() {
		double valorTotal = 0;
		
		for (Produto prod : produtosRevenda) {
			valorTotal = valorTotal + prod.PrecoFinal();
			System.out.println(prod.toString());
		}
		
		System.out.println("Valor final da CMV: R$ "+ String.format("%.2f", valorTotal));
	}
	
	//  CRIA PRODUTO IMPORTADO
	private Produto InstanciaProdutoImportado() {
		String produtoNome;
		Double produtoPreco, icms, impostoAlfandega;
		
		System.out.println("Digite o nome do produto:");
		produtoNome = scan.nextLine();
		System.out.println("Digite o preço do produto:");
		produtoPreco = scan.nextDouble();
		System.out.println("Digite o imposto de entrada, no país, do produto:");
		impostoAlfandega = scan.nextDouble();
		System.out.println("Digite o ICMS do produto:");
		icms = scan.nextDouble();
		
		Produto produto = new ProdutoImportado(produtoNome, produtoPreco, icms, impostoAlfandega);
		
		return produto;
	}
	
	//  CRIA PRODUTO NACIONAL
	private Produto InstanciaProdutoNacional() {
		String produtoNome;
		Double produtoPreco, icms, ipi;
		
		System.out.println("Digite o nome do produto:");
		produtoNome = scan.nextLine();
		System.out.println("Digite o preço do produto:");
		produtoPreco = scan.nextDouble();
		System.out.println("Digite o imposto de entrada, no país, do produto:");
		ipi = scan.nextDouble();
		System.out.println("Digite o ICMS do produto:");
		icms = scan.nextDouble();
		
		Produto produto = new ProdutoNacional(produtoNome, produtoPreco, icms, ipi);
		
		return produto;
	}
}