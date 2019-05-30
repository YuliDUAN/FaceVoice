package cn.sharesdk.onekeyshare.themes.classic.port;

import com.mob.tools.utils.ResHelper;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;

/** 竖屏的好友列表 */
public class FriendListPagePort extends FriendListPage {
	private static final int DESIGN_SCREEN_WIDTH = 720;
	private static final int DESIGN_TITLE_HEIGHT = 96;

	public FriendListPagePort(OnekeyShareThemeImpl impl) {
		super(impl);
	}

	protected float getRatio() {
		float screenWidth = ResHelper.getScreenWidth(activity);
		return screenWidth / DESIGN_SCREEN_WIDTH;
	}

	protected int getDesignTitleHeight() {
		return DESIGN_TITLE_HEIGHT;
	}

}
