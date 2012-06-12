package org.anddev.amatidev.pvb;

import org.anddev.amatidev.pvb.singleton.GameData;
import org.anddev.andengine.opengl.font.Font;
import org.loon.anddev.utils.AdEnviroment;
import org.loon.anddev.utils.AdMenuScene;

public class GameMenu extends AdMenuScene {
	
	private static final int MENU_AUDIO = 0;
	private static final int MENU_VIBRO = 1;
	private static final int MENU_EXIT = 2;
	
	@Override
	public void createMenuScene() {
		String audio = "";
		if (AdEnviroment.getInstance().getAudio())
			audio += "ON";
		else
			audio += "OFF";
		
		String vibro = "";
		if (AdEnviroment.getInstance().getVibro())
			vibro += "ON";
		else
			vibro += "OFF";
		
		Font font = GameData.getInstance().mFontGameMenu;
		
		addTextItem(MENU_AUDIO, font, "AUDIO " + audio, 1f, 0.7f, 0.7f, 1.0f, 1.0f, 1f);
		addTextItem(MENU_VIBRO, font, "VIBRO " + vibro, 1f, 0.7f, 0.7f, 1.0f, 1.0f, 1f);
		addTextItem(MENU_EXIT, font, "EXIT", 1f, 0.7f, 0.7f, 1.0f, 1.0f, 1f);
	}

	@Override
	public boolean manageMenuItemClicked(final int pItemID) {
		GameData.getInstance().mSoundMenu.play();
		switch(pItemID) {
		case MENU_AUDIO:
			AdEnviroment.getInstance().toggleAudio();
			closeMenuScene();
			return true;
		case MENU_VIBRO:
			AdEnviroment.getInstance().toggleVibro();
			closeMenuScene();
			return true;
		case MENU_EXIT:
			((MainGame) AdEnviroment.getInstance().getScene()).clearScene();
			AdEnviroment.getInstance().setScene(new MainMenu());
			return true;
		default:
			return false;
		}
	}

}