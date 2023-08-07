public class Espaco {

    //string que define a que jogador pertence o espaço
    String jogador;
    //id da posicao do espaco
    int pos;
    //numero de peças que o espaco contem
    int num_pecas;

    //-----------------------------------------CONSTRUTOR---------------------------------------------------------
    public Espaco(String jogador, int pos, int num_pecas) {

        this.jogador = jogador;
        this.pos = pos;
        this.num_pecas = num_pecas;

    }


    //toString da classe (não utilizado)
    @Override
    public String toString() {
        return "Espaco{" + "jogador=" + jogador + ", pos=" + pos + ", num_pecas=" + num_pecas + '}';
    }
}
