package com.example.shop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.catalog.CatalogScreen
import com.example.shop.presentation.components.Menu
import com.example.shop.presentation.details.DetailsScreen
import com.example.shop.presentation.favorites.FavoriteSc
import com.example.shop.presentation.favorites.FavoriteScreen
import com.example.shop.presentation.home.HomeSc
import com.example.shop.presentation.home.HomeScreen
import com.example.shop.presentation.mycart.MyCartSc
import com.example.shop.presentation.mycart.MyCartScreen
import com.example.shop.presentation.onboard.Onboard
import com.example.shop.presentation.onboard.OnboardScreen
import com.example.shop.presentation.popular.PopularSc
import com.example.shop.presentation.popular.PopularScreen
import com.example.shop.presentation.theme.ShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        actionBar?.hide()

        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController( )

            ShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        NavHost(navController = navController, startDestination = Onboard){
                            composable<Onboard> {
                                OnboardScreen(navController)
                            }
                            composable<HomeSc> {
                                Box{
                                    HomeScreen(navController = navController)
                                    Menu(modifier = Modifier.align(Alignment.BottomCenter),
                                        navController = navController, flag = 1)
                                }
                            }
                            composable<PopularSc>{
                                Box{
                                    PopularScreen(navController = navController)

                                }
                            }
                            composable("CatalogSc/{flag}") { backStackEntry ->
                                val param = backStackEntry.arguments?.getString("flag").toString()
                                CatalogScreen(navController, param)
                            }
                            composable<FavoriteSc> {
                                Box{
                                    FavoriteScreen(navController = navController)
                                    Menu(modifier = Modifier.align(Alignment.BottomCenter),
                                        navController = navController, flag = 2)
                                }
                            }
                            composable("Details/{flag}") { backStackEntry ->
                                val param = backStackEntry.arguments?.getString("flag").toString()
                                DetailsScreen(navController = navController, id = param)
                            }
                            composable<MyCartSc> {
                                MyCartScreen(navController = navController)
                            }
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,

    ) {


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopTheme {

    }
}