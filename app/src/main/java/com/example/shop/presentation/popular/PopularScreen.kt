package com.example.shop.presentation.popular

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.BootItem
import com.example.shop.presentation.components.ProductCart
import com.example.shop.presentation.home.HomeSc
import kotlinx.serialization.Serializable

@Serializable
data object PopularSc

@Composable
fun PopularScreen(navController: NavController) {

    Column() {
        Row(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier.height(44.dp).width(44.dp).clickable {
                    navController.navigate(HomeSc)
                }
            )
            Text(
                text = "Популярное",
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.favoriteinpopular),
                contentDescription = null,
                modifier = Modifier.height(44.dp).width(44.dp)
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalItemSpacing = 15.dp
        ) {
            items(list) {
                BootItem(it, navController)
            }
        }
    }

}

@Preview
@Composable
fun PopularScreenPreview() {

}
