package org.loon.anddev.utils;

public interface IAdMenuScene {
	
	public void createMenuScene();
	
	public float getTransparency();
	public void setTransparency(final float pTransparency);
	
	public boolean manageMenuItemClicked(final int pItemID);
	
	public void closeMenuScene();
	
}
