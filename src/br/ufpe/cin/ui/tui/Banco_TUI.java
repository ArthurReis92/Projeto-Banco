package br.ufpe.cin.ui.tui;

import java.util.Scanner;
import br.ufpe.cin.banco.Conta;

public abstract class Banco_TUI {

	public static void main(String[] args) {
		System.out.println("Bem Vindo ao banco!\n");
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Criar conta;");
		System.out.println("2 - Debitar de Conta;");
		System.out.println("3 - Creditar em Conta;");
		System.out.println("4 - Render Juros;");
		System.out.println("5 - Render Bonus;");
		System.out.println("6 - Consultar Saldo;");
		System.out.println("7 - Transferir Quantia;");
		
		Scanner menuOption = new Scanner (System.in);
		int myOption = menuOption.nextInt();
		System.out.println(myOption);
		
		System.out.println("Insira o numero da nova conta.");
		menuOption.nextLine();
		String numero = menuOption.nextLine();
		
		switch (myOption) {
		
		case 1:
			Conta c1 = new Conta(numero);
			System.out.println("Conta " + numero +" criada com sucesso.");
		}
	}

}
