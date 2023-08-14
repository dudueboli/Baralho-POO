public class Carta {
    private Naipe naipe;
    private Valores valor;
    private boolean aberto; 

    Carta(Naipe naipe, Valores valor){
        this.naipe = naipe;
        this.valor = valor;
        this.aberto = true;

    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valores getValor() {
        return valor;
    }

    public boolean isAberto() {
        return aberto;
    }
    public void viraCarta(){
        aberto = !aberto;
    }
}
