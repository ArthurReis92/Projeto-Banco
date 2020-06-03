package br.ufpe.cin.banco;

public class PoupancaEspecial extends Poupanca {

	private final double TAXA_ESP = 0.05;

	public PoupancaEspecial(String numero, double valor) throws OperacaoComValorNegativoException {
		super(numero, valor);
	}

	public PoupancaEspecial(String numero) throws OperacaoComValorNegativoException {
		super(numero);
	}

	@Override
	public void renderJuros(double taxa) throws OperacaoComValorNegativoException {
		double juros = this.getSaldo() * (taxa + TAXA_ESP);
		this.creditar(juros);
	}
}
