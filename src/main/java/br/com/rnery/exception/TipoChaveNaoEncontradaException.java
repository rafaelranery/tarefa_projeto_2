package br.com.rnery.exception;

public class TipoChaveNaoEncontradaException extends Exception {
	public TipoChaveNaoEncontradaException(String message) {
		this(message, null);
	}
	public TipoChaveNaoEncontradaException(String message, Throwable e) {
		super(message, e);
	}
}
