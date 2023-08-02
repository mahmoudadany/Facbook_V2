package com.mahmoudadany.facbookv2.ui.main;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahmoudadany.facbookv2.data.PostClint;
import com.mahmoudadany.facbookv2.pojo.PostModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    public MutableLiveData<List<PostModel>> liveData=new MutableLiveData<>();

    public void getAllPosts(){
        PostClint clint=PostClint.getInstance();
       Observable observable= clint.getAllPost()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

        Observer<List<PostModel>> observer=new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<PostModel> postModels) {
                liveData.setValue(postModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "adany onError: "+e);
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
