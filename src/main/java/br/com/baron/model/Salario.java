package br.com.baron.model;

import java.math.BigDecimal;
import java.util.Calendar;

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
public class Salario extends AbstractModel {
	
	@Column
	private BigDecimal valorBruto;
	
	@Column
	private BigDecimal valorLiquido;
	
	@Column
	private BigDecimal descontos;
	
	@Column
	private String descricaoDescontos;
	
	@Column
	private Calendar dataExpiracao;
}
