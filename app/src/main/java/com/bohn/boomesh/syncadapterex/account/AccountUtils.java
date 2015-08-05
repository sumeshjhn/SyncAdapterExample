package com.bohn.boomesh.syncadapterex.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

/**
 * Created by Sumesh on 15-08-04.
 */
public class AccountUtils {
    private static final String TAG = AccountUtils.class.getSimpleName();

    private static final String AUTHORITY = "com.bohn.boomesh.syncadapterex.provider";
    private static final String ACCOUNT_TYPE = "boomesh.bohn.com";
    private static final String ACCOUNT = "dummyaccount";

    public static Account createSyncAccount(final Context context) {
        final Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        final AccountManager accountManager = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);

        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            // syncable=false ? set it programatically here
        } else {
            // account exists ? log it
            Log.e(TAG, newAccount.toString());
        }
        return newAccount;
    }
}
