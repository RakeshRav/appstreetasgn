package com.appstreetasgn.mainActivity;

import android.util.Log;

import com.appstreetasgn.retrofitSetup.APIController;
import com.appstreetasgn.retrofitSetup.GithubAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainAPIPresenter {


    private static final String TAG = MainPresenter.class.getSimpleName();
    private final int POS_CHAR = 10;

    public MainPresenter(MainActivityPresenter mainActivityPresenter){
        setMainActivityPresenter(mainActivityPresenter);
    }

    public MainActivityPresenter getMainActivityPresenter() {
        return mainActivityPresenter;
    }

    public void setMainActivityPresenter(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    private MainActivityPresenter mainActivityPresenter;

    @Override
    public void getReposList() {

        GithubAPI githubAPI = APIController.getApiBase();

        Call<ResponseBody> call = githubAPI.getReposList("java", "weekly");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    InputStream in = response.body().byteStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder result = new StringBuilder();
                    String line = null;
                    try {
                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }
                        in.close();
                        Log.d(TAG, "blogText : " + result.toString());

                    } catch (Exception e) {
                        Log.d(TAG, "Excep : " + e.getMessage());
                    }
                } else {
                    Log.d(TAG, "Api Err : " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
