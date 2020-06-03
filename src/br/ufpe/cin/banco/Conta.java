package br.ufpe.cin.banco;

public class Conta extends ContaAbstrata {
	
	public Conta(String numero, double valor) throws OperacaoComValorNegativoException {
		super(numero, valor);
	}
	
	public Conta(String numero) throws OperacaoComValorNegativoException {
		super(numero);
	}

	public void debitar(double valor) throws SaldoInsuficienteException, OperacaoComValorNegativoException {
		this.validarOperacao(valor);
		if (this.getSaldo() < valor)
			throw new SaldoInsuficienteException(this.getNumero(), this.getSaldo());
		this.setSaldo(this.getSaldo() - valor);
	}
		
}