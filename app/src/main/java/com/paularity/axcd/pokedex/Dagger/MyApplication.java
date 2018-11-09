package com.paularity.axcd.pokedex.Dagger;

import android.app.Application;
import com.paularity.axcd.pokedex.Dagger.Components.AppComponent;
import com.paularity.axcd.pokedex.Dagger.Components.DaggerAppComponent;
import com.paularity.axcd.pokedex.Dagger.Modules.ContextModule;

public class MyApplication extends Application
{

    private AppComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
        this.component = buildComponent();
    }

    private AppComponent buildComponent()
    {
        return DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public AppComponent getAppComponent()
    {
        return this.component;
    }
}
