package br.ufpe.cin.ui.tui;

import java.util.Locale;
import java.util.Scanner;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.PoupancaEsp;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArrayList;

public abstract class Banco_TUI {

	public static void main(String[] args) throws Throwable {
		RepositorioContas repositorio = new RepositorioContasArrayList();
		Banco banco = new Banco(repositorio);
		Locale.setDefault(Locale.US);
		Scanner reader = new Scanner(System.in);
		char ans;
		int myOption;
		String numero;
		double valor;

		do {
			System.out.println();
			System.out.println("Bem Vindo ao banco!\n");
			System.out.println("Escolha uma opcao:");
			System.out.println("1 - Criar conta;");
			System.out.println("2 - Debitar de Conta;");
			System.out.println("3 - Creditar em Conta;");
			System.out.println("4 - Render Juros;");
			System.out.println("5 - Render Bonus;");
			System.out.println("6 - Consultar Saldo;");
			System.out.println("7 - Transferir Quantia;");

			myOption = reader.nextInt();
			
			switch (myOption) {
			case 1:
				System.out.println("Escolha uma opcao:");
				System.out.println("1 - Conta;");
				System.out.println("2 - Conta Especial;");
				System.out.println("3 - Conta Imposto;");
				System.out.println("4 - Poupança;");
				System.out.println("5 - Poupança Especial.");

				myOption = reader.nextInt();

				switch (myOption) {
				case 1:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Você deseja fazer um deposito inicial:");
					ans = reader.next().charAt(0);
					if (ans == 's') {
						System.out.print("Digite o valor: ");
						valor = reader.nextDouble();
						banco.cadastrar(new Conta(numero, valor));
					} else {
						banco.cadastrar(new Conta(numero));
					}

					break;
				case 2:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Você deseja fazer um deposito inicial:");
					ans = reader.next().charAt(0);
					if (ans == 's') {
						System.out.print("Digite o valor: ");
						valor = reader.nextDouble();
						banco.cadastrar(new ContaEspecial(numero, valor));
					} else {
						banco.cadastrar(new ContaEspecial(numero));
					}

					break;
				case 3:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Você deseja fazer um deposito inicial:");
					ans = reader.next().charAt(0);
					if (ans == 's') {
						System.out.print("Digite o valor: ");
						valor = reader.nextDouble();
						banco.cadastrar(new ContaImposto(numero, valor));
					} else {
						banco.cadastrar(new ContaImposto(numero));
					}

					break;
				case 4:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Você deseja fazer um deposito inicial:");
					ans = reader.next().charAt(0);
					if (ans == 's') {
						System.out.print("Digite o valor: ");
						valor = reader.nextDouble();
						banco.cadastrar(new Poupanca(numero, valor));
					} else {
						banco.cadastrar(new Poupanca(numero));
					}
					break;

				case 5:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Você deseja fazer um deposito inicial:");
					ans = reader.next().charAt(0);
					if (ans == 's') {
						System.out.print("Digite o valor: ");
						valor = reader.nextDouble();
						banco.cadastrar(new PoupancaEsp(numero, valor));
					} else {
						banco.cadastrar(new PoupancaEsp(numero));
					}
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			System.out.print("Você gostaria de voltar ao menu principal? (s/n)");
			ans = reader.next().charAt(0);
		} while (ans == 's');


	}

}
