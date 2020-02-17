package br.com.fiap.revisao.bean;



//classe abstrata -> nao pode ser instanciada, pode conter meodos abstratos
public abstract class Produto {
	
	private String nome;
	
	protected double preco;
	
	
	private Embalagem embalagem;
		
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public double descontar(double desconto) {
		return preco - desconto;
	}
	
	//metodo abstrato -> metodo sem implementação
	public abstract void aumentar (double valor);
	
	// sobrecarga de metods(mesmo metodo parametros diferentes)
	public double descontar(int porcentagem) {
		return preco - (preco*porcentagem)/100;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem emabalagem) {
		this.embalagem = emabalagem;
	}
	
}
