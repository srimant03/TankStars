package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadGameScreen implements Screen {

        private SpriteBatch batch;
        private final Application app;
        private Stage stage;
        private Skin skin;
        private Image background, heading,save1,save2,save3;
        private Texture texture;
        //private TextButton LoadSave1,LoadSave2,LoadSave3;
        private TextButton back,load1,load2,load3;
        private Table table;
        private SpriteBatch batch1;
        //private TextField info1,info2,info3;


        public LoadGameScreen(final Application app) {
                this.app=app;
                this.stage = new Stage(new ScreenViewport());
                this.skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
                this.texture = new Texture(Gdx.files.internal("pause_background.png"));
                this.background = new Image(texture);
                this.heading = new Image(new Texture(Gdx.files.internal("saves.png")));
                this.save1 = new Image(new Texture(Gdx.files.internal("save1.png")));
                this.save2 = new Image(new Texture(Gdx.files.internal("save2.png")));
                this.save3 = new Image(new Texture(Gdx.files.internal("save3.png")));
                //this.back = new TextButton("Back", skin);
                this.load1 = new TextButton("Continue", skin);
                this.load2 = new TextButton("Continue", skin);
                this.load3 = new TextButton("Continue", skin);
                this.back=new TextButton("Back",skin);
                stage.addActor(background);
                Gdx.input.setInputProcessor(stage);
        }

        @Override
        public void show() {
                background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                background.setPosition(0,0);
                heading.setSize(250, 75);
                heading.setPosition(115, 320);
                save1.setSize(140, 200);
                save1.setPosition(10, 100);
                save2.setSize(140, 200);
                save2.setPosition(170, 100);
                save3.setSize(140, 200);
                save3.setPosition(330, 100);

                load1.setWidth(110);
                load1.setHeight(50);
                load1.setPosition(25, 100);
                load2.setWidth(110);
                load2.setHeight(50);
                load2.setPosition(185, 100);
                load3.setWidth(110);
                load3.setHeight(50);
                load3.setPosition(345, 100);


                back.setWidth(125);
                back.setWidth(75);
                back.setHeight(50);
                back.setPosition(0, 10);
                back.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                                app.setScreen(new Main_Screen(app));
                        }
                });

                load1.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                                app.setScreen(new GameScreen(app));
                        }
                });
                load2.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                                app.setScreen(new GameScreen(app));
                        }
                });
                load3.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                                app.setScreen(new GameScreen(app));
                        }
                });

                stage.addActor(save1);
                stage.addActor(save2);
                stage.addActor(save3);
                stage.addActor(load3);
                stage.addActor(load2);
                stage.addActor(load1);
                stage.addActor(heading);
                stage.addActor(back);

        }

        @Override
        public void render(float delta){
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
