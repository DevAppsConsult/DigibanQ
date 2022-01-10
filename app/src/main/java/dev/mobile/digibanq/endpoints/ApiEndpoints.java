package dev.mobile.digibanq.endpoints;

import dev.mobile.digibanq.api.*;
import retrofit.Call;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Field;
import retrofit.http.POST;

/**
 * Created by finxl-isaac on 12/4/16.
 */

public interface ApiEndpoints {
    @FormUrlEncoded
    @POST("register")
    Call<UserDetails> regitser(@Field("full_name") String first, @Field("dob") String dob,@Field("phone") String phone, @Field("email") String email, @Field("password") String password,@Field("code") String code);
    @FormUrlEncoded
    @POST("login")
    Call<UserDetails> login(@Field("phone") String phone,@Field("password") String password);
    //
    @FormUrlEncoded
    @POST("forgot_password")
    Call<UserDetails> forgotPassword(@Field("email") String email,@Field("code") String codes);
    @FormUrlEncoded
    @POST("new_password")
    Call<UserDetails> newPassword(@Field("email") String email,@Field("password") String password);


}
