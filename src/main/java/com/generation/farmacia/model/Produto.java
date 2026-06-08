package com.generation.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 3, max = 100, message = "O atributo nome deve ter entre 3 e 100 caracteres")
    @Column(length = 100)
    private String nome;
    
    @NotBlank(message = "O atributo descricao é obrigatório!")
    @Size(min = 5, max = 500, message = "O atributo descricao deve ter entre 5 e 500 caracteres")
    @Column(length = 500)
    private String descricao;
    
    @NotNull(message = "O atributo preco é obrigatório!")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;
    
    @NotNull(message = "O atributo quantidade é obrigatório!")
    @Positive(message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
    
    @UpdateTimestamp
    private LocalDateTime data;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }
    
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}