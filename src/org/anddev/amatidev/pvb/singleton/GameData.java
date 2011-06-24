package org.anddev.amatidev.pvb.singleton;

import java.util.LinkedList;

import org.amatidev.AdResourceLoader;
import org.amatidev.AdTextScoring;
import org.anddev.amatidev.pvb.card.Card;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.graphics.Color;

public class GameData {
	
    private static GameData mInstance = null;
    
    // generici
    public LinkedList<Card> mCards;
    public int mLevel = 1;
    
    public AdTextScoring mMySeed;
    public AdTextScoring mScoring;
    
    public TextureRegion mSplash;
    
    public TextureRegion mBackground;
    public TextureRegion mTable;
    public TextureRegion mSeed;
    public TextureRegion mShot;
    public TextureRegion mShotShadow;
    public TextureRegion mPlantShadow;
    public TextureRegion mCardSelected;
    
    // cards
    public TextureRegion mCard;
    public TextureRegion mCardTomato;
	public TextureRegion mCardFlower2;
	
	// plants
	public TextureRegion mPlantTomato;
	public TextureRegion mPlantFlower2;
	
	// bugs
	public TextureRegion mBugBeetle;
	public TextureRegion mBugLadybug;

	// fonts
	public Font mFont1;
	public Font mFont2;
	public Font mFont3;
	public Font mFontEvent;
	public Font mFontMainMenu;
	public Font mFontGameMenu;
	
	private GameData() {
		
	}
	
	public static synchronized GameData getInstance() {
		if (mInstance == null) 
			mInstance = new GameData();
		return mInstance;
	}
	
	public void initData() {
		this.mFont1 = AdResourceLoader.getFont("akaDylan Plain", 20, 2, Color.WHITE, Color.BLACK);
		this.mFont2 = AdResourceLoader.getFont("akaDylan Plain", 14, 1, Color.WHITE, Color.BLACK);
		this.mFont3 = AdResourceLoader.getFont("akaDylan Plain", 30, 2, Color.WHITE, Color.BLACK);
		
		this.mFontEvent = AdResourceLoader.getFont(512, 512, "akaDylan Plain", 64, 3, Color.WHITE, Color.BLACK);
		this.mFontMainMenu = AdResourceLoader.getFont(512, 512, "akaDylan Plain", 43, 3, Color.WHITE, Color.BLACK);
		this.mFontGameMenu = AdResourceLoader.getFont(512, 512, "akaDylan Plain", 48, 3, Color.WHITE, Color.BLACK);
		
		this.mSplash = AdResourceLoader.getTexture(1024, 512, "splash");
		
		this.mBackground = AdResourceLoader.getTexture(1024, 512, "back");
		this.mTable  = AdResourceLoader.getTexture(1024, 128, "table");
		this.mSeed = AdResourceLoader.getTexture(64, 64, "seed");
		this.mShot = AdResourceLoader.getTexture(64, 64, "shot");
		this.mShotShadow = AdResourceLoader.getTexture(64, 64, "shadow2");
		
		this.mCardSelected = AdResourceLoader.getTexture(64, 128, "select");
		
		this.mCard = AdResourceLoader.getTexture(64, 128, "card");
		
		this.mCardTomato = AdResourceLoader.getTexture(64, 128, "card_tomato");
		this.mCardFlower2 = AdResourceLoader.getTexture(64, 128, "card_flower2");
		
		this.mPlantShadow = AdResourceLoader.getTexture(64, 16, "shadow");
		
		this.mPlantTomato = AdResourceLoader.getTexture(64, 128, "tomato");
		this.mPlantFlower2 = AdResourceLoader.getTexture(64, 128, "default2");
		
		this.mBugBeetle = AdResourceLoader.getTexture(64, 128, "beetle");
		this.mBugLadybug = AdResourceLoader.getTexture(64, 128, "ladybug");
		
		this.mMySeed = new AdTextScoring(48, 68, GameData.getInstance().mFont1, 6);
		this.mScoring = new AdTextScoring(625, 47, GameData.getInstance().mFont3);
		
		this.mCards = new LinkedList<Card>();
	}
	
}
