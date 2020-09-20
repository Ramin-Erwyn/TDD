package fr.p10.miage.rps.model;

import static fr.p10.miage.rps.model.Play.*;
import static org.testng.Assert.*;

import org.testng.annotations.*;

import static fr.p10.miage.rps.model.Player.*;

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
   @Parameters({"papier","pierre"})

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
    @Parameters({"pierre","pierre"})
    @Test
    public void testWinPlay(String p1, String p2) {
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Resultat.WIN);
    }

    @Parameters({"papier","papier"})
    @Test
    public void testTiePlay(String p1,String p2) {
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)),Resultat.TIE);
    }

    @Parameters({"papier","ciseau"})
    @Test
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)),Resultat.LOST);
    }
   /* nop @Parameters(p1 ,p2)
   // @Test
    public void testGenerator(String p1, String p2){
       assertEquals(rps.jeu(generatePlay.valueOf(p1),generatePlay.valueOf(p2)),Resultat.WIN);
    }*/

    @DataProvider
    public Object[][] getDataPlayWin() {
        return new Object[][]{
                {Play.PAPER, Play.ROCK},
                {Play.ROCK, Play.SCISSORS},
                {Play.SCISSORS, Play.PAPER}
        };
    }

    @DataProvider
    public Object[][] getDataPlayTie() {
        return new Object[][]{
                {Play.PAPER, Play.PAPER},
                {Play.ROCK, Play.ROCK},
                {Play.SCISSORS, Play.SCISSORS}
        };
    }

    @DataProvider
    public Object[][] getDataPlayLoose() {
        return new Object[][]{
                {Play.PAPER, Play.SCISSORS},
                {Play.ROCK, Play.PAPER},
                {Play.SCISSORS, Play.ROCK}
        };
    }

}