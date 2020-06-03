package br.ufpe.cin.banco;

public class ContaEspecial extends Conta {
	
	private double bonus;

	public ContaEspecial(String numero, double valor) throws OperacaoComValorNegativoException {
		super(numero, valor);
		bonus = 0.0;
	}
	
	public ContaEspecial(String numero) throws OperacaoComValorNegativoException {
		this(numero, 0.0);
	}

	public void creditar(double valor) throws OperacaoComValorNegativoException {
		super.creditar(valor);
		bonus = bonus + (valor * 0.01);
	}

	public void renderBonus() throws OperacaoComValorNegativoException {
		super.creditar(this.bonus);
		bonus = 0;
	}

	public double getBonus() {
		return this.bonus;
	}
}