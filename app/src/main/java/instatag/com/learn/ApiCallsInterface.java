package instatag.com.learn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by RahulReign on 16-04-2018.
 */

public interface ApiCallsInterface {

    //here we require to place post request
    @POST("readcontacts.php")//this is end point of base url
        Call<List<Contact>> getContact();
    //getContact() is a instance of Call class that target List<Contact> that contain Object Contact
    //for every method their must b a notation that represent http url and possible base url end points


//Step 4:Create adapter for RecyclerView

}
