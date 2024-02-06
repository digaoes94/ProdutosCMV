package application;

import java.util.Scanner;

import controller.RegistroCompra;

public class ControleCompras {
	//  System.out.println("");
	public static Scanner scan = new Scanner(System.in);
	public static RegistroCompra registro = new RegistroCompra();
	
	public static void main(String[] args) {
		boolean run = true;
		
		do {
			run = Menu();
		} while (run == true);

	}
	
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
				registro.AdicionarProduto();
				continuar = true;
				break;
			case 2:
				registro.RemoverProduto();
				continuar = true;
				break;
			case 3:
				registro.ConsultarProduto();
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