package com.mu.jan.dagger2.Module;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.mu.jan.dagger2.RecyclerViewAdapter;

import javax.inject.Singleton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    Context context;

    public AdapterModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public RecyclerViewAdapter recyclerViewAdapter(){
        return new RecyclerViewAdapter(context);
    }
    @Provides
    @Singleton
    public LayoutInflater layoutInflater(){
        return LayoutInflater.from(context);
    }
    @Provides
    @Singleton
    public LinearLayoutManager linearLayoutManager(){ return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);}
    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

}
