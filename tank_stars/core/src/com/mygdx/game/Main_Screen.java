package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.addListener;

public class Main_Screen implements Screen {

    private final Application app;
    private Stage stage;
    private Image background;
    private Skin skin;
    private Texture texture;
    private TextButton NewGame, loadGame, exit;
    private SpriteBatch batch;
    private Sprite sprite;
    private Table table;

    public Main_Screen(final Application app){
        this.app = app;
        this.stage = new Stage(new ScreenViewport());
        this.skin= new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        this.texture = new Texture(Gdx.files.internal("background.png"));
        this.background = new Image(texture);
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
        Runnable Transition = new Runnable() {
            @Override
            public void run() {
                app.setScreen(new Main_Screen(app));
            }
        };

    }

    @Override
    public void show() {
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        background.setPosition(0,0);
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center|Align.top);
        table.setPosition(0, Gdx.graphics.getHeight());
        NewGame = new TextButton("New Game", skin, "default");
        //NewGame.sizeBy(50,25);
        NewGame.setWidth(110);
        NewGame.setHeight(260);

        loadGame = new TextButton("Load Game", skin, "default");
        loadGame.setWidth(110);
        loadGame.setHeight(260);
        exit = new TextButton("Exit", skin, "default");
        exit.setWidth(110);
        exit.setHeight(260);
        table.padTop(200);
        table.add(NewGame);
        table.row();
        table.add(loadGame);
        table.row();
        table.add(exit);
        stage.addActor(table);
        NewGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new ChooseP1Tank(app));
            }
        });
        loadGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(new LoadGameScreen(app));
            }
        });
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });




    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.draw();
        app.batch.begin();
        //app.font.draw(app.batch, "Welcome to Tank Stars " + Application.version + "!", 100, 300);
        app.batch.end();

    }

    public void update(float delta){
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
