import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	
	/* Declaração das variáveis saldo e saque */
	int saldo;
	int saque;

	/* Declaração da variável que indicará se o cliente é especial ou não.*/
	boolean clienteEspecial = true;
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	public boolean isClienteEspecial() {
		return clienteEspecial;
	}

	public void setClienteEspecial(boolean clienteEspecial) {
		this.clienteEspecial = clienteEspecial;
	}
	/* PRIMEIRO CENARIO: CLIENTE ESPECIAL
	
	/* @param int1 O primeiro teste, se espera que o cliente seja do tipo especial e que o saldo seja um inteiro */
	@Given("cliente especial com saldo atual de {int} reais")
	public void cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		this.saldo = int1;
		if(this.clienteEspecial != true || !(int1 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/* @param int2 O segundo teste, se espera que o valor recebido seja um inteiro*/	
	@When("solicitado um saque no valor de {int} reais")
	public void solicitado_um_saque_no_valor_de_reais(Integer int2) {
		this.saque = int2;
		if(!(int2 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/* @param int3 O terceiro teste, se espera que o valor de saldo seja subtraido do saque e que o resultado seja igual ao int3, que seria um número inteiro*/
	@Then("efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int3) {
		if(int3 instanceof Integer)
		{
			setSaldo(getSaldo() - getSaque());
			if(getSaldo() != int3)
				throw new io.cucumber.java.PendingException();
		} else
			throw new io.cucumber.java.PendingException();
	}

	/* SEGUNDO CENARIO: CLIENTE COMUM
	
	 * @param int4  O quarto teste, se espera que o valor seja um inteiro e que o cliente seja comum*/
	@Given("cliente comum com saldo atual de {int} reais")
	public void cliente_comum_com_saldo_atual_de_reais(Integer int4) {
		this.saldo = int4;
		if(!(int4 instanceof Integer  ||  this.clienteEspecial == true))
			throw new io.cucumber.java.PendingException();
	}


	 /* @param int5 O quinto parâmetro de teste se espera que o valor recebido seja um inteiro*/
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int5) {
		this.saque = int5;
		if(!(int5 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/* Nesse método, esperasse que o cliente seja do tipo normal, se o saldo for menor que o valor de saque, deve ser retornado uma mensagem de "Saldo Insuficiente". */
	
	@Then("Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if((getSaque() < getSaldo() && !(getSaldo() > 0)))
			throw new io.cucumber.java.PendingException();
		if(getSaque() >= getSaldo())
			System.out.println("Saldo Insuficiente"); 
	}
}
