package com.bohn.boomesh.syncadapterex.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.bohn.boomesh.syncadapterex.adapters.SyncAdapter;

/**
 * Created by Sumesh on 15-08-04.
 */
public class SyncService extends Service {

    private SyncAdapter mSyncAdapter;
    private final Object mSyncLock = new Object();

    @Override
    public void onCreate() {
        synchronized (mSyncLock) {
            if (mSyncAdapter == null) {
                mSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mSyncAdapter.getSyncAdapterBinder();
    }
}
