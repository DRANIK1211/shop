package com.example.shop.data

import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest



object SupabaseClient {

    val supabase = createSupabaseClient(
        supabaseUrl = "https://mxgczkzrgljpkojsrxwi.supabase.co",
        supabaseKey = "oxl06lepdLfCVPXzL+FaBSMbxcxdMmzjY9/jZ/UEAJHi8bS/2Wx4bqhXPyICvEbHgHFgZG3EDo/JisEP5KW4Bg=="
    ) {
        install(Postgrest)
    }
    suspend fun signUpNewUser(email:String,password:String):UserInfo? {
        return supabase.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }

    }



}