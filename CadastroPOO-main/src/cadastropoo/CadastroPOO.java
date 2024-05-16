package cadastropoo;
/**
 * @author Felipe komatsu
 */
import java.io.IOException;
import model.entidades.PessoaFisica;
import model.gerenciadores.PessoaFisicaRepo;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            PessoaFisica pf1 = new PessoaFisica(1, "Ana", "11111111111", 25);
            PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
            repo1.inserir(pf1);
            repo1.inserir(pf2);

            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "333333333333");
            PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "444444444444");
            repo3.inserir(pj1);
            repo3.inserir(pj2);

            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");
        } catch (IOException e) {
            System.err.println("Erro ao acessar o arquivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
