package com.androidlearn.digiandroid.ui.category;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidlearn.digiandroid.api.IService;
import com.androidlearn.digiandroid.api.RetrofitClient;
import com.androidlearn.digiandroid.models.Category;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {

    MutableLiveData<Category> mutableLiveData=null;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Category> getCategory(){

        if(mutableLiveData==null) {
            mutableLiveData = new MutableLiveData<>();
        }
        loadCategory();

        return  mutableLiveData;

    }
    private void loadCategory(){

        IService iService = RetrofitClient.INSTANCE.getRetrofit().create(IService.class);


        iService.category().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {

                mutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                //mutableLiveData.setValue();
                Log.e("","");
            }
        });


    }




}
