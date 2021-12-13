package com.androidlearn.digiandroid.ui.help;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidlearn.digiandroid.R;
import com.androidlearn.digiandroid.api.IService;
import com.androidlearn.digiandroid.api.RetrofitClient;
import com.androidlearn.digiandroid.models.Category;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        Observable.just("First" , "Second" , "Third" , "Four" , "Five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("","");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.e("","");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("","");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("","");
                    }
                });

        IService iService = RetrofitClient.INSTANCE.getRetrofit().create(IService.class);


        iService.getCategory().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Category>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("","");
                        Log.e("","");
                    }

                    @Override
                    public void onNext(@NonNull Category category) {
                    Log.e("","");
                    Log.e("","");

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("","");
                        Log.e("","");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("","");
                        Log.e("","");
                    }
                });


    }
}