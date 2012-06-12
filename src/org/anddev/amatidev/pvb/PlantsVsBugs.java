package org.anddev.amatidev.pvb;

import org.anddev.amatidev.pvb.singleton.GameData;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.entity.scene.Scene;
import org.loon.anddev.utils.AdEnviroment;
import org.loon.anddev.utils.AdGameActivity;


public class PlantsVsBugs extends AdGameActivity {

	@Override
	protected int getLayoutID() {
		return R.layout.main;
	}

	@Override
	protected int getRenderSurfaceViewID() {
		return R.id.xmllayoutexample_rendersurfaceview;
	}

	@Override
	public void onLoadComplete() {

	}

	@Override
	public Engine onLoadEngine() {
		return AdEnviroment.createEngine(ScreenOrientation.LANDSCAPE, true, false);
	}

	@Override
	public void onLoadResources() {
		GameData.getInstance().initData();
	}

	@Override
	public Scene onLoadScene() {
		return new MainMenu();
	}
	
}