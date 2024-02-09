package application;

import java.util.Scanner;
import java.util.Locale;

import controller.RegistroCompra;
import entities.Produto;

public class ControleCompras {
	//  System.out.println("");
	public static Scanner scan = new Scanner(System.in);
	public static RegistroCompra registro = new RegistroCompra();
	public static Locale portugues = new Locale("pt", "BR");
	
	//  PRINCIPAL
	public static void main(String[] args) {
		boolean run = true;
		
		System.out.println("Sistema - Controle de Compra de Mercadoria para Revenda\n");
		do {
			run = Menu();
		} while (run == true);
	}
	
	
	//  CONTINUAÇÃO
	public static boolean Menu() {
		boolean continuar = true;
		int escolha = 0;
		
		System.out.println("Digitar número do procedimento a executar");
		System.out.println("1 - Adicionar produto");
		System.out.println("2 - Remover produto");
		System.out.println("3 - Consultar produto");
		System.out.println("4 - Resumo da compra de Produtos para Revenda");
		System.out.println("5 - Encerrar programa");
		
		escolha = scan.nextInt();
		
		switch (escolha) {
			case 1:
				int quantidadeProdutos = 0;
				
				System.out.println("Quantos produtos serão adicionados?");
				quantidadeProdutos = scan.nextInt();
				
				for (int a = 1; a <= quantidadeProdutos; a++) {
					boolean imp = false;
					String importado = "";
					
					System.out.println("Dados do produto n° " + a);
					System.out.println("O produto é importado? Digite SIM ou NAO");
					importado = scan.next().toLowerCase();
					
					switch (importado) {
						case "sim":
							imp = true;
							registro.AdicionarProduto(imp);
							break;
						case "não":
							imp = false;
							registro.AdicionarProduto(imp);
							break;
					}
				}
				
				continuar = true;
				break;
				
			case 2:
				registro.RemoverProduto();
				continuar = true;
				break;
				
			case 3:
				System.out.println("Qual o nome do produto a ser consultado?");
				String consultarProduto = scan.next();
				
				for (Produto prod : registro.getProdutosRevenda()) {
					if (prod.getProdutoNome() == consultarProduto) {
						consultarProduto = registro.ConsultarProduto(prod);
					}
					else {
						consultarProduto = "Produto não encontrado.";
					}
				}
				
				System.out.println(consultarProduto);
				
				continuar = true;
				break;
				
			case 4:
				registro.ResumoCompra();
				continuar = true;
				break;
				
			case 5:
				System.out.println("O programa será encerrado.");
				continuar = false;
				break;
				
			default:
				System.out.println("Escolha inválida, o programa será encerrado.");
				continuar = false;
		}
		
		return continuar;
	}
}