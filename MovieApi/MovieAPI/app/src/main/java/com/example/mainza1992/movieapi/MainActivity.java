package com.example.mainza1992.movieapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mainza1992.movieapi.model.MovieListModel;
import com.example.mainza1992.movieapi.model.Result;
import com.example.mainza1992.movieapi.services.ConnectionService;
import com.example.mainza1992.movieapi.services.IRequestInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
    private IRequestInterface iRequestInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connection service
        iRequestInterface = ConnectionService.getConnectionService();
        iRequestInterface.getMovieList("65cec66457a6bad59c45f52c0dbdb984")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSucess,this::onError);

        initializeRecycler();


    }

    private void onSucess(MovieListModel movieListModel) {


        //attach adapter to layout
        recyclerView.setAdapter(new MovieListAdapter(movieListModel,R.layout.list_item_movie,getApplicationContext(),new onClickListener(){

            @Override
            public void onItemClick(Result item) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("id",item.getId());
                startActivity(i);

            }



        }));
    }

    private void onError(Throwable throwable) {
        Log.i("MovieList",throwable.getMessage());
    }

      public void initializeRecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



      }


    public interface onClickListener {
        void onItemClick(Result item);

        }
}
