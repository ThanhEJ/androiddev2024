package vn.edu.usth.usthweather;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weather";

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "ON_CREATE");
        initViewPager();
        mMediaPlayer = MediaPlayer.create(this,R.raw.cardigan);
        mMediaPlayer.start();
    }

    private void initViewPager() {
        ViewPager2 pager = findViewById(R.id.pager2);
        //HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle());
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(this);
        pager.setAdapter(adapter);
        TabLayout tablayout = findViewById(R.id.tab_layout);
        String[] titles = new String[]{"Hà Nội, Việt Nam", "Paris, Pháp", "Tokyo, Nhật Bản"};
        TabLayoutMediator layoutMediator = new TabLayoutMediator(tablayout, pager,
                ((tab, position) -> {
                    tab.setText(titles[position]);
                }));
        layoutMediator.attach();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ON_RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ON_PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ON_DESTROY");
    }
}