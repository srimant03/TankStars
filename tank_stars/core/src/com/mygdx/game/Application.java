
package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.Timer;


public class Application extends Game {

    public static final String TITLE = "Tank Stars";
    public static final float version = 0.1f;
    public static final int V_WIDTH = 480;
    public static final int V_HEIGHT = 420;


    public SpriteBatch batch;
    public BitmapFont font;
    public AssetManager assets;
    private Sound sound;
    private Music music;


    @Override
    public void create () {
        batch = new SpriteBatch();
        this.setScreen(new Main_Screen(this));
        //this.setScreen(new ChooseP1Tank(this));

        font = new BitmapFont();
        font.setColor(1, 1, 1, 1);
        assets = new AssetManager();
        //Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/mixkit-water-sci-fi-bleep-902.wav"));
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/file_example_WAV_5MG.wav"));

        music.setLooping(true);
        music.setVolume(1.0f);
        music.play();

    }

    @Override
    public void render () {
        //Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        //ScreenUtils.clear(0, 0, 1, 1);
        super.render();
    }

    @Override
    public void dispose () {
        batch.dispose();
        assets.dispose();
        font.dispose();
    }
}
