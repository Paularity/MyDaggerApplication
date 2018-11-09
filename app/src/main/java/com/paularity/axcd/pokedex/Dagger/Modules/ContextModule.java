package com.paularity.axcd.pokedex.Dagger.Modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module(includes = {FragmentModule.class})
public class ContextModule
{
    private Context context;

    public ContextModule(Context context)
    {
        this.context = context;
    }

    @Provides
    Context provideContext()
    {
        return this.context;
    }
}
