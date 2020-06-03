package br.ufpe.cin.ui.tui;

import java.util.Scanner;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValorNegativoException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;

public class UI_Util {

	public static char verificarResposta(Scanner reader, String msg) {
		char ans;
		do {
			System.out.print(msg);
			reader.nextLine();
			ans = reader.next().charAt(0);
			if (ans != 's' && ans != 'n') {
				System.out.println("Opção inválida.");
			}
		} while (ans != 's' && ans != 'n');
		return ans;
	}

	public static double lerValor(Scanner reader, String operacao) {
		double valor;
		System.out.print(operacao);
		valor = reader.nextDouble();
		return valor;
	}

	public static String lerNumeroConta(Scanner reader) {
		String numero;
		System.out.print("Digite o número da conta: ");
		numero = reader.next();
		return numero;
	}

	public static void cadastrar(Banco banco, Scanner reader, ContaAbstrata conta)
			throws ContaJaCadastradaException, ContaNaoEncontradaException, OperacaoComValorNegativoException {
		char ans;
		double valor;
		ans = verificarResposta(reader, "Você deseja fazer um deposito inicial? (s/n) ");
		if (ans == 's') {
			System.out.print("Digite o valor: ");
			valor = reader.nextDouble();
			banco.cadastrar(conta);
			banco.creditar(conta.getNumero(), valor);
		} else if (ans == 'n') {
			banco.cadastrar(conta);
		}
		System.out.println(conta.getClass().getSimpleName() + " cadastrada com sucesso!");
	}

}
