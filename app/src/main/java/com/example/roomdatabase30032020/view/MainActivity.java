package com.example.roomdatabase30032020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.roomdatabase30032020.R;
import com.example.roomdatabase30032020.database.DatabaseRoom;
import com.example.roomdatabase30032020.database.entity.WordEntity;
import com.example.roomdatabase30032020.viewmodel.MainViewModel;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new MainViewModel(getApplication());
//
        mainViewModel.obserListWord().observe(this, new Observer<List<WordEntity>>() {
            @Override
            public void onChanged(List<WordEntity> wordEntities) {
                Toast.makeText(MainActivity.this, wordEntities.size() + "", Toast.LENGTH_SHORT).show();
            }
        });

        mainViewModel.onSelectListWord();

//        mainViewModel.obserInserWord().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Toast.makeText(MainActivity.this, aLong + "", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainViewModel.onInSertWord(new WordEntity("Two","Hai"));

    }

}