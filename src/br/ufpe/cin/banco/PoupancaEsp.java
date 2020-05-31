package br.ufpe.cin.banco;

public class PoupancaEsp extends Poupanca {
	
	private final double TAXA_ESP = 0.1;

	public PoupancaEsp(String numero, double valor) {
		super(numero, valor);
	}

	public PoupancaEsp(String numero) {
		super(numero);
	}
	
	@Override
	public void renderJuros(double taxa) {
		double juros = this.getSaldo() * (taxa+TAXA_ESP);
		this.creditar(juros);
	}
}
