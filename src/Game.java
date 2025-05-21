
public class Game {
    // Array al più di 21 tiri (10 frame + bonus)
    public int[] rolls = new int[21];
    public int indexRoll = 0;

    public void roll(int pins){
        // Salvo il numero di birilli caduti nell'i-esimo lancio
        rolls[indexRoll++] = pins;
    }// roll

    public boolean isSpare(int indexRoll){
        // ritorno true se e solo se la somma dei pins tra l'i-esimo lancio e l'-esimo + 1 e' 10
        return rolls[indexRoll] + rolls[indexRoll + 1] == 10;
    }// isSpare

    public boolean isStrike(int indexRoll){
        // ritorno true se e solo se il numero dei pins tra dell'i-esimo lancio e' 10
        return rolls[indexRoll] == 10;
    }// isStrike

    public int score() {
        int totScore = 0;
        int frameScore;
        int nextFramePointer = 0;

        /*
            Per ogni frame valuto in quale caso sono.
            Mi aiuto con nextFramePointer tenendo traccia di volta in volta dove inizierà il frame successivo.
         */
        for (int i = 0; i < 10; i++) {

            if (isStrike(nextFramePointer)) {
                frameScore = 10 + rolls[nextFramePointer + 1] + rolls[nextFramePointer + 2]; //somma birilli del frame + bonus due tiri successivi
                totScore = totScore + frameScore;
                // Vado al prossimo frame
                nextFramePointer++;
            }else if (isSpare(nextFramePointer)) {
                frameScore = rolls[nextFramePointer] + rolls[nextFramePointer + 1] + rolls[nextFramePointer + 2]; //somma birilli del frame + bonus un tiro successivo
                totScore = totScore + frameScore;
                // Vado al prossimo frame
                nextFramePointer+=2;
            } else {
                frameScore = rolls[nextFramePointer] + rolls[nextFramePointer + 1]; //somma birilli + bonus
                totScore = totScore + frameScore;
                // Vado al prossimo frame
                nextFramePointer+=2;
            }// if - else
        }// for

        return totScore;
    }// score
}// Game
