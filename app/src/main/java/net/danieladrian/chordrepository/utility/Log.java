package net.danieladrian.chordrepository.utility;

/**
 * Created by Daniel Adrian on 6/17/2017.
 */

public class Log {
    public static void send_debug_log(String class_name,String message){
        android.util.Log.d(class_name,message);
    }

    public static void send_error_log(String class_name,String message){
        android.util.Log.e(class_name,message);
    }
}
