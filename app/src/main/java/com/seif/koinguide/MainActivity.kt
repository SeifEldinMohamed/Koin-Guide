package com.seif.koinguide

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seif.koinguide.presentation.MainViewModel
import com.seif.koinguide.ui.theme.KoinGuideTheme
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {
    override val scope: Scope by activityScope() // will be recreated and reInjected when configuration change happened
    val hello by inject<String>(named("hello"))
    val bye by inject<String>(named("bye"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //    private val viewModel by viewModel<MainViewModel>()

        setContent {
            KoinGuideTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = getViewModel<MainViewModel>()
                viewModel.doNetworkCall()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Greeting("Android $hello")
                        Spacer(modifier = Modifier.height(8.dp))
                        Greeting("Android $bye")
                    }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoinGuideTheme {
        Greeting("Android")
    }
}