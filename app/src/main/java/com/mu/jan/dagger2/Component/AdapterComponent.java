package com.mu.jan.dagger2.Component;

import android.widget.Adapter;

import com.mu.jan.dagger2.MainActivity;
import com.mu.jan.dagger2.Module.AdapterModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AdapterModule.class})
public interface AdapterComponent {
    public void inject(MainActivity mainActivity);
}
