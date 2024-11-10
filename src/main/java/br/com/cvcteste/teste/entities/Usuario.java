package br.com.cvcteste.teste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Usuario {
	@Id
	@Column
	private Integer id;
	@Column
	private String usuario;
	@Column
	private String password;
}
