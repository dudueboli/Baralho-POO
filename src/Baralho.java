public class Baralho {
    private Deck cartas;

    public Baralho(){
        cartas = new Deck();
        for(Naipe naipe : Naipe.values()){
            for(Valor valor : Valor.values()){
                Carta carta = new Carta(naipe, valor);
                cartas.insere(carta);
            }
        }
    }

    public Carta retiraDeCima(){
        return cartas.remove();
    }

    public void embaralha(){
        cartas.embaralha();
    }

    public int quantCartas(){
        return cartas.quantCartas();
    }

    public boolean vazio(){
        return cartas.vazio();
    }


}
