package com.example.mainza1992.movieapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.mainza1992.movieapi.model.movieDetailsModel.MovieDetailsModel;
import com.example.mainza1992.movieapi.services.ConnectionService;
import com.example.mainza1992.movieapi.services.IRequestInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    IRequestInterface iRequestInterface;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int itemId = getIntent().getIntExtra("id",0);

        iRequestInterface = ConnectionService.getConnectionService();
        iRequestInterface.getMovieDetail(itemId,API_Constants.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSucess,this::onError);

           textView= (TextView) findViewById(R.id.textView);

    }

    private void onError(Throwable throwable) {

        Log.i("details",throwable.getMessage());

    }

    private void onSucess(MovieDetailsModel movieDetailsModel) {

        textView.setText(movieDetailsModel.getTitle());

    }


}
