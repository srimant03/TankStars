package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseScreen implements Screen {

    private final Application app;
    private Stage stage;
    private Image background;
    private Image pause;
    private Skin skin;
    private Texture texture;
    private TextButton resume,exit,save;
    private SpriteBatch batch;
    private Sprite sprite;
    private Table table;
    private TextField info1;

    public PauseScreen(Application app) {
        this.app=app;
        this.stage = new Stage(new ScreenViewport());
        this.skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        this.texture = new Texture(Gdx.files.internal("pause_background.png"));
        this.background = new Image(texture);
        this.resume = new TextButton("Resume", skin);
        this.exit = new TextButton("Exit", skin);
        this.save = new TextButton("Save", skin);
        this.table = new Table();
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0,0);
        resume.setWidth(125);
        resume.setHeight(75);
        resume.setPosition(175, 300);
        save.setWidth(125);
        save.setHeight(75);
        save.setPosition(175, 175);
        exit.setWidth(125);
        exit.setHeight(75);
        exit.setPosition(175, 50);
        //table.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2, Align.center);
        stage.addActor(resume);
        stage.addActor(save);
        stage.addActor(exit);
        resume.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new GameScreen(app));
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new Main_Screen(app));
            }
        });
        save.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new Main_Screen(app));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        //update(delta);
        stage.draw();
        app.batch.begin();
        //app.font.draw(app.batch, "Welcome to Tank Stars " + Application.version + "!", 100, 300);
        app.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
