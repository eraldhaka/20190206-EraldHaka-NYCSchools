package org.a20190206_eraldhaka_nycschools.data.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static org.a20190206_eraldhaka_nycschools.util.Constants.BASE_URL;

public class APIClient {

    private static Retrofit retrofit = null;
    public static API getData() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(API.class);
    }
}





