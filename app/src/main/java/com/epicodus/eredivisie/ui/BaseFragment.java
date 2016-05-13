package com.epicodus.eredivisie.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.eredivisie.Constants;
import com.epicodus.eredivisie.R;
import com.firebase.client.Firebase;

public class BaseFragment extends Fragment {
    public Firebase mFirebaseRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    }

    public void logout() {
        mFirebaseRef.unauth();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}
