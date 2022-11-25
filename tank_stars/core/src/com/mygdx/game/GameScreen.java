package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen{

    private final Application app;
    private Stage stage;
    private Image background;
    private Image i1,health1,health2,fuel;
    private Skin skin;
    private Texture texture,tank1image,tank2image;
    private TextButton fire,pause,power;
    private SpriteBatch batch;
    private Sprite sprite;
    private Table table;
    private TextField info1;
    private BitmapFont font;
    private Rectangle tank1,tank2;
    //private Dialog dialog;

    public GameScreen(final Application app) {
        this.app = app;
        this.stage = new Stage(new ScreenViewport());
        this.skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        this.texture = new Texture(Gdx.files.internal("background_new.png"));
        this.background = new Image(texture);
        this.i1 = new Image(new Texture(Gdx.files.internal("Vs.png")));
        this.fuel = new Image(new Texture(Gdx.files.internal("Fuel.png")));
        this.health1 = new Image(new Texture(Gdx.files.internal("P1FullHealth.png")));
        this.health2 = new Image(new Texture(Gdx.files.internal("P2zeroHealth.png")));
        this.fire = new TextButton("Fire", skin);
        this.power=new TextButton("Power",skin);
        this.pause = new TextButton("Pause", skin);
        this.tank1image=new Texture(Gdx.files.internal("Blazer1.png"));
        this.tank2image=new Texture(Gdx.files.internal("Helios1.png"));
        this.tank1=new Rectangle(20,110,64,100);
        this.tank2=new Rectangle(410,110,64,100);


        //this.dialog = new Dialog("Pause", skin);
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);
        i1.setSize(100,100);
        i1.setPosition(200,350);

        fuel.setSize(125,75);
        fuel.setPosition(0,-20);

        health1.setSize(125,75);
        health1.setPosition(75,360);
        health2.setSize(125,75);
        health2.setPosition(300,360);

        fire.setWidth(100);
        fire.setHeight(50);
        fire.setPosition(300,0);

        power.setWidth(100);
        power.setHeight(50);
        power.setPosition(10,40);

        pause.setWidth(60);
        pause.setHeight(50);
        pause.setPosition(0,365);
        pause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new PauseScreen(app));
            }
        });

        stage.addActor(power);
        stage.addActor(pause);
        stage.addActor(fire);
        stage.addActor(health2);
        stage.addActor(health1);
        stage.addActor(fuel);
        stage.addActor(i1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        //update(delta);
        stage.draw();

        app.batch.begin();
        app.batch.draw(tank1image,tank1.x,tank1.y,tank1.width,tank1.height);
        app.batch.draw(tank2image,tank2.x,tank2.y,tank2.width,tank2.height);
        //app.font.draw(app.batch, "Welcome to Tank Stars " + Application.version + "!", 100, 300);
        app.batch.end();
        // move one tank at a time
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tank1.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tank1.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank2.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank2.x += 200 * Gdx.graphics.getDeltaTime();
        }

        // check if tank is out of bounds
        if (tank1.x < 0) {
            tank1.x = 0;
        }
        if (tank1.x > 400) {
            tank1.x = 400;
        }
        if (tank2.x < 0) {
            tank2.x = 0;
        }
        if (tank2.x > 420) {
            tank2.x = 420;
        }
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