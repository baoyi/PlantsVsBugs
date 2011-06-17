package org.anddev.andengine.pvb.bug;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.PathModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.modifier.PathModifier.Path;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extra.Enviroment;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.pvb.singleton.GameData;
import org.anddev.andengine.util.SimplePreferences;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.ease.EaseSineInOut;

public abstract class Bug extends Entity {
	
	protected float mDuration = 35f;
	protected Path mPath;
	
	public Bug(final float y, final TextureRegion pTexture) {
		SimplePreferences.incrementAccessCount(Enviroment.getInstance().getContext(), "count" + Float.toString(y));
		
		Sprite shadow = new Sprite(2, 55, GameData.getInstance().mPlantShadow);
		shadow.setAlpha(0.4f);
		shadow.attachChild(new Sprite(0, -68, pTexture));
		attachChild(shadow);
		
		this.mPath = new Path(2).to(705, y).to(0, y);
	}
	
	public void onAttached() {
		this.registerEntityModifier(new PathModifier(this.mDuration, this.mPath, new IEntityModifierListener() {
			@Override
			public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
				// game over
			}}, EaseSineInOut.getInstance()));
	}
	
}