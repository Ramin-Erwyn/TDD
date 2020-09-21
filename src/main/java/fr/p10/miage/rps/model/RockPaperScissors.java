package fr.p10.miage.rps.model;
import java.util.ArrayList;

public class RockPaperScissors{
    //constructeur par default
    public RockPaperScissors(){
    }
    //question 1
    //Resultat play(Play p1, Play p2){
    //    return Resultat.LOST; tt les cas apres play
    //}
    Resultat play(Play p1, Play p2) { // les solus win sauf tie les else perdu  j1 contre j2
        if (p1 == p2) {
            return Resultat.TIE;
        }
        if ((p1 == Play.PAPER) && (p2 == Play.ROCK)) {
            return Resultat.WIN;
        }
        if ((p1 == Play.ROCK) && (p2 == Play.SCISSORS)) {
            return Resultat.WIN;
        }
        if ((p1 == Play.SCISSORS) && (p2 == Play.PAPER)) {
            return Resultat.WIN;
        }
        return Resultat.LOST;
    }


    Resultat jeu(Player p1, Player p2) {
        //p1 j1 ArrayList
        Play mouvementP1 = p1.getNextMove(); // dans player hasNext()
        Play mouvementP2 = p2.getNextMove();


        // le jeu
        while ((mouvementP1 != null) && (mouvementP2 != null)) {
            Resultat res = play(mouvementP1, mouvementP2);
            if (res == Resultat.WIN) {
                p1.setScore(p1.getScore() + 1);
            } else if (res == Resultat.LOST) {
                p2.setScore(p2.getScore() + 1);
            } else {
                p1.setScore(p1.getScore() + 1);//q6
                p2.setScore(p2.getScore() + 1);
            }
            mouvementP1 = p1.getNextMove();
            mouvementP2 = p2.getNextMove();
        }
        //les compte pour le sxore entre P1 et P2

        if (p1.getScore() == p2.getScore())
            return Resultat.TIE;
        if (p1.getScore() < p2.getScore())
            return Resultat.LOST;
        return Resultat.WIN;


    }// fin de la verif score
}
