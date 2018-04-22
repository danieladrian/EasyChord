package net.danieladrian.chordrepository.utility;

import android.content.Context;

import net.danieladrian.chordrepository.BuildConfig;
import net.danieladrian.chordrepository.rest.api.ApiConstant;
import net.danieladrian.chordrepository.rest.api.ApiInterface;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel Adrian on 23/01/2018.
 */

public class RetrofitHelper {
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private OkHttpClient httpClient;
    SharedPreference sharedPreference;

    public RetrofitHelper(Context context ) {
        sharedPreference = new SharedPreference(context);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        try {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
//                    .sslSocketFactory(getSSLConfigWithMultipleCertificate(this).getSocketFactory())
                    .addNetworkInterceptor(interceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();

                            Log.send_debug_log("HELLOBILL OwnerApp","" + original);
                            // Request customization: add request headers
                            Request.Builder requestBuilder = original.newBuilder()
                                    //                        .header("Authorization", basic)
                                    .method(original.method(), original.body());

                            Request request = requestBuilder.build();

                            Log.send_debug_log("HELLOBILL OwnerApp","" + request.body());
                            Response response = chain.proceed(request);

                            ResponseBody responseBody = response.body();
                            String bodyString = responseBody.string();

                            /*
                            try {
                                ResultDefault resultDefault = new Gson().fromJson(bodyString, ResultDefault.class);
                                HelloBillUtil.showLog("intercept " + new Gson().toJson(resultDefault));
                                if (resultDefault != null) {
                                    if (resultDefault.Errors != null && resultDefault.Errors.size() > 0) {
                                        if (resultDefault.Status != null && resultDefault.Status == 1) {
                                            ResultDefault.Error error = resultDefault.Errors.get(0);
                                            if (error.ID.equalsIgnoreCase("TOKEN")) {
                                                HelloBillUtil.showLog("session habis");
                                                SharedPreferencesProvider.getInstance().setPref_session(HelloBillServiceActivity.this, "1");
                                                sendBroadcast(new Intent(SESSION_GONE));
                                                httpClient.dispatcher().cancelAll();
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {

                            }
                            */

                            Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), bodyString.getBytes())).build();
                            return newResponse;
                        }
                    }).build();
        } catch (Exception e) {

        }

        Retrofit.Builder retrofitBuilder =new Retrofit.Builder();
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.client(httpClient);
        retrofitBuilder.baseUrl(sharedPreference.getDevelopment() ? ApiConstant.BASE_URL : ApiConstant.BASE_URL_PRODUCTION);
        retrofit =retrofitBuilder.build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getInterface(){
        return apiInterface;
    }

}
