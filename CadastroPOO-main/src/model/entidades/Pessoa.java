/**
 * @author Felipe komatsu
 */
package model.entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
     protected int id;
     protected String nome;
     
     public void exibir(){
          System.out.println("ID: " + id);
          System.out.println("Nome: " + nome);
     }
     
     public Pessoa(){
     }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(id);
        sb.append(", Nome = ").append(nome);
        return sb.toString();
    }
             
}
