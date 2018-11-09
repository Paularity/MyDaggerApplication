package com.paularity.axcd.pokedex.Dagger.Modules;

import android.content.Context;

import com.paularity.axcd.pokedex.Dagger.FragmentScope;
import com.paularity.axcd.pokedex.Fragments.ActiveTabFragment;
import com.paularity.axcd.pokedex.Fragments.GameFragment;
import com.paularity.axcd.pokedex.Fragments.GroupFragment;
import com.paularity.axcd.pokedex.Fragments.HomeFragment;
import com.paularity.axcd.pokedex.Fragments.NotificationFragment;
import com.paularity.axcd.pokedex.Fragments.ProfileFragment;
import com.paularity.axcd.pokedex.Fragments.SecondFragment;
import com.paularity.axcd.pokedex.Fragments.TabFragment;
import com.paularity.axcd.pokedex.Helpers.FragmentCommunicator;
import com.paularity.axcd.pokedex.Models.Dummy;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule
{
    @Provides
    @FragmentScope
    ActiveTabFragment provideActiveTabFragment()
    {
        return new ActiveTabFragment();
    }

    @Provides
    @FragmentScope
    GameFragment provideGameFragment()
    {
        return new GameFragment();
    }

    @Provides
    @FragmentScope
    GroupFragment provideGroupFragment()
    {
        return new GroupFragment();
    }

    @Provides
    @FragmentScope
    HomeFragment provideHomeFragment()
    {
        return new HomeFragment();
    }

    @Provides
    @FragmentScope
    NotificationFragment provideNotificationFragment()
    {
        return new NotificationFragment();
    }

    @Provides
    @FragmentScope
    ProfileFragment provideProfileFragment()
    {
        return new ProfileFragment();
    }

    @Provides
    @FragmentScope
    SecondFragment provideSecondFragment()
    {
        return new SecondFragment();
    }

    @Provides
    @FragmentScope
    TabFragment provideTabFragment()
    {
        return new TabFragment();
    }

}
