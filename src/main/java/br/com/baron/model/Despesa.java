package br.com.baron.model;

import java.math.BigDecimal;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Despesa extends AbstractModel {
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column
	private Integer parcela;
	
	@Column(nullable = false)
	private Calendar data;
	
	@Column
	private Calendar vencimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDespesa", nullable = false)
	private TipoDespesa tipoDespesa;
}
