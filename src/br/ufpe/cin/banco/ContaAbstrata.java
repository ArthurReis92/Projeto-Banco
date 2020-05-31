package br.ufpe.cin.banco;

/**
 * Modifique a classe Conta para lancar a excecao SaldoInsuficienteException 
 * e ajuste das demais classes da aplicacao
 *
 */
public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	
	public ContaAbstrata(String numero, double valor) {
		this.numero = numero;
		this.saldo = valor;
	}
	
	public ContaAbstrata(String numero) {
		this(numero, 0.0);
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public abstract void debitar(double valor) throws SaldoInsuficienteException;

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaAbstrata other = (ContaAbstrata) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}
