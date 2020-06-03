package br.ufpe.cin.ui.tui;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValorNegativoException;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.PoupancaEspecial;
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
			System.out.println("7 - Transferir Quantia.");

			try {
				myOption = reader.nextInt();

				switch (myOption) {
				case 1:
					System.out.println();
					System.out.println("Escolha uma opcao:");
					System.out.println("1 - Conta;");
					System.out.println("2 - Conta Especial;");
					System.out.println("3 - Conta Imposto;");
					System.out.println("4 - Poupança;");
					System.out.println("5 - Poupança Especial.");
					System.out.println();

					myOption = reader.nextInt();

					numero = UI_Util.lerNumeroConta(reader);

					switch (myOption) {
					case 1:
						UI_Util.cadastrar(banco, reader, new Conta(numero));

						break;
					case 2:
						UI_Util.cadastrar(banco, reader, new ContaEspecial(numero));

						break;
					case 3:
						UI_Util.cadastrar(banco, reader, new ContaImposto(numero));

						break;
					case 4:
						UI_Util.cadastrar(banco, reader, new Poupanca(numero));

						break;

					case 5:
						UI_Util.cadastrar(banco, reader, new PoupancaEspecial(numero));

						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}

					break;
				case 2:
					numero = UI_Util.lerNumeroConta(reader);
					valor = UI_Util.lerValor(reader, "Digite o valor do débito: ");

					banco.debitar(numero, valor);
					System.out.println("Débito executado com sucesso!");
					break;
				case 3:
					numero = UI_Util.lerNumeroConta(reader);
					valor = UI_Util.lerValor(reader, "Digite o valor do crédito: ");

					banco.creditar(numero, valor);
					System.out.println("Crédito executado com sucesso!");
					break;
				case 4:
					numero = UI_Util.lerNumeroConta(reader);
					banco.renderJuros(numero);
					System.out.println("Juros creditado com sucesso!");
					break;
				case 5:
					numero = UI_Util.lerNumeroConta(reader);
					banco.renderBonus(numero);
					System.out.println("Bônus creditado com sucesso!");
					break;
				case 6:
					numero = UI_Util.lerNumeroConta(reader);
					System.out.printf("O saldo da conta eh R$ %.2f \n", banco.getSaldo(numero));

					break;
				case 7:
					System.out.print("Digite o número da conta origem: ");
					numero = reader.next();
					
					valor = UI_Util.lerValor(reader, "Digite o valor da transferencia: ");
					
					System.out.print("Digite o número da conta destino: ");
					String destino = reader.next();
					
					banco.transferir(numero, destino, valor);
					System.out.println("Transferência executada com sucesso!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			} catch (ContaJaCadastradaException | OperacaoComValorNegativoException | ContaNaoEncontradaException
					| RenderJurosPoupancaException | SaldoInsuficienteException | RenderBonusContaEspecialException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!");
			}
			System.out.println();
			ans = UI_Util.verificarResposta(reader, "Você gostaria de voltar ao menu principal? (s/n) ");
			System.out.println();
		} while (ans == 's');

	}


}
