package br.com.baron.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Mes extends AbstractModel {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private Integer ano;
}
