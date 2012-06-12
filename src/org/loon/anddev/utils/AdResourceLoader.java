package org.loon.anddev.utils;

import java.io.IOException;

import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public abstract class AdResourceLoader {
	
	public static Font getFont(final String pName, final int pSize, final int pWidth, final int pFillColor, final int pBorderColor) {
		return AdResourceLoader.getFont(256, 256, pName, pSize, pWidth, pFillColor, pBorderColor);
	}
	
	public static Font getFont(final int pTextureWidth, final int pTextureHeight, final String pName, final int pSize, final int pBorderSize, final int pFillColor, final int pBorderColor) {
		Texture tex = new Texture(pTextureWidth, pTextureHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		Font font = FontFactory.createStrokeFromAsset(tex, AdEnviroment.getInstance().getContext(), "font/" + pName + ".ttf", pSize, true, pFillColor, pBorderSize, pBorderColor, false);
		AdEnviroment.getInstance().getEngine().getTextureManager().loadTexture(tex);
		AdEnviroment.getInstance().getEngine().getFontManager().loadFont(font);
		return font;
	}
	
	public static Font getFont(final String pName, final int pSize, final int pFillColor) {
		return AdResourceLoader.getFont(256, 256, pName, pSize, pFillColor);
	}
	
	public static Font getFont(final int pTextureWidth, final int pTextureHeight, final String pName, final int pSize, final int pFillColor) {
		Texture tex = new Texture(pTextureWidth, pTextureHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		Font font = FontFactory.createFromAsset(tex, AdEnviroment.getInstance().getContext(), "font/" + pName + ".ttf", pSize, true, pFillColor);
		AdEnviroment.getInstance().getEngine().getTextureManager().loadTexture(tex);
		AdEnviroment.getInstance().getEngine().getFontManager().loadFont(font);
		return font;
	}
	
	public static TextureRegion getTexture(final int pTextureWidth, final int pTextureHeight, final String pName) {
		Texture tex = new Texture(pTextureWidth, pTextureHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TextureRegion texReg = TextureRegionFactory.createFromAsset(tex, AdEnviroment.getInstance().getContext(), "gfx/" + pName + ".png", 0, 0);
		AdEnviroment.getInstance().getEngine().getTextureManager().loadTexture(tex);
		return texReg;
	}
	
	public static TiledTextureRegion getTexture(final int pTextureWidth, final int pTextureHeight, final String pName, final int pColumns, final int pRows) {
		Texture tex = new Texture(pTextureWidth, pTextureHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		TiledTextureRegion texReg = TextureRegionFactory.createTiledFromAsset(tex, AdEnviroment.getInstance().getContext(), "gfx/" + pName + ".png", 0, 0, pColumns, pRows);
		AdEnviroment.getInstance().getEngine().getTextureManager().loadTexture(tex);
		return texReg;
	}
	
	public static AdSound getSound(final String pName) {
		AdSound sound = new AdSound();
		try {
			Sound s = SoundFactory.createSoundFromAsset(AdEnviroment.getInstance().getEngine().getSoundManager(), AdEnviroment.getInstance().getContext(), "mfx/" + pName + ".wav");
			sound.setSound(s);
		} catch (final IOException e) {
			
		}
		return sound;
	}
	
}
