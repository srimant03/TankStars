package com.mygdx.game;

import com.badlogic.gdx.Game;
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

public class ChooseP2Tank implements Screen {

    private final Application app;
    private Stage stage;
    private Image background;
    private Image p1;
    private Skin skin;
    private Texture texture;
    private TextButton Blazer, Helios, Mark, back;
    private SpriteBatch batch;
    private Sprite sprite;
    private Table table;
    private TextField info1;

    public ChooseP2Tank(Application app) {
        this.app = app;
        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        this.texture = new Texture(Gdx.files.internal("Background_Box.png"));
        this.background = new Image(texture);
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);
        Blazer = new TextButton("Blazer", skin, "default");
        Blazer.setWidth(100);
        Blazer.setHeight(50);
        Blazer.setPosition(40,90);
        Helios = new TextButton("Helios", skin, "default");
        Helios.setWidth(100);
        Helios.setHeight(50);
        Helios.setPosition(195,90);
        Mark = new TextButton("Mark", skin, "default");
        Mark.setWidth(100);
        Mark.setHeight(50);
        Mark.setPosition(350,90);
        stage.addActor(Blazer);
        stage.addActor(Helios);
        stage.addActor(Mark);
        p1=new Image(new Texture(Gdx.files.internal("CP2T.png")));
        p1.setWidth(150);
        p1.setHeight(75);
        p1.setPosition(170,315);
        stage.addActor(p1);
        //stage.addActor(info1);
        back = new TextButton("Back", skin, "default");
        back.setWidth(75);
        back.setHeight(50);
        back.setPosition(0, 10);
        stage.addActor(back);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new ChooseP1Tank(app));
            }
        });
        Blazer.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new GameScreen(app));
            }
        });
        Helios.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new GameScreen(app));
            }
        });
        Mark.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new GameScreen(app));
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
