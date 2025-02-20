package com.example.shop.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.mycart.MyCartSc
import com.example.shop.presentation.favorites.FavoriteSc
import com.example.shop.presentation.home.HomeSc
import com.example.shop.presentation.theme.ShopTheme

@Composable
fun Menu(modifier: Modifier, navController: NavController, flag: Int) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(bottom = 0.dp)

            //.background(Color.Gray),
    ) {
        //navController.currentBackStackEntry.destination.
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.menu1),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().background(Color.Transparent)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.incart2),
                contentDescription = null,
                modifier = Modifier.height(65.dp).width(65.dp).clickable {
                    navController.navigate(MyCartSc)
                }

            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().height(106.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row (
                modifier = Modifier.width(120.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    imageVector = if (flag==1) ImageVector.vectorResource(R.drawable.home_active)
                    else ImageVector.vectorResource(R.drawable.homedis),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {
                        navController.navigate(HomeSc)
                    }
                )
                Image(
                    imageVector = if (flag==2) ImageVector.vectorResource(R.drawable.favoriteactive)
                    else ImageVector.vectorResource(R.drawable.favorites_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {
                        navController.navigate(FavoriteSc)
                    }
                )
            }
            Row (
                modifier = Modifier.width(120.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    imageVector = if (flag==3) ImageVector.vectorResource(R.drawable.noticactive)
                    else ImageVector.vectorResource(R.drawable.notification_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
                Image(
                    imageVector = if (flag==4) ImageVector.vectorResource(R.drawable.profileactive)
                    else ImageVector.vectorResource(R.drawable.profile_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
            }
        }

    }
}

@Preview
@Composable
fun MenuPreview() {
    ShopTheme {

    }

}