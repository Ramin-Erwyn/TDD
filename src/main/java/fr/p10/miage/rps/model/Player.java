package fr.p10.miage.rps.model;
import java.util.ArrayList;
import java.util.Scanner.*;

public class Player{
    String name;
    int score;
    //ArrayList<Play>mouvement; //la colection de movvemetn
    ArrayList<Play> mouvement = new ArrayList<Play>();


// todo ListIterator<E> https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html à voir !!!!!

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.mouvement = mouvement;
        for (int i=0;i< this.nbMouvement();i++)
            this.mouvement.add(Play.generatePlay());
    }
// 10 ou 20
    private int nbMouvement(){
        return 20;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Play> getMovement(){
        return mouvement;
    }

    public int getScore() {
        return score;
    }

    public void setMovement(ArrayList<Play> movement) {
        this.mouvement = movement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //question 4
    public ArrayList<Play> getNextMove(){
        return hasNext();
       /* for(int i=0;i< mouvement.lenght;i++){
            return mouvement+1 ;
        }*/

    }
}
