package com.muzammil.teamtnt.am;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.ContentValues.TAG;

public class AmFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("AmFirebaseInstanceID", "Refreshed token: " + refreshedToken);

//        sendRegistrationToServer(refreshedToken);
    }
}
