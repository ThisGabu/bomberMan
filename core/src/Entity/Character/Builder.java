package Entity.Character;

import Entity.Character.Skill.Skill;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Builder implements Character{

    String nama= null;
    Skill skill = null;

    float delayFrame=0.25f;
    float delayBombFrame=0.1f;

    int colsIdle = 1;
    int rowsIdle = 12;
    Texture playerIdle = null;
    Animation<TextureRegion> animationIdle = null;

    int colsDead = 1;
    int rowsDead = 7;
    Texture playerDead = null;
    Animation<TextureRegion> animationDead = null;

    int colsDown = 1;
    int rowsDown = 8;
    Texture playerWalkDown = null;
    Animation<TextureRegion> animationWalkDown = null;

    int colsUp = 1;
    int rowsUp = 8;
    Texture playerWalkUp = null;
    Animation<TextureRegion> animationWalkUp = null;

    int colsLeft = 1;
    int rowsLeft = 8;
    Texture playerWalkLeft = null;
    Animation<TextureRegion> animationWalkLeft = null;

    int colsRight = 1;
    int rowsRight = 8;
    Texture playerWalkRight = null;
    Animation<TextureRegion> animationWalkRight = null;

    int colsBomb = 1;
    int rowsBomb = 6;
    float placeBombDelay = (colsBomb*rowsBomb/2) * delayFrame;
    Texture playerPlaceBomb = null;
    Animation<TextureRegion> animationPlaceBomb = null;

    int colsStun = 1;
    int rowsStun = 8;
    Texture stunEffect = null;
    Animation<TextureRegion> animationStun = null;

    int colsShield = 10;
    int rowsShield = 1;
    Texture shieldEffect = null;
    Animation<TextureRegion> animationShield = null;

    float timer = 0;

    Animation<TextureRegion> animation = null;

    Builder(){
        nama="builder";
        skill=Skill.Build;

    }

    public Animation<TextureRegion> getAnimation(){
        return animation;
    }

    public void setAnimationWalkUp(){
        animation=animationWalkUp;
    }

    public void setAnimationWalkDown(){
        animation=animationWalkDown;
    }

    public void setAnimationWalkRight(){
        animation=animationWalkRight;
    }

    public void setAnimationWalkLeft(){
        animation=animationWalkLeft;
    }

    public Skill getSkill(){
        return skill;
    }

    public String getNama(){
        return nama;
    }
}
