package com.Assignment.Product.User.Config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class userConfig {
	 public static String BASE_URL ="http://localhost:9091/";

	    private static Retrofit.Builder builder = new Retrofit.Builder()
	            .baseUrl(BASE_URL)
	            .addConverterFactory(GsonConverterFactory.create());

	    private static Retrofit retrofit = builder.build();

	    private static OkHttpClient.Builder httpClient =
	            new OkHttpClient.Builder();

	    public static <S> S createService(Class<S> serviceClass){
	        builder.client(httpClient.build());
	        retrofit = builder.build();
	        return retrofit.create(serviceClass);
	    }
}
