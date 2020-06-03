package br.ufpe.cin.banco;

/**
 * Modifique a classe Conta para lancar a excecao SaldoInsuficienteException 
 * e ajuste das demais classes da aplicacao
 *
 */
public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	
	public ContaAbstrata(String numero, double valor) throws OperacaoComValorNegativoException {
		if(valor < 0) {
			throw new OperacaoComValorNegativoException();
		}
		this.numero = numero;
		this.saldo = valor;
	}
	
	public ContaAbstrata(String numero) throws OperacaoComValorNegativoException {
		this(numero, 0.0);
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void creditar(double valor) throws OperacaoComValorNegativoException {
		validarOperacao(valor);
		this.saldo = this.saldo + valor;
	}
	
	public abstract void debitar(double valor) throws SaldoInsuficienteException, OperacaoComValorNegativoException;

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	protected void validarOperacao(double valor) throws OperacaoComValorNegativoException {
		if (valor < 0) {
			throw new OperacaoComValorNegativoException();
		}
	}
}
