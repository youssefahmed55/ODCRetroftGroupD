package com.example.odcretroftgroupd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.odcretroftgroupd.ui.theme.ODCRetroftGroupDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ODCRetroftGroupDTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainActvityViewModel = viewModel()){
    val posts by viewModel.postsList.collectAsState()
    val post by viewModel.post.collectAsState()
    LazyColumn{
        /*items(posts){
            Text(text = it.body ?: "", modifier = Modifier.padding(16.dp))
        }*/
        item {
            Text(text = post?.body ?: "", modifier = Modifier.padding(16.dp))
        }




    }
}