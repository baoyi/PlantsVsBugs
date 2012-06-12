package org.loon.anddev.utils;

import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.AlphaModifier;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.util.modifier.IModifier;

public class AdFadeLayer extends Entity {
	
	private Rectangle mScreenBlack;
	
	private float mDelay = 0.2f;
	private float mDuration = 0.5f;
	
	public AdFadeLayer() {
		this.mScreenBlack = new Rectangle(0, 0, AdEnviroment.getInstance().getScreenWidth(), AdEnviroment.getInstance().getScreenHeight());
		this.mScreenBlack.setColor(0f, 0f, 0f);
		attachChild(this.mScreenBlack);
	}
	
	public void setFadeDelay(final float pDelay) {
		this.mDelay = pDelay;
	}
	
	public void setFadeDuration(final float pDuration) {
		this.mDuration = pDuration;
	}
	
	public void setTransparency(final float pAlpha) {
		this.mScreenBlack.setAlpha(pAlpha);
	}
	
	public void fadeOut() {
		registerUpdateHandler(new TimerHandler(AdFadeLayer.this.mDelay + 1f, false, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				AdFadeLayer.this.mScreenBlack.registerEntityModifier(
						new AlphaModifier(AdFadeLayer.this.mDuration, 1f, 0f, new IEntityModifierListener() {
							@Override
							public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
								AdFadeLayer.this.setTransparency(0f);
								((AdScene) AdEnviroment.getInstance().getScene()).startScene();
							}
							
							@Override
							public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
								
							}
						})
				);
			}
		}));
	}
	
	public void fadeIn() {
		registerUpdateHandler(new TimerHandler(AdFadeLayer.this.mDelay, false, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				AdFadeLayer.this.mScreenBlack.registerEntityModifier(
						new AlphaModifier(AdFadeLayer.this.mDuration, 0f, 1f, new IEntityModifierListener() {
							@Override
							public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
								AdFadeLayer.this.setTransparency(1f);
								((AdScene) AdEnviroment.getInstance().getScene()).endScene();
							}
							
							@Override
							public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
								
							}
						})
				);
			}
		}));
	}
	
}