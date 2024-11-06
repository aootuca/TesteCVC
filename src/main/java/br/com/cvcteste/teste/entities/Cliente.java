package br.com.cvcteste.teste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@SequenceGenerator(name = "sqClienteId", sequenceName = "cliente_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "sqClienteId", strategy = GenerationType.SEQUENCE)
	@Column
	private Integer id;
	@Column
	private String nome;
	@Column
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	@MapsId
	private Endereco endereco;
}
