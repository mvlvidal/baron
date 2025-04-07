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
public class Compra extends AbstractModel {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Calendar data;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMes", nullable = false)
	private Mes mes;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column
	private Integer quantidadeParcelas;
	
	@Column
	private BigDecimal valorParcela;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCartao")
	private Cartao cartao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoCompra")
	private TipoCompra tipoCompra;
}
