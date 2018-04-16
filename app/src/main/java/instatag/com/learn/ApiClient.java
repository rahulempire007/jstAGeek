package instatag.com.learn;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RahulReign on 16-04-2018.
 */

public class ApiClient {
    public static final String BASE_URL="https://api.myjson.com/bins/bal6n/";
    public  static Retrofit retrofit=null;

    // step 2:define a method that return instance of retrofit

    public  static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            //this will return the instance of retrofit

        }
        return  retrofit;

    }
// step3: now next step is to define interface for api calls

}
