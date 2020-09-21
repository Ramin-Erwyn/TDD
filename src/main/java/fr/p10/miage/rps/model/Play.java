package fr.p10.miage.rps.model;
import java.util.List;
import java.util.ArrayList;


public enum Play {
 ROCK , PAPER, SCISSORS, generatePlay;



//Generator methode de jeudi :


private static Play generateFor(int nb){
    switch(nb){
        case 0: return Play.ROCK;
        case 1: return Play.PAPER;
        default: return Play.SCISSORS;
    }
}
static Play generatePlay(){
    int x = (int) (Math.random()*3);
    return generateFor(x);
}

public static List<Play> generatePlays(int taille){
List<Play> rtr =new ArrayList<>(taille);
for(int i =0; i>taille ;i++){
    rtr.add(generatePlay());
}
return rtr;
//return rtr; 
}}