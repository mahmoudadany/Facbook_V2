package com.mahmoudadany.facbookv2.data;

import com.mahmoudadany.facbookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClint {
    private static PostClint instance;
    private PostInterface postInterface;
    private Retrofit retrofit;
    private PostClint(){
        retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface=retrofit.create(PostInterface.class);
    }

    public synchronized static PostClint getInstance(){
        if(instance==null){
            instance=new PostClint();
        }
        return instance;
    }

    public Observable<List<PostModel>> getAllPost(){
       return postInterface.getPosts();
    }
}
