package br.ufpe.cin.ui.tui;

import java.util.Locale;
import java.util.Scanner;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValorNegativoException;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.PoupancaEsp;
import br.ufpe.cin.banco.RenderBonusContaEspecialException;
import br.ufpe.cin.banco.RenderJurosPoupancaException;
import br.ufpe.cin.banco.SaldoInsuficienteException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArrayList;

public abstract class Banco_TUI {

	public static void main(String[] args) {
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

			try {
				switch (myOption) {
				case 1:
					System.out.println("Escolha uma opcao:");
					System.out.println("1 - Conta;");
					System.out.println("2 - Conta Especial;");
					System.out.println("3 - Conta Imposto;");
					System.out.println("4 - Poupança;");
					System.out.println("5 - Poupança Especial.");

					myOption = reader.nextInt();

					System.out.print("Digite o número da conta: ");
					numero = reader.next();

					switch (myOption) {
					case 1:
						cadastrar(banco, reader, new Conta(numero));

						break;
					case 2:
						cadastrar(banco, reader, new ContaEspecial(numero));

						break;
					case 3:
						cadastrar(banco, reader, new ContaImposto(numero));

						break;
					case 4:
						cadastrar(banco, reader, new Poupanca(numero));

						break;

					case 5:
						cadastrar(banco, reader, new PoupancaEsp(numero));

						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}

					break;
				case 2:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Digite o valor do débito: ");
					valor = reader.nextDouble();

					banco.debitar(numero, valor);

					break;
				case 3:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.print("Digite o valor do crédito: ");
					valor = reader.nextDouble();

					banco.creditar(numero, valor);

					break;
				case 4:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					banco.renderJuros(numero);

					break;
				case 5:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					banco.renderBonus(numero);

					break;
				case 6:
					System.out.print("Digite o número da conta: ");
					numero = reader.next();
					System.out.printf("O saldo da conta eh %.2f \n", banco.getSaldo(numero));

					break;
				case 7:
					System.out.print("Digite o número da conta origem: ");
					numero = reader.next();
					System.out.print("Digite o valor da transferencia: ");
					valor = reader.nextDouble();
					System.out.print("Digite o número da conta destino: ");
					String destino = reader.next();
					banco.transferir(numero, destino, valor);

					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			} catch (ContaJaCadastradaException | OperacaoComValorNegativoException | ContaNaoEncontradaException 
					| RenderJurosPoupancaException | SaldoInsuficienteException | RenderBonusContaEspecialException e) {
				System.out.println(e.getMessage());
			}

			System.out.print("Você gostaria de voltar ao menu principal? (s/n) ");
			ans = reader.next().toLowerCase().charAt(0);
			while (ans != 's' && ans != 'n') {
				System.out.println("Opção inválida.");
				System.out.print("Você deseja fazer um deposito inicial: (s/n) ");
				ans = reader.next().charAt(0);
			}
		} while (ans == 's');

	}

	public static void cadastrar(Banco banco, Scanner reader, ContaAbstrata conta)
			throws ContaJaCadastradaException, ContaNaoEncontradaException, OperacaoComValorNegativoException {
		char ans;
		double valor;
		System.out.print("Você deseja fazer um deposito inicial: (s/n) ");
		ans = reader.next().toLowerCase().charAt(0);
		while (ans != 's' && ans != 'n') {
			System.out.println("Opção inválida.");
			System.out.print("Você deseja fazer um deposito inicial: (s/n) ");
			ans = reader.next().charAt(0);
		}
		if (ans == 's') {
			System.out.print("Digite o valor: ");
			valor = reader.nextDouble();
			banco.cadastrar(conta);
			banco.creditar(conta.getNumero(), valor);
		} else if (ans == 'n') {
			banco.cadastrar(conta);
		}
	}

}
