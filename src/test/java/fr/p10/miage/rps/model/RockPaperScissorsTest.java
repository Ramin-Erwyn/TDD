package fr.p10.miage.rps.model;

import static fr.p10.miage.rps.model.Play.*;
import static org.testng.Assert.*;

import org.testng.annotations.*;

import static fr.p10.miage.rps.model.Player.*;

public class RockPaperScissorsTest {

    RockPaperScissors  rps ;
    Player plg;

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

   @Test(dataProvider = "winData" )
   public void testWinPlay(Play p1, Play p2) {
       assertEquals(rps.play(p1,p2), Resultat.WIN);
   }

    @Test(dataProvider = "LostData" )
    public void testLostPlay(Play p1, Play p2) {
        assertEquals(rps.play(p1,p2), Resultat.WIN);
    }

    @Test(dataProvider = "winData" )
    public void testTiePlay(Play p1, Play p2) {
        assertEquals(rps.play(p1,p2), Resultat.WIN);
    }

    /* @Test(dataProvider = "Playerwin")
    public void testPlayerWin(Player p1,Player p2){
       assertEquals();
    }
    @Test(dataProvider = "Playertie")
    public void testPlayertie(Player p1,Player p2){
        assertEquals();
    } @Test(dataProvider = "Playerlost")
    public void testPlayerlost(Player p1,Player p2){
        assertEquals();
    }
*/

    @DataProvider(name = "winData")
    public Object[][] getDataPlayWin() {
        return new Object[][]{
                {Play.PAPER, Play.ROCK},
                {Play.ROCK, Play.SCISSORS},
                {Play.SCISSORS, Play.PAPER}
        };
    }

    @DataProvider( name = "tieData")
    public Object[][] getDataPlayTie() {
        return new Object[][]{
                {Play.PAPER, Play.PAPER},
                {Play.ROCK, Play.ROCK},
                {Play.SCISSORS, Play.SCISSORS}
        };
    }

    @DataProvider(name = "lostData")
    public Object[][] getDataPlayLost() {
        return new Object[][]{
                {Play.PAPER, Play.SCISSORS},
                {Play.ROCK, Play.PAPER},
                {Play.SCISSORS, Play.ROCK}
        };
    }

}