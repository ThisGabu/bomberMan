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
       for (int i=0; i<player.getJumlahPlayer(); i++){
           if (player.getIsBomb(i)){
               bomb= player.getBomb(i);
               Bomb bomb1= new Bomb(bomb.getX(), bomb.getY());
               map.createBomb(bomb1);
               player.setIsBomb(i,false);
           }
       }

   }
}
