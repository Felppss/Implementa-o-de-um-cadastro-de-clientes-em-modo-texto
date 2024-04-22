/**
 * @author Felipe komatsu
 */
package cadastropoo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOOParte2 {
    public static void main(String[] args) {
        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        Scanner sc = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("=================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=================================");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Finalizando programa...");
                    executando = false;
                    break;
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char tipoPessoaInserir = sc.next().toUpperCase().charAt(0);
                    if (tipoPessoaInserir == 'F') {
                        System.out.println("Digite o ID da Pessoa: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Insira os dados...");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();
                        System.out.println("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.println("Idade: ");
                        int idade = sc.nextInt();
                        repoPF.inserir(new PessoaFisica(id, nome, cpf, idade));

                    } else if (tipoPessoaInserir == 'J') {
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        System.out.println("Digite o ID da Pessoa: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Insira os dados...");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();
                        System.out.println("CNPJ: ");
                        String cnpj = sc.nextLine();
                        repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));
                    } else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char tipoPessoaAlterar = sc.next().toUpperCase().charAt(0);
                    if (tipoPessoaAlterar == 'F') {
                        System.out.println("Digite o ID da Pessoa: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        PessoaFisica pessoa = repoPF.obter(id);
                        if (pessoa != null) {
                            System.out.println("Dados atuais:");
                            System.out.println("Nome: " + pessoa.getNome());
                            System.out.println("CPF: " + pessoa.getCpf());
                            System.out.println("Idade: " + pessoa.getIdade());

                            System.out.println("Insira os novos dados:");
                            System.out.println("Nome: ");
                            String novoNome = sc.nextLine();
                            System.out.println("CPF: ");
                            String novoCpf = sc.nextLine();
                            System.out.println("Idade: ");
                            int novaIdade = sc.nextInt();

                            pessoa.setNome(novoNome);
                            pessoa.setCpf(novoCpf);
                            pessoa.setIdade(novaIdade);

                            repoPF.alterar(pessoa);
                        } 
                    } else if (tipoPessoaAlterar == 'J') {
                        System.out.println("Digite o ID da Pessoa: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        PessoaJuridica pessoa = repoPJ.obter(id);
                        if (pessoa != null) {
                            System.out.println("Dados atuais:");
                            System.out.println("Nome: " + pessoa.getNome());
                            System.out.println("CNPJ: " + pessoa.getCnpj());

                            System.out.println("Insira os novos dados:");
                            System.out.println("Nome: ");
                            String novoNome = sc.nextLine();
                            System.out.println("CNPJ: ");
                            String novoCnpj = sc.nextLine();

                            pessoa.setNome(novoNome);
                            pessoa.setCnpj(novoCnpj);

                            repoPJ.alterar(pessoa);

                        }
                    } else {
                        System.out.println("Erro: Escolha Invalida!");
                    }
                    break;

                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char tipoPessoaExcluir = sc.next().toUpperCase().charAt(0);

                    switch (tipoPessoaExcluir) {
                        case 'F':
                            System.out.println("Digite o ID da Pessoa: ");
                            int id = sc.nextInt();
                            PessoaFisica pessoaFisica = repoPF.obter(id);
                            if (pessoaFisica != null) {
                                repoPF.excluir(id);
                                System.out.println("Pessoa fisica excluida com sucesso!");
                            } else {
                                System.out.println("Pessoa fisica nao encontrada!");
                            }
                            break;
                        case 'J':
                            System.out.println("Digite o ID da Pessoa: ");
                            id = sc.nextInt();
                            PessoaJuridica pessoaJuridica = repoPJ.obter(id);
                            if (pessoaJuridica != null) {
                                repoPJ.excluir(id);
                                System.out.println("Pessoa juridica excluida com sucesso!");
                            } else {
                                System.out.println("Pessoa juridica nao encontrada!");
                            }
                            break;
                        default:
                            System.out.println("Erro: Escolha Invalida!");
                    }
                    break;

                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    char tipoPessoaObter = sc.next().toUpperCase().charAt(0);

                    switch (tipoPessoaObter) {
                        case 'F':
                            System.out.println("Digite o ID da pessoa fisica: ");
                            int id = sc.nextInt();
                            PessoaFisica pessoaFisica = repoPF.obter(id);
                            if (pessoaFisica == null) {
                                System.out.println("Pessoa fisica nao encontrada!");
                            } else {
                                System.out.println("Dados da pessoa fisica:");
                                System.out.println(pessoaFisica);
                            }
                            break;
                        case 'J':
                            System.out.println("Digite o ID da pessoa juridica: ");
                            id = sc.nextInt();
                            PessoaJuridica pessoaJuridica = repoPJ.obter(id);
                            if (pessoaJuridica == null) {
                                System.out.println("Pessoa juridica nao encontrada!");
                            } else {
                                System.out.println("Dados da pessoa juridica:");
                                System.out.println(pessoaJuridica);
                            }
                            break;
                        default:
                            System.out.println("Erro: Escolha invalida!");
                    }
                    break;
     
                case 5:
                    System.out.println("F - Pessoas Fisicas | J - Pessoas Juridicas");
                    char tipoPessoaObterTodos = sc.next().toUpperCase().charAt(0);

                    if (tipoPessoaObterTodos == 'F') {
                        System.out.println("Pessoas Fisicas:");
                        List<PessoaFisica> pessoasFisicas = repoPF.obterTodos();

                        if (pessoasFisicas.isEmpty()) {
                            System.out.println("Nao existem pessoas fisicas cadastradas no sistema.");
                        } else {
                            for (PessoaFisica pf : pessoasFisicas) {
                                System.out.println(pf.toString());
                            }
                        }
                    } else if (tipoPessoaObterTodos == 'J') {
                        System.out.println("Pessoas Juridicas:");
                        List<PessoaJuridica> pessoasJuridicas = repoPJ.obterTodos();

                        if (pessoasJuridicas.isEmpty()) {
                            System.out.println("Nao existem pessoas juridicas cadastradas no sistema.");
                        } else {
                            for (PessoaJuridica pj : pessoasJuridicas) {
                                System.out.println(pj.toString());
                            }
                        }
                    } else {
                        System.out.println("Erro: Escolha invalida!");
                    }
                    break;

                case 6:
                    System.out.println("Salvar Dados");
                    sc.nextLine();
                    System.out.print("Informe o prefixo dos arquivos: ");
                    String prefixo = sc.nextLine();

                    try {
                        repoPF.persistir(prefixo + ".fisica.bin");
                        repoPJ.persistir(prefixo + ".juridica.bin");
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
     
                case 7:
                    System.out.println("Recuperar Dados");
                    sc.nextLine();
                    System.out.print("Informe o prefixo dos arquivos: ");
                    String prefixoRec = sc.nextLine();

                    try {
                        repoPF.recuperar(prefixoRec + ".fisica.bin");
                        repoPJ.recuperar(prefixoRec + ".juridica.bin");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
    
                default:
                    System.out.println("Erro: Escolha invalida!");
            }
        }

        sc.close();
    }
}

