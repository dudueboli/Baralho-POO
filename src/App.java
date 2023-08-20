import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do Jogador 1:");
        String nomeJogador1 = scanner.nextLine();
        System.out.println("Nome do Jogador 2:");
        String nomeJogador2 = scanner.nextLine();
        
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
        Random random = new Random();
        Carta[] acumulado = new Carta[jogador1.quantCartas() + jogador2.quantCartas()];
        int tamanhoAcumulado = 0;
        while(!acabou){
            if (jogador1.vazio() || jogador2.vazio()) {
                acabou = true;
                break;
            }
            
            Carta cj1 = jogador1.remove();
            Carta cj2 = jogador2.remove();
            System.out.println("Rodada: " + rodada);
            System.out.println("Carta do jogador 1: " + cj1.toString());
            System.out.println("Carta do jogador 2: " + cj2.toString());

            if (cj1.Bigger(cj2)) {
                if (tamanhoAcumulado > 0) {
                    insereCartasAleatoriamente(jogador1, acumulado, tamanhoAcumulado, random);
                    insereCartasAleatoriamente(jogador1, new Carta[]{cj2, cj1}, random);
                    System.out.println("Jogador 1 ganhou a rodada após empate");
                    tamanhoAcumulado = 0;
                } else {
                    insereCartasAleatoriamente(jogador1, new Carta[]{cj2, cj1}, random);
                    System.out.println("Jogador 1 ganhou a rodada");
                }
            } else if (cj2.Bigger(cj1)) {
                if (tamanhoAcumulado > 0) {
                    insereCartasAleatoriamente(jogador2, acumulado, tamanhoAcumulado, random);
                    insereCartasAleatoriamente(jogador2, new Carta[]{cj2, cj1}, random);
                    System.out.println("Jogador 2 ganhou a rodada após empate");
                    tamanhoAcumulado = 0;
                } else {
                    insereCartasAleatoriamente(jogador2, new Carta[]{cj2, cj1}, random);
                    System.out.println("Jogador 2 ganhou a rodada");
                }
            } else { // Empate
                System.out.println("Empate! As cartas serão acumuladas para a próxima rodada.");
                acumulado[tamanhoAcumulado++] = cj1;
                acumulado[tamanhoAcumulado++] = cj2;
            }
            rodada++;
        }

        if (jogador1.vazio()) {
            System.out.println("Jogador " + nomeJogador2 + " é o vencedor!");
        } else {
            System.out.println("Jogador " + nomeJogador1 + " é o vencedor!");
        }

        System.out.println("FIM");
        scanner.close();
            
    }
    private static void insereCartasAleatoriamente(Deck deck, Carta[] cartas, Random random) {
        int numCartas = cartas.length;
        for (int i = 0; i < numCartas; i++) {
            int posAleatoria = random.nextInt(deck.quantCartas() + 1); // +1 para permitir inserção no final
            deck.insereNaPosicao(posAleatoria, cartas[i]);
        }
    }
    private static void insereCartasAleatoriamente(Deck deck, Carta[] cartas, int tamanho, Random random) {
        for (int i = 0; i < tamanho; i++) {
            int posAleatoria = random.nextInt(deck.quantCartas() + 1); // +1 para permitir inserção no final
            deck.insereNaPosicao(posAleatoria, cartas[i]);
        }
    }

}




