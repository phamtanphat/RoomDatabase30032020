package com.example.roomdatabase30032020.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase30032020.database.entity.WordEntity;
import com.example.roomdatabase30032020.repository.DatabaseRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {
    private Context mContext;
    private MutableLiveData<List<WordEntity>> mListWord;
    private DatabaseRepository mDatabaseRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();
        mListWord = new MutableLiveData<>();
        mDatabaseRepository = DatabaseRepository.getInstance(mContext);
    }

    // 1 : Phuong thuc de goi request
    public void onSelectListWord(){
        mDatabaseRepository
                .getListDataWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(List<WordEntity> wordEntities) {
                        mListWord.setValue(wordEntities);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    // 2 : Phuong thuc tra ve gia tri sau khi request
    public LiveData<List<WordEntity>> obserListWord(){
        return mListWord;
    }
}
