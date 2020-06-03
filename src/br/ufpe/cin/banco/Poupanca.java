package br.ufpe.cin.banco;

public class Poupanca extends Conta {
	
	public Poupanca(String numero, double valor) throws OperacaoComValorNegativoException {
		super(numero, valor);
	}
	
	public Poupanca(String numero) throws OperacaoComValorNegativoException {
		super(numero);
	}
	
	public void renderJuros(double taxa) throws OperacaoComValorNegativoException {
		double juros = this.getSaldo() * taxa;
		this.creditar(juros);
	}
	
	
}
