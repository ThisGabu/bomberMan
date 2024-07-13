package Utility;

import Entity.Bomb.Bomb;
import Entity.Player.ControllerPlayer;
import Entity.Player.Player;

public class Update {

   ControllerPlayer player;
   MapGame map;
   Bomb bomb;
   HitBox hitBox;

   public Update(ControllerPlayer player, MapGame map) {
       this.player = player;
       this.map = map;
   }

   public void update(float delta){
       map.update(delta);
       updateBomb();
       checkPlayer();
       checkBomb();
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
               if (player.getI(i)!=map.getJumlahTileRumput()-1) {
                   if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i)) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i)) + map.widthTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           player.setUp(false, i);
                       } else {
                           player.setUp(true, i);
                       }
                   } else if (player.getJ(i) == 0) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           player.setUp(false, i);
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           player.setUp(false, i);
                       } else {
                           player.setUp(true, i);
                       }
                   } else if (player.getJ(i) == map.getJumlahTileRumput()-1) {
                       if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                           player.setUp(false, i);
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           player.setUp(false, i);
                       } else {
                           player.setUp(true, i);
                       }
                   } else if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) - 1) && player.getXPositionPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) - 1) + map.getWidthTile()) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) - 1)) {
                           player.setUp(false, i);
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           player.setUp(false, i);
                       } else {
                           player.setUp(true, i);
                       }
                   } else if (player.getXPositionPlayer(i) + player.getWidthPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) + 1) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) + 1) + map.getWidthTile()) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           player.setUp(false, i);
                       } else if (map.isWall(player.getI(i) + 1, player.getJ(i))) {
                           player.setUp(false, i);
                       } else {
                           player.setUp(true, i);
                       }
                   }
               } else {
                   if (player.getYPositionPlayer(i)+player.getHeightPlayer(i)<map.getyPosition(map.getJumlahTileRumput()-1,map.getJumlahTileRumput()-1)+map.heightTile){
                       player.setUp(true,i);
                   } else {
                       player.setUp(false,i);
                   }
               }
           } else if (player.getPergerakan(i) == "down") {
               if (player.getI(i) != 0) {
                   if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i)) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i)) + map.widthTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           player.setDown(false, i);
                       } else {
                           player.setDown(true, i);
                       }
                   } else if (player.getJ(i) == map.getJumlahTileRumput() - 1) {
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                           player.setDown(false, i);
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           player.setDown(false, i);
                       } else {
                           player.setDown(true, i);
                       }
                   } else if (player.getJ(i) == 0) {
                       if (map.isWall(player.getI(i)-1, player.getJ(i) + 1)) {
                           player.setDown(false, i);
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           player.setDown(false, i);
                       } else {
                           player.setDown(true, i);
                       }
                   } else if (player.getXPositionPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) - 1) && player.getXPositionPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) - 1) + map.getWidthTile()) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                           player.setDown(false, i);
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           player.setDown(false, i);
                       } else {
                           player.setDown(true, i);
                       }
                   } else if (player.getXPositionPlayer(i) + player.getWidthPlayer(i) > map.getxPosition(player.getI(i), player.getJ(i) + 1) && player.getXPositionPlayer(i) + player.getWidthPlayer(i) < map.getxPosition(player.getI(i), player.getJ(i) + 1) + map.getWidthTile()) {
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                           player.setDown(false, i);
                       } else if (map.isWall(player.getI(i) - 1, player.getJ(i))) {
                           player.setDown(false, i);
                       } else {
                           player.setDown(true, i);
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
               if (player.getJ(i)!=map.getJumlahTileRumput()-1) {
                   if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i), player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i), player.getJ(i)) + map.heightTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i), player.getJ(i)+1)) {
                           player.setRight(false, i);
                       } else {
                           player.setRight(true, i);
                       }
                   } else if (player.getI(i) == 0) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           player.setRight(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i)+1)) {
                           player.setRight(false, i);
                       } else {
                           player.setRight(true, i);
                       }
                   } else if (player.getI(i) == map.getJumlahTileRumput()-1) {
                       if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                           player.setRight(false, i);
                       } else if (map.isWall(player.getI(i)-1, player.getJ(i)+1)) {
                           player.setRight(false, i);
                       } else {
                           player.setRight(true, i);
                       }
                   }else if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i)- 1, player.getJ(i)) && player.getYPositionPlayer(i) < map.getyPosition(player.getI(i) - 1, player.getJ(i)) + map.heightTile) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) + 1)) {
                           player.setRight(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i)+1)) {
                           player.setRight(false, i);
                       } else {
                           player.setRight(true, i);
                       }
                   } else if (player.getYPositionPlayer(i) + player.getHeightPlayer(i) > map.getyPosition(player.getI(i) + 1, player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i) + 1, player.getJ(i)) + map.heightTile) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) + 1)) {
                           player.setRight(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i) + 1)) {
                           player.setRight(false, i);
                       } else {
                           player.setRight(true, i);
                       }
                   }
               } else {
                   if (player.getXPositionPlayer(i)+player.getWidthPlayer(i)<map.getxPosition(map.getJumlahTileRumput()-1,map.getJumlahTileRumput()-1)+map.widthTile){
                       player.setRight(true,i);
                   } else {
                       player.setRight(false,i);
                   }
               }
           } else if (player.getPergerakan(i)=="left"){
               if (player.getJ(i)!=0) {
                   if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i), player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i), player.getJ(i)) + map.heightTile) {
                       //cek posisi player apakah sudah pas ditengah tile atau hanya sebagian tubuh saja untuk ini dicek lokasi panjang playernya apakah sudah berada didalam tile atau belum
                       if (map.isWall(player.getI(i), player.getJ(i)-1)) {
                           player.setLeft(false, i);
                       } else {
                           player.setLeft(true, i);
                       }
                   } else if (player.getI(i) == map.getJumlahTileRumput()-1) {
                       if (map.isWall(player.getI(i)-1, player.getJ(i) - 1)) {
                           player.setLeft(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i)-1)) {
                           player.setLeft(false, i);
                       } else {
                           player.setLeft(true, i);
                       }
                   } else if (player.getI(i) == 0) {
                       if (map.isWall(player.getI(i)+1, player.getJ(i) - 1)) {
                           player.setLeft(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i)-1)) {
                           player.setLeft(false, i);
                       } else {
                           player.setLeft(true, i);
                       }
                   }else if (player.getYPositionPlayer(i) > map.getyPosition(player.getI(i)- 1, player.getJ(i)) && player.getYPositionPlayer(i) < map.getyPosition(player.getI(i) - 1, player.getJ(i)) + map.heightTile) {
                       //cek posisi belakang player karena x player tertingga dibelakang alias hanya setengah badan yang memasuki tile berikutnya
                       if (map.isWall(player.getI(i) - 1, player.getJ(i) - 1)) {
                           player.setLeft(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i)-1)) {
                           player.setLeft(false, i);
                       } else {
                           player.setLeft(true, i);
                       }
                   } else if (player.getYPositionPlayer(i) + player.getHeightPlayer(i) > map.getyPosition(player.getI(i) + 1, player.getJ(i)) && player.getYPositionPlayer(i) + player.getHeightPlayer(i) < map.getyPosition(player.getI(i) + 1, player.getJ(i)) + map.heightTile) {
                       if (map.isWall(player.getI(i) + 1, player.getJ(i) - 1)) {
                           player.setLeft(false, i);
                       } else if (map.isWall(player.getI(i), player.getJ(i) - 1)) {
                           player.setLeft(false, i);
                       } else {
                           player.setLeft(true, i);
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
               int l= bomb.getI();
               int j= bomb.getJ();
               Bomb bomb1= new Bomb(centerX, centerY,l,j);
               map.createBomb(bomb1);
               player.setIsBomb(i,false);
           }
       }
   }
}
