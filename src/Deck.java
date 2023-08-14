public class Deck {
    public final int tamanho = 104;
    private Carta[] cartas;
    private int proxLivre;

    public Deck(){
        cartas = new Carta[tamanho];
        proxLivre = 0;
    }
    public boolean insere(Carta carta){
        if(proxLivre < tamanho - 1){
            cartas[proxLivre] = carta;
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
            cartas[i] = cartas[1 + i];
        }
    }
    public int quantCartas(){
        return proxLivre;
    }
}
