package net.danieladrian.chordrepository.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import net.danieladrian.chordrepository.R;
import net.danieladrian.chordrepository.contract.activity.LoginActivityContract;
import net.danieladrian.chordrepository.presenter.activity.LoginActivityPresenter;
import net.danieladrian.chordrepository.utility.SharedPreference;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginActivityContract.View{
    @BindView(R.id.signin) SignInButton signin;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 500;
    SharedPreference sharedPreference;
    LoginActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        GoogleSignInOptions gso  = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signin.setOnClickListener(this);
        sharedPreference = new SharedPreference(getApplicationContext());
        mPresenter = new LoginActivityPresenter(getApplicationContext(),this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signin:
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent,RC_SIGN_IN );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            sharedPreference.setAccessToken(account.getIdToken());
            sharedPreference.setEmail(account.getEmail());
            sharedPreference.setName(account.getDisplayName());
            sharedPreference.setProfilePicture(account.getPhotoUrl().toString());
            sharedPreference.setUserID(account.getId());
            mPresenter.loginToServer();
            // Signed in successfully, show authenticated UI.
            //Log.d("login","sucess"+completedTask.getResult().getEmail()+completedTask.getResult().getId()+completedTask.getResult().getDisplayName()+completedTask.getResult().getPhotoUrl());
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Login", "signInResult:failed code=" + e.getStatusCode());

        }
    }

    @Override
    public void loginSuccess() {
        
    }
}
