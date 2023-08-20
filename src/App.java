public class App {
    public static void main(String[] args) throws Exception {
        Baralho p = new Baralho();
        p.embaralha();
        Deck jogador1 = new Deck();
        Deck jogador2 = new Deck();

        while(!p.vazio()){
            jogador1.insere(p.retiraDeCima());
            jogador2.insere(p.retiraDeCima());

        }

        boolean acabou = false;
        int rodada = 1;
        while(!acabou){
            Carta cj1 = jogador1.remove();
            Carta cj2 = jogador2.remove();
            System.out.println("Rodada: " + rodada);
            System.out.println("Carta do jogador 1: " + cj1.toString());
            System.out.println("Carta do jogador 2: " + cj2.toString());

            if(cj1.Bigger(cj2)){
                jogador1.insere(cj2);
                jogador1.insere(cj1);
                System.out.println("Jogador 1 ganhou a rodada");
            }else{
                jogador1.insere(cj2);
                jogador1.insere(cj1);
                System.out.println("Jogador 2 ganhou a rodada");
            }

            if (jogador1.vazio() || jogador2.vazio()){
                acabou = true;
            }
            rodada++;
        }
        System.out.println("FIM");

    }
}
