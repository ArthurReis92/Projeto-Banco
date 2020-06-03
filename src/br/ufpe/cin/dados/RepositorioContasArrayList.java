package br.ufpe.cin.dados;

import java.util.ArrayList;

import br.ufpe.cin.banco.ContaAbstrata;

public class RepositorioContasArrayList implements RepositorioContas{

	private ArrayList<ContaAbstrata> contas;
	
	public RepositorioContasArrayList() {
		contas = new ArrayList<ContaAbstrata>();
	}
	
	@Override
	public void inserir(ContaAbstrata conta) {
		contas.add(conta);
	}

	@Override
	public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException {
		ContaAbstrata c = null;
		if(contas.isEmpty() || !this.existe(numero)) {
			throw new ContaNaoEncontradaException();
		}
		c = contas.get(getIndice(numero));
		return c;
	}

	@Override
	public void remover(String numero) throws ContaNaoEncontradaException {
		if(contas.isEmpty() || !this.existe(numero)) {
			throw new ContaNaoEncontradaException();
		}
		contas.remove(contas.get(getIndice(numero)));
	}

	@Override
	public void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException {
		contas.set(this.getIndice(conta.getNumero()), conta);
	}

	@Override
	public boolean existe(String numero) {
		boolean achou = false;
		if(getIndice(numero) != null) {
			achou = true;
		}
		return achou;
	}
	
	private Integer getIndice(String numero) {
		Integer i = 0;
		for (ContaAbstrata contaAbstrata : contas) {
			if(contaAbstrata.getNumero().equals(numero)) {
				return i;
			}
			i++;
		}
		return null;
	}

}
