package br.com.cvcteste.teste.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@Column
	private Integer id;
	@Column
	private String rua;
	@Column
	private String cidade;
	@Column
	private String estado;
	
	@JsonIgnore
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
}
