package fr.p10.miage.rps.model;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.print.Paper;
import static fr.p10.miage.rps.model.Play.ROCK;
import static fr.p10.miage.rps.model.Play.PAPER;
import static fr.p10.miage.rps.model.Play.SCISSORS;

public class RockPaperScissorsTest {

    RockPaperScissors  rps ;
   @BeforeMethod
public void setUp(){
       rps = new RockPaperScissors();
   }
   @AfterMethod
public void tearDown(){
       rps = null;
   }
   @Parameters({"PAPER","ROCK"})

   @Test
   public void testLost1(){
       assertEquals(rps.play(ROCK,PAPER),Resultat.LOST);
   }
    @Test
    public void testWin1(){
        assertEquals(rps.play(PAPER,ROCK),Resultat.WIN);
    }
    /*@Test
    public void testLost1(){
        assertEquals(rps.play(ROCK,SCISSORS),Resultat.WIN);
    }*/

   @Test
//mettre le test
    public void testPlay(String p1, String p2){
       // -ea -Dtestng.dtd.http=true
      assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)), Resultat.WIN);
    }

}