package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseButton extends Sprite {

    private static final float SCALE = 0.9f;

    private int pointer;
    private boolean pressed;

    public BaseButton(TextureRegion region) {
        super(region);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (pressed || !isMe(touch)) {
            return false;
        }
        this.pointer = pointer;
        pressed = true;
        setScale(SCALE);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (this.pointer != pointer || !pressed) {
            return false;
        }
        pressed = false;
        setScale(1f);
        if (isMe(touch)) {
            action();
            return false;
        }
        return false;
    }

    public abstract void action();
}
