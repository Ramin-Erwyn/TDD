package fr.p10.miage.rps.model;

import static org.testng.Assert.*;

import org.testng.annotations.*;

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

    @Test ( dataProvider = "winData ")
    Object[][] testWinPlay ( Play p1 , Play p2 ) {
        Object[][] createWinData;
        return new Object[][]{{ p1}, {p2}};}


    @Test ( dataProvider = "TieData ")
    Object[][] testTiePlay ( Play p1 , Play p2 ){
        Object[ ][ ] createTieData;
        return new Object[][]{{ p1}, {p2}};}

    @Test ( dataProvider = "LostData ")
    Object[][] testLostPlay ( Play p1 , Play p2 ){
        Object [ ][ ] createLostData;
        return new Object[][]{{ p1}, {p2}};}

}