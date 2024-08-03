package Utility;

import Entity.Bomb.Bomb;
import Entity.Bomb.Ledakan;
import Entity.Character.Character;
import Entity.Character.Skill.Skill;
import Entity.Item.Item;
import Entity.Map.Box;
import Entity.Player.ControllerPlayer;
import Entity.Player.Player;
import GameScreen.ControllerScreen;
import GameScreen.PlayScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;

import java.awt.font.FontRenderContext;
import java.security.Key;

public class Update {

   ControllerPlayer player;
   MapGame map;
   Bomb bomb;
   HitBox hitBox;
   Music music;

   public Update(ControllerPlayer player, MapGame map) {
       this.player = player;
       this.map = map;
   }

   public void update(float delta){
       map.update(delta);
       updateBomb();
       checkPlayer();
       checkBomb();
       updateExplosion();
       updatePlayer(delta);
       claimItem();
       positionPlayer();
       checkEndGame();
   }

   public void positionPlayer(){
       for (int i=0; i< player.getJumlahPlayer();i++){
           if (player.getPergerakanBefore(i)=="up"){
               if (player.isUp(i)){

               } else {
                   if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)>=map.getyPosition(player.getI(i), player.getJ(i) )){
                       player.setY(i, player.getYPositionPlayer(i)- ((player.getYPositionPlayer(i)+ player.getHeightPlayer(i))-(map.getyPosition(player.getI(i), player.getJ(i))+map.heightTile)));
                   }
               }
           } else if (player.getPergerakanBefore(i)=="down") {
               if (player.isDown(i)){

               } else {
                   if (player.getYPositionPlayer(i)<=map.getyPosition(player.getI(i), player.getJ(i) )+map.heightTile){
                       player.setY(i, player.getYPositionPlayer(i)+(map.getyPosition(player.getI(i), player.getJ(i))-player.getYPositionPlayer(i)));
                   }
               }
           } else if (player.getPergerakanBefore(i)=="left") {
               if (player.isLeft(i)){

               } else if (player.getXPositionPlayer(i)<=map.getxPosition(player.getI(i), player.getJ(i) )+map.widthTile){
                   player.setX(i,map.getxPosition(player.getI(i), player.getJ(i)));
               }
           } else if (player.getPergerakanBefore(i)=="right") {
               if (player.isRight(i)){

               } else {
                   if (player.getXPositionPlayer(i)+ player.getWidthPlayer(i)>=map.getxPosition(player.getI(i), player.getJ(i) )){
                       player.setX(i,map.getxPosition(player.getI(i), player.getJ(i))+map.widthTile- player.getWidthPlayer(i));
                   }
               }
           }


       }
   }

   public void updatePlayer(float delta){
       for (int i=0; i<player.getJumlahPlayer(); i++){
           if (player.isAlive(i)) {
               player.update(i, map, delta);
           }
       }
   }

   public void checkEndGame(){
       int playerRemain = 0;
       int playerNumber= 0;

       for (int i=0; i< player.getJumlahPlayer(); i++){
           if (player.isAlive(i)) {
               playerRemain++;
           }
       }

       if (playerRemain==1){
           for (int i=0; i< player.getJumlahPlayer(); i++){
               System.out.println(i);
               if (player.isAlive(i)) {
                   System.out.println(i);
                   ControllerScreen.playerWin = i+1;
                   ControllerScreen.win = true;
                   ControllerScreen.play = false;
                   PlayScreen.music.dispose();
               }
           }
       } else if (playerRemain==0) {
           
       }
   }

   public void checkBomb(){
       for (int i=0; i<map.bombsMeledak.size(); i++){
           Bomb bomb1=map.getBombsMeledak();
           player.setCapacityBomb(bomb1.getPlayer(), player.getCapacityBomb(bomb1.getPlayer())+1);
       }
   }

   public void checkPlayer(){
       for (int i=0; i<player.getJumlahPlayer(); i++){
           if (player.getPergerakan(i)=="up"){
               if (player.getI(i)!=map.tinggiMap-1) {

                   if (player.getXPositionPlayer(i) >= map.getxPosition(player.getI(i), player.getJ(i)) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) <= map.getxPosition(player.getI(i), player.getJ(i)) + map.widthTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                           player.setUp(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) + 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else {
                               player.setUp(true, i);
                           }
                       }
                   } else if (player.getJ(i) == 0) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) + 1, player.getJ(i) + 1)) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else if (map.isBox(player.getI(i) + 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else {
                               player.setUp(true, i);
                           }
                       }
                   } else if (player.getJ(i) == map.getPanjangMap() - 1) {
                       if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else if (map.isBox(player.getI(i) + 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else {
                               player.setUp(true, i);
                           }
                       }
                   } else if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) - 1) && player.getXPositionPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) - 1) + map.getWidthTile()) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) - 1)) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) + 1, player.getJ(i) - 1)) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else if (map.isBox(player.getI(i) + 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else {
                               player.setUp(true, i);
                           }
                       }
                   } else if (player.getXPositionPlayer(i) + player.getWidthPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) + 1) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) + 1) + map.getWidthTile()) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                               player.setUp(true, i);
                           } else {
                               player.setUp(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) + 1, player.getJ(i) + 1)) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else if (map.isBox(player.getI(i) + 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)+ player.getHeightPlayer(i)<map.getyPosition(player.getI(i),player.getJ(i))+map.heightTile){
                                   player.setUp(true, i);
                               } else {
                                   player.setUp(false, i);
                               }
                           } else {
                               player.setUp(true, i);
                           }
                       }
                   }
               } else {
                   if (player.getYPositionPlayer(i)+player.getHeightPlayer(i)<map.getyPosition(map.tinggiMap-1,map.panjangMap-1)+map.heightTile){
                       player.setUp(true,i);
                   } else {
                       player.setUp(false,i);
                   }
               }
           } else if (player.getPergerakan(i) == "down") {
               if (player.getI(i) != 0) {
                   if (player.getXPositionPlayer(i) >= map.getxPosition(player.getI(i), player.getJ(i)) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) <= map.getxPosition(player.getI(i), player.getJ(i)) + map.widthTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) - 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else {
                               player.setDown(true, i);
                           }
                       }
                   } else if (player.getJ(i) == map.panjangMap - 1) {
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) - 1, player.getJ(i) - 1)) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else if (map.isBox(player.getI(i) - 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else {
                               player.setDown(true, i);
                           }
                       }
                   } else if (player.getJ(i) == 0) {
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) - 1, player.getJ(i) + 1)) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else if (map.isBox(player.getI(i) - 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else {
                               player.setDown(true, i);
                           }
                       }
                   } else if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) - 1) && player.getXPositionPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) - 1) + map.getWidthTile()) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) - 1, player.getJ(i) - 1)) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else if (map.isBox(player.getI(i) - 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else {
                               player.setDown(true, i);
                           }
                       }
                   } else if (player.getXPositionPlayer(i) + player.getWidthPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) + 1) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) + 1) + map.getWidthTile()) {
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                               player.setDown(true, i);
                           } else {
                               player.setDown(false, i);
                           }
                       } else {
                           if (map.isBox(player.getI(i) - 1, player.getJ(i) + 1)) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else if (map.isBox(player.getI(i) - 1, player.getJ(i))) {
                               if (player.getYPositionPlayer(i)>map.getyPosition(player.getI(i),player.getJ(i))){
                                   player.setDown(true, i);
                               } else {
                                   player.setDown(false, i);
                               }
                           } else {
                               player.setDown(true, i);
                           }
                       }
                   }

               } else {
                   if (player.getYPositionPlayer(i)>map.getyPosition(0,0)){
                       player.setDown(true,i);
                   } else {
                       player.setDown(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="right"){
               if (player.getJ(i)!=map.panjangMap-1) {

                       if (player.getYPositionPlayer(i) >= map.getyPosition(player.getI(i), player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) <= map.getyPosition(player.getI(i), player.getJ(i)) + map.heightTile) {
                           //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                           if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i), player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else {
                                   player.setRight(true, i);
                               }
                           }
                       } else if (player.getI(i) == 0) {
                           if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) + 1, player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else {
                                   player.setRight(true, i);
                               }
                           }
                       } else if (player.getI(i) == map.tinggiMap - 1) {
                           if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i), player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else if (map.isBox(player.getI(i) - 1, player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else {
                                   player.setRight(true, i);
                               }
                           }
                       } else if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i) - 1, player.getJ(i)) && player.getYPositionPlayer(i) < map.getyPosition(player.getI(i) - 1, player.getJ(i)) + map.heightTile) {
                           //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                           if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) - 1, player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else {
                                   player.setRight(true, i);
                               }
                           }
                       } else if (player.getYPositionPlayer(i) + player.getHeightPlayer(i) > map.getyPosition(player.getI(i) + 1, player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i) + 1, player.getJ(i)) + map.heightTile) {
                           if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                               if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                   player.setRight(true,i);
                               } else {
                                   player.setRight(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) + 1, player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) + 1)) {
                                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(player.getI(i),player.getJ(i))+map.widthTile){
                                       player.setRight(true,i);
                                   } else {
                                       player.setRight(false, i);
                                   }
                               } else {
                                   player.setRight(true, i);
                               }
                           }
                       }

               } else {
                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(map.tinggiMap-1,map.panjangMap-1)+map.widthTile){
                       player.setRight(true,i);
                   } else {
                       player.setRight(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="left"){
               if (player.getJ(i)!=0) {
                       if (player.getYPositionPlayer(i) >= map.getyPosition(player.getI(i), player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) <= map.getyPosition(player.getI(i), player.getJ(i)) + map.heightTile) {
                           //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                           if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else {
                                   player.setLeft(true, i);
                               }
                           }
                       } else if (player.getI(i) == map.tinggiMap - 1) {
                           if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) - 1, player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else {
                                   player.setLeft(true, i);
                               }
                           }
                       } else if (player.getI(i) == 0) {
                           if (map.isWall(player.getI(i) + 1, player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) + 1, player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else {
                                   player.setLeft(true, i);
                               }
                           }
                       } else if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i) - 1, player.getJ(i)) && player.getYPositionPlayer(i) < map.getyPosition(player.getI(i) - 1, player.getJ(i)) + map.heightTile) {
                           //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                           if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) - 1, player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else {
                                   player.setLeft(true, i);
                               }
                           }
                       } else if (player.getYPositionPlayer(i) + player.getHeightPlayer(i) > map.getyPosition(player.getI(i) + 1, player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i) + 1, player.getJ(i)) + map.heightTile) {
                           if (map.isWall(player.getI(i) + 1, player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                               if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                   player.setLeft(true,i);
                               } else {
                                   player.setLeft(false, i);
                               }
                           } else {
                               if (map.isBox(player.getI(i) + 1, player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else if (map.isBox(player.getI(i), player.getJ(i) - 1)) {
                                   if (player.getXPositionPlayer(i)>map.getxPosition(player.getI(i),player.getJ(i))){
                                       player.setLeft(true,i);
                                   } else {
                                       player.setLeft(false, i);
                                   }
                               } else {
                                   player.setLeft(true, i);
                               }
                           }
                       }

               } else {
                   if (player.getXPositionPlayer(i)>map.getxPosition(0,0)){
                       player.setLeft(true,i);
                   } else {
                       player.setLeft(false,i);
                   }
               }
           }
       }
   }

   public void updateBomb(){
       for (int i=0; i<player.getJumlahPlayer(); i++){
           if (player.getIsBomb(i)){
               bomb= player.getBomb(i);
               float centerX= map.getxPosition(player.getI(i),player.getJ(i))+((map.widthTile-bomb.getWidth())/2);
               float centerY= map.getyPosition(player.getI(i),player.getJ(i))+((map.heightTile-bomb.getHeight())/2);
               int rangeExplosion= player.getRangeExplosion(i);
               int playerNumber=i;
               int l= bomb.getI();
               int j= bomb.getJ();
               Bomb bomb1= new Bomb(centerX, centerY,l,j,rangeExplosion,playerNumber);
               map.createBomb(bomb1);
               player.bombExplosion(i);
               player.setIsBomb(i,false);
           }
       }
   }

   public void claimItem(){
       for (int index=0; index< player.getJumlahPlayer(); index++){
           HitBox hitBox1= player.getHitbox(index);
           for (int i=0; i<map.tinggiMap; i++){
               for (int j=0; j<map.panjangMap; j++){
                   if (map.isItems(i, j)) {
                       Item item= map.getItem(i,j);
                       HitBox hitBox2= item.getHitBox();
                       if (hitBox1.getxCenter()>hitBox2.getX()&&hitBox1.getxCenter()<hitBox2.getX()+hitBox2.getWidth()&&hitBox1.getyCenter()>hitBox2.getY()&&hitBox1.getyCenter()<hitBox2.getY()+hitBox2.getHeight()){
                           map.claim(i,j);
                           player.claimItem(item.getNama(),index);
                           if (item.getNama()=="stun"){
                               music = Gdx.audio.newMusic(Gdx.files.internal("..\\bomberMan\\assets\\SoundEffect\\dapetdebuff.mp3"));
                               music.setVolume(ControllerScreen.volumeItem);
                               music.setLooping(false);
                               music.play();
                           } else {
                               music = Gdx.audio.newMusic(Gdx.files.internal("..\\bomberMan\\assets\\SoundEffect\\dapetbuff.mp3"));
                               music.setVolume(ControllerScreen.volumeItem);
                               music.setLooping(false);
                               music.play();
                           }

                       }
                   }
               }
           }
       }
   }

   public void updateExplosion(){
       for (int i=0; i<map.ledakan.size(); i++){
           Ledakan ledakan= map.getLedakan(i);
           HitBox hitBox2= ledakan.getHitBox();

           //kondisi mengcheck apakah hitBox yang terdapat pada player, mengenai hitBox pada ledakan
           for (int index=0; index< player.getJumlahPlayer(); index++){
               if (player.isAlive(index)) {

                       HitBox hitBox1 = player.getHitbox(index);

                       if (hitBox1.getxCenter() > hitBox2.getX() && hitBox1.getxCenter() < hitBox2.getX() + hitBox2.getWidth() && hitBox1.getyCenter() > hitBox2.getY() && hitBox1.getyCenter() < hitBox2.getY() + hitBox2.getHeight()) {
                           if (player.isShield(index)){

                           } else {
                               player.playerDead(index);
                           }
                       }

               }
           }

           //kondisi mengcheck apakah hitBox yang terdapat pada box, mengenai hitBox pada ledakan
           for (int ii=0; ii<map.tinggiMap; ii++){
               for (int j=0; j<map.panjangMap; j++){
                   if (map.isBox(ii, j)) {
                       Box box= map.getBox(ii,j);
                       HitBox hitBox1= box.getHitBox();

                       if (hitBox1.getxCenter()>hitBox2.getX()&&hitBox1.getxCenter()<hitBox2.getX()+hitBox2.getWidth()&&hitBox1.getyCenter()>hitBox2.getY()&&hitBox1.getyCenter()<hitBox2.getY()+hitBox2.getHeight()){
                           map.DestroyBox(ii,j);
                       }
                   }
               }
           }
       }
   }

   void activasionSkill(){
       for (int i=0; i< player.getJumlahPlayer(); i++){
           Character character=player.getCharacter(i);
           if (character.getSkill()== Skill.Destroy){
               //skill desroyer
           } else if (character.getSkill()== Skill.Penetrate) {
               //skill ghoster
           } else if (character.getSkill()== Skill.BombThrow) {
               //skill bomber
           } else if (character.getSkill()== Skill.Build) {
               //skill builder
           }
       }
   }
}
