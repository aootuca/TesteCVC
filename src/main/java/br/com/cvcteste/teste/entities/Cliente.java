package br.com.cvcteste.teste.entities;

import java.time.LocalDateTime;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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
	@Column
	private String usuarioCriador;
	@Column
    private String usuarioAlteracao;
	@Column
	private LocalDateTime dataCriada;
	@Column
	private LocalDateTime dataAlterada;
	
	@OneToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	@MapsId
	private Endereco endereco;
}
