package org.loon.anddev.utils;

import android.media.AudioManager;

public class AdVibration {
	
	public static void duration(final int pMilliseconds) {
		int mode = AdEnviroment.getInstance().getAudioManager().getRingerMode();
		
		if (mode >= AudioManager.RINGER_MODE_VIBRATE && AdEnviroment.getInstance().getVibro()) {
			try {
				AdEnviroment.getInstance().getEngine().vibrate(pMilliseconds);
			} catch (Exception e) {
				
			}
		}
	}
	
}