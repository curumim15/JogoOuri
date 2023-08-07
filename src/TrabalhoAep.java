import java.util.Scanner;

public class TrabalhoAep {


    //Scanner para a escolha de peças
    static Scanner ler = new Scanner(System.in);
    //int onde é guardado a opção do scanner
    static int opcao;
    //boolean que mantem o ciclo das jogadas
    static boolean h = true;
    //Criação da lista onde estão posicionadas os espaços do tabuleiro e a pontuacao dos jogadores
    static Lista novojogo;

    //-------------------------------MAIN-----------------------------------
    public static void main(String[] args) {
        novojogo = new Lista();
        while (h == true) {
            jogadas("JOGADOR 1", "jog1");
            jogadas("JOGADOR 2", "jog2");
        }

    }

    //-----------------------------------------METODOS----------------------------------
    //Funcao que percorre a jogada do jogador 1 e 2
    public static void jogadas(String jogador, String jog) {

        System.out.println("Novo jogo");
        System.out.println("Sair");

        Elemento aux = null;
        novojogo.tabuleiro();
        System.out.println(jogador);
        System.out.println("Escolha a posicao que quer mover");
        System.out.println("Escolha entre 1 a 6");

        do {
            opcao = ler.nextInt();
            //Funcao que retorna o espaço que o jogaddor quer jogar
            aux = novojogo.percorrelistanum(opcao, jog);


            //Verificar se o jogador escolheu entre 1 e 12
            if (aux == null) {
                System.out.println("Nao pode jogar, posicao inserida errada, insira outra posicao");
            }
            //Verificar se o jogador escolheu uma posicao que contenha peças
            else if (aux.espaco.num_pecas == 0) {
                System.out.println("Nao pode jogar, não tem peças, insira outra posicao");
            }
        } while (aux == null || aux.espaco.num_pecas == 0);
        //Funcão que move as peças de acordo com a peça escolhida (aux)
        novojogo.movepecas(aux, jog);

        System.out.println("JOGADA FEITA");
        //Verifica no final da jogada se cada jogador ganhou
        verificaVitoria();

    }
    //Verifica se a pontuacao de cada jogador é maior ou igual a 25
    public static void verificaVitoria() {

        if (novojogo.j1pontuacao >= 25) {
            h = false;
            System.out.println("Jogador 1 ganhou !!!");
        }
        if (novojogo.j2pontuacao >= 25) {
            h = false;
            System.out.println("Jogador 2 ganhou !!!");
        }
    }
}
