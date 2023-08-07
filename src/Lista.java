public class Lista {

    //Primeiro elemento da lista
    Elemento inicio;
    //Pontuação do jogaddor 1 e 2;
    int j1pontuacao;
    int j2pontuacao;
    //Elemento aux para preenchimento da lista
    Elemento aux;

    //-----------------------------------------CONSTRUTOR---------------------------------------------------------
    public Lista() {
        //Preencher primeiro elemento
        inicio = new Elemento(new Espaco("jog1", 1, 4));
        aux = inicio;
        //Preencher lista de 12 elementos (o primeiro elemento ja foi preenchido)
        for (int i = 2; i <= 12; i++) {
            //Elementos do jogador 1
            if (i <= 6) {
                Elemento novo = new Elemento(new Espaco("jog1", i, 4)); //Espacos 1 a 6
                aux.next = novo;
                aux = aux.next;
                //Elementos do jogador 2
            } else {
                Elemento novo = new Elemento(new Espaco("jog2", i - 6, 4)); //Espacos 1 a 6
                aux.next = novo;
                aux = aux.next;
                //ligação do ultimo elemento com o primeiro para Lista circular
                if (i == 12) {
                    novo.next = inicio;
                }
            }

        }

        j1pontuacao = 0;
        j2pontuacao = 0;
    }

    //-----------------------------------------METODOS---------------------------------------------------------
    //funcao que percorre lista e encontra o elemento com o numero que o jogador introduziu
    public Elemento percorrelistanum(int pos, String jogador) {
        Elemento aux = inicio;

        /*devido a ser uma lista circular para percorrer é necessario comecar no primeiro elemento e
        e saltar para o prox elemento até retornar ao elemento inicio, para nao saltar fora do while
        no primeiro ciclo´é utilizado um do while*/
        do {
            //comparação entre o numero inserido e a posicão do jogador
            if (aux.espaco.pos == pos && aux.espaco.jogador.compareTo(jogador) == 0) {
                return aux;
            }
            aux = aux.next;
        } while (aux != inicio);
        //retorno nulo caso o elemento nao exista
        return null;
    }

    //funcao que move as peças do elemento recebido como argumento
    public void movepecas(Elemento aux1, String jogador) {
        //aux1 - elemento retornado do metodo percorrelistanum
        Elemento aux = aux1;
        //for que move uma peça para cada espaço asseguir ao aux
        for (int contador = aux.espaco.num_pecas; contador > 0; contador--) {
            aux = aux.next;
            //Caso a ultima peça caia num espaço com 1 ou 2 peças do jogador adversario sao adicionadas á pontuaçao do jogador
            if (contador == 1) {
                if (aux.espaco.num_pecas == 1 || aux.espaco.num_pecas == 2) {
                    if (aux.espaco.jogador.compareTo(jogador) != 0) {
                        j1pontuacao += aux.espaco.num_pecas + 1;
                        aux.espaco.num_pecas = -1;
                    }
                }
            }
            //adicao de cada peça
            aux.espaco.num_pecas++;
        }
        //retira peças do espaço escolhido
        aux1.espaco.num_pecas = 0;

    }

    //metodo que imprime o tabuleiro
    public void tabuleiro() {
        //JOGADOR 2
        Elemento aux = inicio;
        System.out.println("\n\n\n\nPontuacao Jogador 2 - " + j2pontuacao);
        //funcao que imprime as posicoes do jog2
        printrecursivoPOS(inicio.next);
        System.out.print(" | ");
        System.out.println("\n------------------------");
        //funcao que imprime as pontuacoes do jog2
        printrecursivoNUM(inicio.next);

        System.out.print(" | ");
        System.out.println("\n------------------------");
        //JOGADOR 1
        System.out.println("Pontuacao Jogador 1 - " + j1pontuacao);
        do {
            if (aux.espaco.jogador == "jog1") {
                System.out.print(" | " + aux.espaco.pos);
            }
            aux = aux.next;
        } while (aux != inicio);
        aux = inicio;
        System.out.print(" | ");
        System.out.println("\n------------------------");
        do {
            if (aux.espaco.jogador == "jog1") {
                System.out.print(" | " + aux.espaco.num_pecas);
            }
            aux = aux.next;
        } while (aux != inicio);
        System.out.print(" | ");
        System.out.println("\n------------------------\n\n\n\n");
    }



    /*como as posicoes/peças do jogador 2 sao imprimidas direita para a esquerda
    foi necessario implementar recursivamente o print em pós-ordem */

    //funcao que imprime as posicoes do jog2 em pós-ordem
    private void printrecursivoPOS(Elemento aux) {
        //sai no final da lista
        if (aux == inicio) {
            return;
        }
        //chamada da funcao recursivamente
        printrecursivoPOS(aux.next);
        //verifica se a peça é do jogador2
        if (aux.espaco.jogador == "jog2") {
            System.out.print(" | " + aux.espaco.pos);
        }
    }
    //funcao que imprime as peças do jog2  em pós-ordem
    private void printrecursivoNUM(Elemento aux) {
        //sai no final da lista
        if (aux == inicio) {
            return;
        }
        //chamada da funcao recursivamente
        printrecursivoNUM(aux.next);
        //verifica se a peça é do jogador2
        if (aux.espaco.jogador == "jog2") {
            System.out.print(" | " + aux.espaco.num_pecas);
        }
    }
}
