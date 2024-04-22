/**
 * @author Felipe komatsu
 */
package model.entidades;

import model.entidades.Pessoa;
import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    protected String cpf;
    protected int idade;
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
    
    public PessoaFisica(){
        
    }

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(id);
        sb.append(", Nome = ").append(nome);
        sb.append(", CPF = ").append(cpf);
        sb.append(", Idade = ").append(idade);
        return sb.toString();
    }

  
    
}
