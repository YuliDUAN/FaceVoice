package cn.sharesdk.onekeyshare.themes.classic.land;

import java.util.ArrayList;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;

/** 横屏的九宫格页面 */
public class PlatformPageLand extends PlatformPage {

	public PlatformPageLand(OnekeyShareThemeImpl impl) {
		super(impl);
	}

	public void onCreate() {
		requestSensorLandscapeOrientation();
		super.onCreate();
	}

	protected PlatformPageAdapter newAdapter(ArrayList<Object> cells) {
		return new PlatformPageAdapterLand(this, cells);
	}

}

