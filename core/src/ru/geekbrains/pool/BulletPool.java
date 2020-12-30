package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    public Bullet newObject() {
        return new Bullet();
    }
}
