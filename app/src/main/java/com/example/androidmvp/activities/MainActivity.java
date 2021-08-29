package com.example.androidmvp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Presenter;
import com.example.androidmvp.Contract;
import com.example.androidmvp.R;
import com.example.androidmvp.models.Model;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    // creating object of Presenter interface in Contract
    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        // instantiating object of Presenter Interface
        presenter = new Presenter(this, new Model());

        button.setOnClickListener(v -> presenter.onButtonClick());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    // method to display the Course Detail TextView
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    // method to hide the Course Detail TextView
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    // method to set random string
    // in the Course Detail TextView
    public void setString(String string) {
        textView.setText(string);
    }
}
