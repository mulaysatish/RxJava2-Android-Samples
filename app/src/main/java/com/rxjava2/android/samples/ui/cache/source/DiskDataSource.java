package com.rxjava2.android.samples.ui.cache.source;

import com.rxjava2.android.samples.ui.cache.model.Data;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class DiskDataSource {

    private Data data;

    public Observable<Data> getData() {
        return Observable.create(new ObservableOnSubscribe<Data>() {
            @Override
            public void subscribe(ObservableEmitter<Data> emitter) throws Exception {
                if (data != null) {
                    emitter.onNext(data);
                }
                emitter.onComplete();
            }
        });
    }

    public void saveToDisk(Data data) {
        this.data = data.clone();
        this.data.source = "disk";
    }

}
