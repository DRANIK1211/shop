package com.example.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shop.home.HomeScreen
import com.example.shop.onboard.Onboard
import com.example.shop.ui.theme.ShopTheme

@Composable 
fun BrightnessControl() {
    val context = LocalContext.current
    var isPopupVisible by remember { mutableStateOf(false) }
    val originalBrightness = remember { 
        Settings.System.getInt(
            context.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            255
        )
    }
    val main = Settings.System.getInt(
            context.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            255
        )

    Button(
        onClick = { 
            if (Settings.System.canWrite(context)) {
                Settings.System.putInt( 
        context.contentResolver,
        Settings.System.SCREEN_BRIGHTNESS,
        204
    )
                isPopupVisible = true
            } 
        }
    ){
        Text("Изменить яркость") 
    } 
    
    if (isPopupVisible) {
        Popup(onDismissRequest = {
            Settings.System.putInt( 
        context.contentResolver,
        Settings.System.SCREEN_BRIGHTNESS,
        204
    )
            isPopupVisible = false 
        }){
            Box(
                modifier = Modifier.fillMaxSize().clickable{
                    isPopupVisible = false 
            }){
                Text("Нажмите здесь, чтобы закрыть попап",
                    modifier = Modifier.clickable{ 
                        Settings.System.putInt( 
        context.contentResolver,
        Settings.System.SCREEN_BRIGHTNESS,
        main
    )
                        isPopupVisible = false
                })
            }
        }
    }
} 



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        actionBar?.hide()
        setContent {
            ShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        HomeScreen()




    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopTheme {

    }
}
