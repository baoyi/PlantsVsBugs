package org.loon.anddev.utils;

import org.anddev.andengine.audio.sound.Sound;

import android.media.AudioManager;

public class AdSound {
	
	private Sound mSound;
	
	public AdSound() {
		
	}
	
	public AdSound(final Sound pSound) {
		this.mSound = pSound;
	}
	
	public void setSound(final Sound pSound) {
		this.mSound = pSound;
	}
	
	public void play() {
		int mode = AdEnviroment.getInstance().getAudioManager().getRingerMode();
		
		if (this.mSound != null && mode == AudioManager.RINGER_MODE_NORMAL && AdEnviroment.getInstance().getAudio())
			this.mSound.play();
	}
	
}