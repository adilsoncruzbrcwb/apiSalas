/*
 * Turno.java
 *
 * Enumerado que cont�m os poss�veis turnos de uma turma no sistema
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 29/08/2016 � Vers�o 1.0 - User � Cria��o do arquivo
 *
 */

package br.ensalamento.enums;

public enum Turno {
	/* Turnos poss�veis de uma turma */
	MATUTINO('M', "Matutino"), VESPERTINO('V', "Vespertino"), NOTURNO('N', "Noturno");

	/* Atributos normais */
	public char codigo;
	private String descricao;

	/* Construtores da classe */
	private Turno(char pCodigo, String pDescricao) {
		codigo = pCodigo;
		descricao = pDescricao;
	}

	/* M�todo est�tico de convers�o de caractere para enumerado */
	public static Turno fromChar(char pValor) {
		switch (pValor) {
		case 'M':
			return MATUTINO;
		case 'V':
			return VESPERTINO;
		case 'N':
			return NOTURNO;
		default:
			return null;
		}
	}

	/* M�todo de convers�o do enumerado para caractere */
	public char toChar() {
		return codigo;
	}

	/* M�todos da classe Object */
	@Override
	public String toString() {
		return descricao;
	}
}
