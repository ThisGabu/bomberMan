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
   }

   public void updatePlayer(){
       for (int i=0; i<map.getJumlahTileRumput(); i++){
           for (int j=0; j<map.getJumlahTileRumput(); j++){
               for (int k=0; k< player.getJumlahPlayer(); k++){
                   if (player.getXPositionPlayer(k)>=map.getxPosition(i,j)&&player.getXPositionPlayer(k)+player.getWidthPlayer(k)<=map.getxPosition(i,j)+map.widthTile){
                       player.setJ(k,j);
                   }

                   if (player.getYPositionPlayer(k)>=map.getyPosition(i,j)&&player.getYPositionPlayer(k)+ player.getHeightPlayer(k)<=map.getyPosition(i,j)+map.heightTile){
                       player.setI(k,i);
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
