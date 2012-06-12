package org.loon.anddev.utils;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.LayoutGameActivity;

import android.os.Bundle;
import android.view.KeyEvent;

public abstract class AdGameActivity extends LayoutGameActivity {
	
	protected void onCreate(final Bundle pSavedInstanceState) {
		super.onCreate(pSavedInstanceState);
		AdEnviroment.getInstance().initContext(this);
	}
	
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		Scene scene = AdEnviroment.getInstance().getScene();
		if (scene instanceof AdScene) {
			if (pKeyCode == KeyEvent.KEYCODE_MENU && pEvent.getAction() == KeyEvent.ACTION_DOWN) {
				if (scene.hasChildScene()) {
					((AdFadeLayer) scene.getChild(AdScene.FADE_LAYER)).setTransparency(0f);
					scene.back();
				} else {
					AdMenuScene menu = (AdMenuScene) ((AdScene) scene).createMenu();
					if (menu != null) {
						((AdFadeLayer) scene.getChild(AdScene.FADE_LAYER)).setTransparency(menu.getTransparency());
						scene.setChildScene(menu, false, true, true);
					}
				}
				return true;
			}
		}
		return super.onKeyDown(pKeyCode, pEvent);
	}
	
}
