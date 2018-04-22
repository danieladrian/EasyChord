package net.danieladrian.chordrepository.utility;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Daniel Adrian on 23/01/2018.
 */

public class IntentHelper {
    public static void startIntent(Context mContext, Class className, Bundle bundle){
        Intent intent=new Intent(mContext,className);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public static void startNewIntent(Context mContext,Class className, Bundle bundle){
        Intent intent=new Intent(mContext,className);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public static void startIntent(Context mContext, Class className){
        Intent intent=new Intent(mContext,className);
        mContext.startActivity(intent);
    }

    public static void startNewIntent(Context mContext,Class className){
        Intent intent=new Intent(mContext,className);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
