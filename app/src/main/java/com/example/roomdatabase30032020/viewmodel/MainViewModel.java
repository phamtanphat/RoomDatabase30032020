package com.example.roomdatabase30032020.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomdatabase30032020.database.entity.WordEntity;
import com.example.roomdatabase30032020.repository.DatabaseRepository;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {
    private Context mContext;
    private MutableLiveData<List<WordEntity>> mListWord;
    private MutableLiveData<Long> mRowIdWord;
    private MutableLiveData<String> mUpdateWord;
    private MutableLiveData<String> mDeleteWord;
    private DatabaseRepository mDatabaseRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();
        mListWord = new MutableLiveData<>();
        mRowIdWord = new MutableLiveData<>();
        mUpdateWord = new MutableLiveData<>();
        mDeleteWord = new MutableLiveData<>();
        mDatabaseRepository = DatabaseRepository.getInstance(mContext);
    }

    // 1 : Phuong thuc de goi request
    public void onSelectListWord(){
        mDatabaseRepository
                .getListDataWord()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<WordEntity> wordEntities) {
                        mListWord.setValue(wordEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void onInSertWord(WordEntity wordEntity){
        mDatabaseRepository
                .insertWord(wordEntity)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mRowIdWord.setValue(aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void onDeleteWord(WordEntity wordEntity){
        mDatabaseRepository
                .deleteWord(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        mDeleteWord.setValue("Thanh cong");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void onUpdateWord(WordEntity wordEntity){
        mDatabaseRepository
                .updateWord(wordEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        mUpdateWord.setValue("Thanh cong");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    // 2 : Phuong thuc tra ve gia tri sau khi request
    public LiveData<List<WordEntity>> obserListWord(){
        return mListWord;
    }
    public LiveData<Long> obserInserWord(){
        return mRowIdWord;
    }
    public LiveData<String> obserDeleteWord(){
        return mDeleteWord;
    }
    public LiveData<String> obserUpdateWord(){
        return mUpdateWord;
    }
}
