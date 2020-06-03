package br.ufpe.cin.banco;

public class OperacaoComValorNegativoException extends Exception {
	
	public OperacaoComValorNegativoException() {
		super("A operacao nao pode ser realizada com valor negativo.");
	}
	
//	public OperacaoComValorNegativoException(String str) {
//		super(str);
//	}
	

}
