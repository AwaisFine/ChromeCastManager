package com.chromecastmanager;

import com.google.android.gms.cast.CastMediaControlIntent;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	MediaRouteSelector mMediaRouteSelector;
	MediaRouter mMediaRouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mMediaRouter = MediaRouter.getInstance(getApplicationContext());
        mMediaRouteSelector = new MediaRouteSelector.Builder()
        .addControlCategory(CastMediaControlIntent.categoryForCast("YOUR_APPLICATION_ID"))
        .build();
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      getMenuInflater().inflate(R.menu.main, menu);
      MenuItem mediaRouteMenuItem = menu.findItem(R.id.media_route_menu_item);
      MediaRouteActionProvider mediaRouteActionProvider = 
        (MediaRouteActionProvider) MenuItemCompat.getActionProvider(mediaRouteMenuItem);
      mediaRouteActionProvider.setRouteSelector(mMediaRouteSelector);
      return true;
    }
}

