package com.androiddesdecero.musica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androiddesdecero.musica.service.Client;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rss.itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Client client = retrofit.create(Client.class);

        Call<Music> call1 = client.getMusic();
        call1.enqueue(new Callback<Music>() {
            @Override
            public void onResponse(Call<Music> call, Response<Music> response) {
                Music music = new Music();
                music = response.body();
                String text ="";
                for(int i=0; i<music.getFeed().getResults().size(); i++){
                    text += music.getFeed().getResults().get(i).getArtistName() + " "
                            + music.getFeed().getResults().get(i).getName() + " "
                            + music.getFeed().getResults().get(i).getCollectionName() + " "
                            + music.getFeed().getResults().get(i).getReleaseDate()
                            + "\n";
                }
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Music> call, Throwable t) {
                Log.d("TAG1", "Error");

            }
        });
    }
}
