package Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.retrocalls.ApiClient;
import com.retrocalls.ApiInterface;
import com.retrocalls.ImageResponses;
import com.retrocalls.Images;
import com.retrocalls.R;
import com.retrocalls.StaggeredRecyclerAdapter;
import com.retrocalls.row;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.retrocalls.ApiInterface.API_KEY;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;

    private  RecyclerView staggeredRv;
    private StaggeredRecyclerAdapter adapter;
    private StaggeredGridLayoutManager manager;

    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        //aticivty full screen for better ui
        getSupportActionBar().hide();


        staggeredRv = findViewById(R.id.staggeredRv);
        manager= new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredRv.setLayoutManager(manager);
        imageLoad();


        //List of Images
        /*List<row> lst = new ArrayList<>();
        lst.add(new row(R.drawable.avengers));
        lst.add(new row(R.drawable.aladdin));
        lst.add(new row(R.drawable.angel));
        lst.add(new row(R.drawable.cate));
        lst.add(new row(R.drawable.deadpool));
        lst.add(new row(R.drawable.fine));
        lst.add(new row(R.drawable.hugh));
        lst.add(new row(R.drawable.pi));
        lst.add(new row(R.drawable.pp));
        lst.add(new row(R.drawable.ralph));
        lst.add(new row(R.drawable.robert));
        lst.add(new row(R.drawable.stark));
        lst.add(new row(R.drawable.terminator));
        lst.add(new row(R.drawable.wig));
        lst.add(new row(R.drawable.xmen));

        adapter = new StaggeredRecyclerAdapter(this,lst);
        staggeredRv.setAdapter(adapter);*/


    }

    public void imageLoad(){
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<ImageResponses> call = apiInterface.getPopularImages(API_KEY);
        call.enqueue(new Callback<ImageResponses>() {
            @Override
            public void onResponse(Call<ImageResponses> call, Response<ImageResponses> response) {
                ArrayList<Images> images = response.body().getResults();
                StaggeredRecyclerAdapter staggeredRecyclerAdapter = new StaggeredRecyclerAdapter(getApplicationContext(), images);
                staggeredRv.setAdapter(staggeredRecyclerAdapter);
                staggeredRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            }

            @Override
            public void onFailure(Call<ImageResponses> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });


    }

}
