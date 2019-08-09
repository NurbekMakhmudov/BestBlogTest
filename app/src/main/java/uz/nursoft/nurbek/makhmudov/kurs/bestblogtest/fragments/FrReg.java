package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.R;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.networks.ServerConnectionServiceR1;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.retmet.RetMet;

public class FrReg extends Fragment {

    private EditText frRegUserNameEt, frRegPassEt, frRegConfirmPassEt;
    private Button frRegSignInBtn;
    private ProgressBar frRegProgressBar;
    private ScrollView frRegScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_reg, container, false);

        findListener(view);

        return view;
    }

    private void findListener(View view) {
        frRegProgressBar = (ProgressBar) view.findViewById(R.id.frRegProgressBar);
        frRegProgressBar.setVisibility(View.GONE);
        frRegScrollView = (ScrollView) view.findViewById(R.id.frRegScrollView);
        frRegScrollView.setVisibility(View.VISIBLE);

        frRegUserNameEt = (EditText) view.findViewById(R.id.frRegUserNameEt);
        frRegPassEt = (EditText) view.findViewById(R.id.frRegPassEt);
        frRegConfirmPassEt = (EditText) view.findViewById(R.id.frRegConfirmPassEt);

        frRegSignInBtn = (Button) view.findViewById(R.id.frRegSignInBtn);
        frRegSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToServer();
            }
        });
    }

    private void addDataToServer() {
        if (RetMet.getInstance(getActivity()).checkInternetConnection()) {
            if (checkEt()) {

                visibilityPBar(true);

                ServerConnectionServiceR1.getInstance().getServerApiR1().registration(
                        frRegUserNameEt.getText().toString(),
                        frRegPassEt.getText().toString(),
                        new Callback<Response>() {
                            String out = "";

                            @Override
                            public void success(Response response, Response response2) {
                                try {
                                    BufferedReader reader = new BufferedReader(
                                            new InputStreamReader(response.getBody().in()));
                                    out = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                jsonParser(out);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.d("MyTag", getClass().getName()
                                        + " >> failure: RetrofitError = " + error.getMessage());
                                visibilityPBar(false);
                            }
                        }
                );
            }
        } else {
            RetMet.getInstance(getActivity()).toast(R.string.problem_internet, 1);
        }
    }

    private void jsonParser(String json) {
        Log.d("MyTag", getClass().getName() + " >> jsonParser: JSON = " + json);



        visibilityPBar(false);
    }


    private void visibilityPBar(boolean visibilityPBar) {
        if (visibilityPBar) {
            frRegScrollView.setVisibility(View.GONE);
            frRegProgressBar.setVisibility(View.VISIBLE);
        } else {
            frRegScrollView.setVisibility(View.VISIBLE);
            frRegProgressBar.setVisibility(View.GONE);
        }
    }


    private boolean checkEt() {
        String error = "";

        if (TextUtils.isEmpty(frRegUserNameEt.getText().toString())) {
            error += "\n User Name empty \n";
        }

        if (TextUtils.isEmpty(frRegPassEt.getText().toString())) {
            error += "\n Password empty \n";
        }

        if (TextUtils.isEmpty(frRegConfirmPassEt.getText().toString())) {
            error += "\n Confirm password empty \n";
        }

        if (!frRegPassEt.getText().toString().equals(frRegConfirmPassEt.getText().toString())) {
            error += "\n Password with Confirm password does not match \n";
        }

        if (!error.equals("")) {
            Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

}
