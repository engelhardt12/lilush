package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class SpritesPool<T extends Sprite> {

    private final List<T> activeObjects = new ArrayList<T>();
    private final List<T> freeObjects = new ArrayList<T>();

    public abstract T newObject();

    public T obtain() {
        T object;
        if (freeObjects.isEmpty()) {
            object = newObject();
        } else {
            object = freeObjects.remove(freeObjects.size() - 1);
        }
        activeObjects.add(object);
        System.out.println(getClass().getName() + " active/free : " + activeObjects.size() + "/" + freeObjects.size());
        return object;
    }

    public void updateActiveObjects(float delta) {
        for (T object : activeObjects) {
            if (object.isDestroyed()) {
                continue;
            }
            object.update(delta);
        }
    }

    public void drawActiveObjects(SpriteBatch batch) {
        for (T object : activeObjects) {
            if (object.isDestroyed()) {
                continue;
            }
            object.draw(batch);
        }
    }

    public void freeAllDestroyedActiveObjects() {
        for (int i = 0; i < activeObjects.size(); i++) {
            T object = activeObjects.get(i);
            if (object.isDestroyed()) {
                free(object);
                i--;
                object.flushDestroy();
            }
        }
    }

    public List<T> getActiveObjects() {
        return activeObjects;
    }
    public void freeAllActiveObjects(){
        freeObjects.addAll(activeObjects);
        activeObjects.clear();}

    public void dispose() {
        activeObjects.clear();
        freeObjects.clear();
    }

    private void free(T object) {
        if (activeObjects.remove(object)) {
            freeObjects.add(object);
            System.out.println(getClass().getName() + " active/free : " + activeObjects.size() + "/" + freeObjects.size());
        }
    }
}
