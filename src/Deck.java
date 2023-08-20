import java.util.Random;

public class Deck {
    public final int tamanho = 104;
    private Random r;
    private Carta[] cartas;
    private int proxLivre;

    public Deck(){
        cartas = new Carta[tamanho];
        proxLivre = 0;
        r = new Random();
    }
    public boolean insere(Carta carta){
        if(proxLivre < tamanho - 1){
            cartas[proxLivre] = carta;
            if(carta.isAberto()){
                carta.viraCarta();
            }
            proxLivre++;
            return true;
        }
        return false;
    }
    public boolean insereNaPosicao(int posicao, Carta carta) {
        if (proxLivre < tamanho - 1 && posicao >= 0 && posicao <= proxLivre) {
            for (int i = proxLivre; i > posicao; i--) {
                cartas[i] = cartas[i - 1];
            }
            cartas[posicao] = carta;
            if (carta.isAberto()) {
                carta.viraCarta();
            }
            proxLivre++;
            return true;
        }
        return false;
    }
    public Carta remove(){
        if(proxLivre == 0){
            return null;
        }
        Carta deCima = cartas[0];
        for(int i=0; i < proxLivre - 1; i++){
            cartas[i] = cartas[i + 1];
        }
        proxLivre--;
        return deCima;
    }
    public int quantCartas(){
        return proxLivre;
    }
    public boolean vazio(){
        return quantCartas() == 0;
    }
    void embaralha(){
        int vezes = 2000;
        while(vezes > 0){
            int p1 = r.nextInt(quantCartas());
            int p2 = r.nextInt(quantCartas());
            Carta aux = cartas[p1];
            cartas[p1] = cartas[p2];
            cartas[p2] = aux;
            vezes--;
        }
    }
}
