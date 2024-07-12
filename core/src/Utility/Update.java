package Utility;

import Entity.Bomb.Bomb;
import Entity.Player.ControllerPlayer;
import Entity.Player.Player;

public class Update {

   ControllerPlayer player;
   MapGame map;
   Bomb bomb;

   public Update(ControllerPlayer player, MapGame map) {
       this.player = player;
       this.map = map;
   }

   public void update(){
       updateBomb();
       updatePlayer();
       checkPlayer();
   }

   public void updatePlayer(){
       for (int i=0; i<map.getJumlahTileRumput(); i++){
           for (int j=0; j<map.getJumlahTileRumput(); j++){
               for (int k=0; k< player.getJumlahPlayer(); k++){

                   if (player.getXPositionPlayer(k) >= map.getxPosition(i, j) && player.getXPositionPlayer(k)<= map.getxPosition(i, j) + map.widthTile&&player.getXPositionPlayer(k)+player.getWidthPlayer(k) >= map.getxPosition(i, j) && player.getXPositionPlayer(k)+player.getWidthPlayer(k)<= map.getxPosition(i, j) + map.widthTile) {
                       player.setJ(k, j);
                       player.setPergerakanBefore(k,"safe");
                   } else {
                       if (player.getPergerakan(k)=="right") {
                           if (player.getXPositionPlayer(k)+ player.getWidthPlayer(k)>= map.getxPosition(i, j) && player.getXPositionPlayer(k)+ player.getWidthPlayer(k)<= map.getxPosition(i, j) + map.widthTile) {
                               player.setJ(k, j);
                               player.setPergerakanBefore(k,"right");
                           }
                       } else if (player.getPergerakan(k)=="left") {
                           if (player.getXPositionPlayer(k)+ player.getWidthPlayer(k)>= map.getxPosition(i, j) && player.getXPositionPlayer(k)+ player.getWidthPlayer(k)<= map.getxPosition(i, j) + map.widthTile) {
                               player.setJ(k, j);
                               player.setPergerakanBefore(k,"left");
                           }
                       }
                   }

                   if (player.getYPositionPlayer(k) >= map.getyPosition(i, j) && player.getYPositionPlayer(k) + player.getHeightPlayer(k) <= map.getyPosition(i, j) + map.heightTile) {
                       player.setI(k, i);
                       player.setPergerakanBefore(k,"safe");
                   } else {
                       if (player.getPergerakan(k)=="up"){
                           if (player.getYPositionPlayer(k)+ player.getHeightPlayer(k)>=map.getyPosition(i,j)&&player.getYPositionPlayer(k)+ player.getHeightPlayer(k)<=map.getxPosition(i,j)+map.widthTile){
                               player.setI(k,i);
                               player.setPergerakanBefore(k,"up");
                           }
                       } else if (player.getPergerakan(k)=="down") {
                           if (player.getYPositionPlayer(k)>=map.getyPosition(i,j)&&player.getYPositionPlayer(k)<=map.getyPosition(i,j)+map.widthTile){
                               player.setI(k,i);
                               player.setPergerakanBefore(k,"down");
                           }
                       }
                   }
               }
           }
       }
   }

   public void checkPlayer(){
       for (int i=0; i<player.getJumlahPlayer(); i++){
           if (player.getPergerakan(i)=="up"){
               if (player.getPergerakanBefore(i)=="right"){
                   if (map.isWall(player.getI(i)+1,player.getJ(i)-1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else if (player.getPergerakanBefore(i)=="left") {
                   if (map.isWall(player.getI(i)+1,player.getJ(i)+1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else {
                   if (player.getI(i)<map.getJumlahTileRumput()-1){
                       if (map.isWall(player.getI(i)+1,player.getJ(i))){
                           player.setUp(false,i);
                       } else {
                           player.setUp(true,i);
                       }
                   } else {
                       player.setUp(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="down"){
               if (player.getPergerakanBefore(i)=="right"){
                   if (map.isWall(player.getI(i)-1,player.getJ(i)-1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else if (player.getPergerakanBefore(i)=="left") {
                   if (map.isWall(player.getI(i) - 1, player.getJ(i)+ 1)) {
                       player.setUp(false, i);
                   } else {
                       player.setUp(true, i);
                   }
               } else {
                   if (player.getI(i)>0){
                       if (map.isWall(player.getI(i)-1,player.getJ(i))){
                           player.setDown(false,i);
                       } else {
                           player.setDown(true,i);
                       }
                   } else {
                       player.setDown(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="right"){
               if (player.getPergerakanBefore(i)=="up"){
                   if (map.isWall(player.getI(i)-1,player.getJ(i)+1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else if (player.getPergerakanBefore(i)=="down") {
                   if (map.isWall(player.getI(i)+1,player.getJ(i)+1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else {
                   if (player.getJ(i)<map.getJumlahTileRumput()-1){
                       if (map.isWall(player.getJ(i)+1,player.getI(i))){
                           player.setRight(false,i);
                       } else {
                           player.setRight(true,i);
                       }
                   } else {
                       player.setRight(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="left"){
               if (player.getPergerakanBefore(i)=="up"){
                   if (map.isWall(player.getI(i)-1,player.getJ(i)-1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else if (player.getPergerakanBefore(i)=="down") {
                   if (map.isWall(player.getI(i)+1,player.getJ(i)-1)){
                       player.setUp(false,i);
                   } else {
                       player.setUp(true,i);
                   }
               } else {
                   if (player.getJ(i)>0){
                       if (map.isWall(player.getJ(i)-1,player.getI(i))){
                           player.setLeft(false,i);
                       } else {
                           player.setLeft(true,i);
                       }
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
               int l= bomb.getI();
               int j= bomb.getJ();
               Bomb bomb1= new Bomb(centerX, centerY,l,j);
               map.createBomb(bomb1);
               player.setIsBomb(i,false);
           }
       }
   }
}
