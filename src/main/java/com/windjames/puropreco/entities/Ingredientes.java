package com.windjames.puropreco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ingredientes")
public class Ingredientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long medida;
    private String unidadeMedida;

    public Ingredientes(){
    }
    
    public Ingredientes(long id, String nome, long medida, String unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.medida = medida;
        this.unidadeMedida = unidadeMedida;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMedida() {
        return medida;
    }

    public void setMedida(long medida) {
        this.medida = medida;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + (int) (medida ^ (medida >>> 32));
        result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingredientes other = (Ingredientes) obj;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (medida != other.medida)
            return false;
        if (unidadeMedida == null) {
            if (other.unidadeMedida != null)
                return false;
        } else if (!unidadeMedida.equals(other.unidadeMedida))
            return false;
        return true;
    }

    
}
