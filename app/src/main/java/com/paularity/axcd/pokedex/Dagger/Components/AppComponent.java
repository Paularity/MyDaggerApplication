package com.paularity.axcd.pokedex.Dagger.Components;

import com.paularity.axcd.pokedex.Dagger.FragmentScope;
import com.paularity.axcd.pokedex.Dagger.Modules.ContextModule;
import com.paularity.axcd.pokedex.Fragments.ActiveTabFragment;
import com.paularity.axcd.pokedex.Fragments.HomeFragment;
import com.paularity.axcd.pokedex.Fragments.SecondFragment;
import com.paularity.axcd.pokedex.Fragments.TabFragment;
import com.paularity.axcd.pokedex.MainActivity;

import dagger.Component;

@Component(modules = ContextModule.class)
@FragmentScope
public interface AppComponent
{
    void inject(MainActivity activity);
    void inject(SecondFragment fragment);
    void inject(ActiveTabFragment fragment);
    void inject(TabFragment fragment);
    void inject(HomeFragment fragment);
}
