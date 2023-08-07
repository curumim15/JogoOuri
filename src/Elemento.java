public class Elemento {
    //espaço pertencente a cada elemento
    Espaco espaco;
    //elemento seguinte da lista
    Elemento next;

    //-----------------------------------------CONSTRUTOR---------------------------------------------------------
    public Elemento(Espaco espaco) {
        this.espaco = espaco;
        next = null;
    }
}
