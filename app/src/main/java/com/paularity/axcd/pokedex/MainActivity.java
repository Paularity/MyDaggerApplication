package com.paularity.axcd.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.paularity.axcd.pokedex.Dagger.MyApplication;
import com.paularity.axcd.pokedex.Fragments.ActiveTabFragment;
import com.paularity.axcd.pokedex.Fragments.GameFragment;
import com.paularity.axcd.pokedex.Fragments.HomeFragment;
import com.paularity.axcd.pokedex.Fragments.NotificationFragment;
import com.paularity.axcd.pokedex.Fragments.ProfileFragment;
import com.paularity.axcd.pokedex.Fragments.GroupFragment;
import com.paularity.axcd.pokedex.Fragments.SecondFragment;
import com.paularity.axcd.pokedex.Helpers.FragmentCommunicator;
import com.paularity.axcd.pokedex.Models.Dummy;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements FragmentCommunicator
{
    private static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Inject HomeFragment homeFragment;
    @Inject GroupFragment groupFragment;
    @Inject NotificationFragment notificationFragment;
    @Inject GameFragment gameFragment;
    @Inject ProfileFragment profileFragment;
    @Inject SecondFragment secondFragment;
    @Inject ActiveTabFragment activeTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        ((MyApplication)getApplication()).getAppComponent().inject(this);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavbar);

        if(savedInstanceState == null)
        {
            //default Fragment 'HOME'
            fragmentTransaction.add(R.id.main_activity_container, homeFragment, "HOME_FRAGMENT").commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch ( menuItem.getItemId() )
                {
                    case R.id.ic_arrow:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, homeFragment, "HOME_FRAGMENT").commit();
                        break;

                    case R.id.search:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, groupFragment, "GROUP_FRAGMENT").commit();
                        break;

                    case R.id.ic_camera:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, notificationFragment, "NOTIFICATION_FRAGMENT").commit();
                        break;

                    case R.id.ic_videogame:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, gameFragment, "GAME_FRAGMENT").commit();
                        break;

                    case R.id.ic_thunder:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, profileFragment, "PROFILE_FRAGMENT").commit();
                        break;

                    default:
                        break;
                }

                return false;
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    public void onResponse(Context context, Dummy dummy)
    {
        Toast.makeText(this, dummy.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
