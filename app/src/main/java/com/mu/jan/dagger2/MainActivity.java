package com.mu.jan.dagger2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.JavascriptInterface;

import com.mu.jan.dagger2.Component.AdapterComponent;
import com.mu.jan.dagger2.Component.DaggerAdapterComponent;
import com.mu.jan.dagger2.Module.AdapterModule;

import javax.inject.Inject;

/**
 * This is the demonstration of how to use dagger 2
 * Dagger 2 is a dependency injection framework
 * Used for providing instance of class from outside
 *
 * Main components :
 * 1. @Module : This class provides all method which provides instance of classes or dependency
 * 2. @inject : This class is used for injecting dependency
 * 3. @component : This class contains all methods which we define in @Module class, if we miss any of these, we get compile error
 * 4. @Provides : In @Module class, methods have @Provides which means these methods have return type
 * 5. @Singleton : In @Module class, methods have @Singleton which means when we call these methods, instance must
 * be created only once
 */

public class MainActivity extends AppCompatActivity {

    private AdapterComponent adapterComponent;
    @Inject RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Inject LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init dagger 2
        adapterComponent = DaggerAdapterComponent.builder()
                .adapterModule(new AdapterModule(MainActivity.this))
                .build();

        //inject
        adapterComponent.inject(MainActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
