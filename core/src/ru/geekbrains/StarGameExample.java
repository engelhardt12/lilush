package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGameExample extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		Vector2 v1 = new Vector2(2, 2);
		Vector2 v2 = new Vector2(0, -1);
		v1.add(v2);
		System.out.println("v1.add(v2) = (" + v1.x + ", " + v1.y + ")");

		v1.set(3, 2);
		v2.set(9, 3);
		v2.sub(v1);
		System.out.println("v2.sub(v1) = (" + v2.x + ", " + v2.y + ")");
		System.out.println("v2.len() = " + v2.len());

		v2.scl(2);
		System.out.println("v2.len() = " + v2.len());
		v2.scl(0.9f);
		System.out.println("v2.len() = " + v2.len());
		v2.nor();
		System.out.println("v2.len() = " + v2.len());

		v1.set(1, 1);
		v2.set(-1, 1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.55f, 0.23f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
