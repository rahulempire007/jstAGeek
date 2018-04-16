package instatag.com.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private List<Contact> contactList;
    private ApiCallsInterface apiCallsInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recylerIdk);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //now we can maske the request\
//below is the api interace intstance by  using this we call the appropriate method in that interface
        apiCallsInterface=ApiClient.getApiClient().create(ApiCallsInterface.class);
        //in create methof pass the apicalls interface class name
        //now we have to save this in call class instance
        Call<List<Contact>> listCall=apiCallsInterface.getContact();

        //now we hav to make or call a method enqueu that cocntain some callback like onResponse and onFailure
        //these two mathod run on main ui thread so we can publish the result on recyclerview

        listCall.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                if(response.body()==null){
                    Toast.makeText(MainActivity.this,"Null Kyu aa rha hei sala",Toast.LENGTH_SHORT).show();
                }else {
                    // mAdapter = new StationsAdapter(response.body());
                    //mRecyclerView.setAdapter(mAdapter);

                    contactList = response.body();
                    Log.e("response.body()", String.valueOf(response.body()));
                    //this will return the result list that contain contact
                    //now intiailize adapter below
                    adapter = new Adapter(contactList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Hi",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
