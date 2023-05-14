package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Aeronave;
import classes.Pessoa;
import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        String cpf;//para a opção 3
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                Piloto piloto = new Piloto();
                System.out.println("Nome do piloto: ");
                piloto.setNome(in.next());
                System.out.println("CPF do piloto: ");
                piloto.setCpf(in.next());
                System.out.println("Breve do piloto: ");
                piloto.setBreve(in.next());
                
                System.out.println("\nPiloto cadastrado com sucesso.");

                pilotos[qtdCadastrados]=piloto;
                qtdCadastrados++;

                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                } else{
                    for (Piloto piloto : pilotos) {
                        System.out.println(piloto);
                    }
                }
                // Exiba os pilotos aqui
                voltarMenu(in);
                continue;

            } else if (opcao == 3) {
                Boolean achou=false;//proteção para verificar se o CPF existe
                System.out.println("Digite o CPF do piloto que deseja pesquisar: ");
                cpf=in.next();
                for (Piloto piloto : pilotos) {
                    if(piloto!=null && cpf.equals(piloto.getCpf())){ // para String não pode usar == e sim .equals
                        System.out.println(piloto);
                        in.next();
                        achou=true;
                    }  
                }if(!achou){
                    System.out.println("CPF do piloto não encontrado!");
                    in.next();
                }
            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("Sem pilotos, não há como cadastrar uma aeronave\n");
                    in.next();
                    continue;
                } else{
                     Aeronave aeronave = new Aeronave();
                     Boolean achou=false;//proteção para verificar se o CPF existe
                    System.out.println("Digite o CPF do piloto ");
                    cpf=in.next();
                    for (Piloto piloto : pilotos) {
                        if(piloto!=null && cpf.equals(piloto.getCpf())){ // para String não pode usar == e sim .equals
                            System.out.println("Digite o modelo da aeronave: ");
                             aeronave.setModelo(in.next());
                             System.out.println("Digite o número de série da aeronave: ");
                             aeronave.setNumeroSerie(in.next());
                              System.out.println("\nAeronave cadastrada com sucesso.");
                             System.out.println(aeronave);
                             achou=true;
                             in.next();
                             voltarMenu(in);
                             continue;
       }   
      }
      
      if(!achou){
        System.out.println("CPF do piloto não encontrado!");      
    }     
        }
        in.next();
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}