package br.com.teste.netshoes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Campo Obrigatorio!")
	@Column(nullable = false)
	private String cep;
	@NotNull(message = "Campo Obrigatorio!")
	@Column(nullable = false)
	private String rua;
	@NotNull(message = "Campo Obrigatorio!")
	@Column(nullable = false)
	private String numero;

	@Column(nullable = true)
	private String bairro;

	@Column(nullable = true)
	private String complemento;
	@NotNull(message = "Campo Obrigatorio!")
	@Column(nullable = false)
	private String cidade;
	@NotNull(message = "Campo Obrigatorio!")
	@Column(nullable = false)
	private String estado;

	public Endereco() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
