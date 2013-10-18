/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Peixe
 */
@Entity
public class Cidade implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String estado;
    @Transient
    private Train train;
    @Transient
    private Train train2;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain2() {
        return train2;
    }

    public void setTrain2(Train train2) {
        this.train2 = train2;
    }
}
