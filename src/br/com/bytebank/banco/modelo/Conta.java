package br.com.bytebank.banco.modelo;


/**
 * Classe representa a moldura de uma conta
 *
 *@author Nico Steppat
 *
 */

public abstract class Conta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;


	/**
	 * Construtor para inicializar o objeto a partir da agencia e numero.
	 *
	 *@param agencia
	 *@param numero
	 */

	public Conta(int agencia, int numero) {
		Conta.total++;
		//		System.out.println("O total de contas é: " + total);
		this.agencia = agencia;
		this.numero = numero;
	}

	public abstract void deposita(double valor);

	/**
	 *
	 *
	 *@param valor
	 *@throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficenteException {
		if(this.saldo < valor) {
			throw new SaldoInsuficenteException("Saldo: " + this.saldo + ". Valor: " +  valor); 
		} 

		this.saldo -= valor;
	}

	public void transfere(double valor, Conta destino) throws SaldoInsuficenteException {
		this.saca(valor);
		destino.deposita(valor);

	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int Numero) {
		if(Numero <= 0) {
			//System.out.println("Numero deve ser maior que zero");
			return;
		}
		this.numero = Numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			//System.out.println("Agência deve ser maior que zero");;
			return;
		}
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return titular;
	}

	public static int getTotal() {
		return Conta.total;
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.getNumero() + ", Agencia: " + this.getAgencia();
	}

}
