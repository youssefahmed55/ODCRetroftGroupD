package com.example.odcretroftgroupd

import android.util.Log
import androidx.activity.result.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.odcretroftgroupd.pojo.PostModelResonseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActvityViewModel"
class MainActvityViewModel : ViewModel(){

    private val _postsList =   MutableStateFlow<List<PostModelResonseItem>>(emptyList())
    val postsList = _postsList.asStateFlow()

    private val _post = MutableStateFlow<PostModelResonseItem?>(PostModelResonseItem())
    val post = _post.asStateFlow()

    init {
        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val api = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(JsonPlaceHolderApi::class.java)

                _postsList.value = api.getPosts()
                _post.value =  api.getPostsById(5)
            } catch (e: Exception) {
                Log.d(TAG, "Error getPosts: ${e.message}")
            }
        }
    }
}