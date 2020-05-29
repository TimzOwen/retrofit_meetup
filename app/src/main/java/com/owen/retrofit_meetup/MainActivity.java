package com.owen.retrofit_meetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define listview and find the id
        final ListView listView = findViewById(R.id.list_view);

        //create Retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HeroesApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //build the API class
        HeroesApi heroesApi = retrofit.create(HeroesApi.class);

        //call the API class
        Call<List<Heroes>> call = heroesApi.getHeroes();

        //Now call th API
        call.enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {

                //get the list of data from the body
                List<Heroes>  heroes = response.body();

                //create an array to store heroes names
                String[] heroesNames = new String[heroes.size()];

                //loop only names
                for (int i=0; i<heroes.size(); i++){
                    heroesNames[i] = heroes.get(i).getName();

                }
                //loop between the heroes
//                for(Heroes h: heroes){
//                    Log.d("name" ,"" + h.getName());
//                    Log.d("realname","" + h.getRealname());
//                    Log.d("imgurl", "" + h.getImgurl());

                //now display the hero names in list view
                listView.setAdapter(new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        heroesNames
                ));
            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}