package br.com.equip.control.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipamento_id")
	private Long id;
	private String descricao;
	@Column(name = "num_patrimonio")
	private String numPatrimonio;
	private String local;
	@Column(name = "data_compra")
	private Date dataCompra;
	@Column(name = "valor_compra")
	private Float valorCompra;
	@Column(name = "data_venda")
	private Date dataVenda;
	@Column(name = "valor_venda")
	private Float valorVenda;

	public Equipamento() {
		
	}
	
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumPatrimonio() {
		return numPatrimonio;
	}

	public void setNumPatrimonio(String numPatrimonio) {
		this.numPatrimonio = numPatrimonio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Float valorVenda) {
		this.valorVenda = valorVenda;
	}

}
