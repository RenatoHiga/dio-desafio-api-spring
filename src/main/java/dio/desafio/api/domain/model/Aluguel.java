package dio.desafio.api.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "tb_aluguel")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_inicio;

    private Date data_fim;

    private String status;

    @OneToOne
    private Carro carro;

    @OneToOne
    private Cliente cliente;

    @Column(precision = 13, scale = 2)
    private BigDecimal valor_total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
