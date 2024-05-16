/**
 * @author Felipe komatsu
 */
package model.entidades;

import model.entidades.Pessoa;
import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    protected String cnpj;
   
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
        
    }
    
    public PessoaJuridica(){
        
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID = ").append(id);
        sb.append(", Nome = ").append(nome);
        sb.append(", CNPJ = ").append(cnpj);
        return sb.toString();
    }
}