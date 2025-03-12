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
//SIDE BAR ВЫЗВАТЬ ОБЕ ФУНКЦИИ В НАВИГАЦИИ   сделай .graphicsLayer(rotationZ = -5f)
@Composable
fun BodyContent() {//ДЛЯ HOME
    var navigateClick by remember { mutableStateOf(false) }
    val offSetAnim by animateDpAsState(targetValue = if (navigateClick) 253.dp else 0.dp)
    val scaleAnim by animateFloatAsState(targetValue = if (navigateClick) 0.6f else 1.0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scale(scaleAnim)
            .offset(x = offSetAnim)
            .clip(if (navigateClick) RoundedCornerShape(30.dp) else RoundedCornerShape(0.dp))
            .graphicsLayer(rotationZ = if (navigateClick) -5f else 0f)
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {/*СЮДА ПИХАТЬ HOME*/}  
}

@Composable
fun NavigationDrawer() {// ДЛЯ SIDEBAR
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(72, 178, 231))
    ) {/*СЮДА ПИХАТЬ SIDE MENU*/}
        
}


//ЯРКОСТЬ ЭКРАНА!!! + ШТРИХ КОД

dependencies {
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
}

fun generateBarcode(content: String): Bitmap? { // ГЕНЕРИРУЕТ КОД
    val writer = QRCodeWriter()
    return try {
        val bitMatrix: BitMatrix = writer.encode(content, BarcodeFormat.CODE_128, 600, 300)//УКАЗАТЬ РАЗМЕРЫ
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        bmp
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }
}

@Composable
fun BarcodeComposable(content: String) { // ОТОБРАЖАЕТ КОД
    val barcodeBitmap: Bitmap? = remember { generateBarcode(content) }
    barcodeBitmap?.let {
        Image(bitmap = it.asImageBitmap(), contentDescription = "Штрих-код")
    }
}

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
    // ДОЛЖЕН БЫТЬ ШТРИХ КОД
    
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
//КОНЕЦ!


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
