package ru.semenovmy.learning.fouractivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class MarketMap extends AppCompatActivity {

    private static final String SAVED_STRING_ONE = "STRING_ONE";
    private static final String SAVED_STRING_TWO = "STRING_TWO";
    private static final String SAVED_PARCEL = "PARCEL";

    public final String TAG = this.getClass().getName();

    private TestModel mTestModel;
    private String mButtonText;
    private Button mButton;
    private TextView mTextView;
    private String mTextViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_map);

        mTextView = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(this::onClick);

        mTextViewText = RandomStringUtils.randomAlphabetic(8);
        mButtonText = RandomStringUtils.randomNumeric(7);

        mTextView.setText(mTextViewText);
        mButton.setText(mButtonText);

        List<String> firstList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            firstList.add(RandomStringUtils.randomNumeric(5));
        }

        List<String> secondList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            secondList.add(RandomStringUtils.randomNumeric(5));
        }

        mTestModel = new TestModel(mTextViewText, mButtonText, firstList, secondList);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_STRING_ONE, mTextViewText);
        outState.putString(SAVED_STRING_TWO, mButtonText);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
        Log.d(TAG, new StringBuilder(TAG).append("onSaveInstanceState").toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mTextViewText = savedInstanceState.getString(SAVED_STRING_ONE);
        mButtonText = savedInstanceState.getString(SAVED_STRING_TWO);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        mButton.setText(mButtonText);
        mTextView.setText(mTextViewText);
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, new StringBuilder(TAG).append("onRestoreInstanceState").toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, new StringBuilder(TAG).append("onStart").toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, new StringBuilder(TAG).append("onResume").toString());

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, new StringBuilder(TAG).append("onPause").toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, new StringBuilder(TAG).append("onStop").toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, new StringBuilder(TAG).append("onDestroy").toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, new StringBuilder(TAG).append("onRestart").toString());
    }
}
