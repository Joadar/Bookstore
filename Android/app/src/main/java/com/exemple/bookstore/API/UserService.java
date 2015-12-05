package com.exemple.bookstore.API;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Jonathan on 28/11/2015.
 */
public class UserService {

    private RestInterface restInterface;

    public UserService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restInterface = retrofit.create(RestInterface.class);
    }

    public void getUsers(Callback callback){
        restInterface.listUsers().enqueue(callback);
    }

    public void getUserById(int id, Callback callback){
        restInterface.getUser(id).enqueue(callback);
    }

}
