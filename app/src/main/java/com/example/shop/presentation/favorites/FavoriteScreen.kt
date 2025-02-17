package com.example.shop.presentation.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.Popular
import com.example.shop.presentation.components.ProductCart
import com.example.shop.presentation.home.HomeSc
import com.example.shop.presentation.home.popularCart
import com.example.shop.presentation.home.popularCart1
import com.example.shop.presentation.popular.PopularSc
import kotlinx.serialization.Serializable

@Serializable
data object FavoriteSc

@Composable
fun FavoriteScreen(navController: NavController){

    var list = mutableListOf<ProductCart>(
        ProductCart(
            image = "asdasd",
            favorites = true,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00",
            id = "123"
        ),
        ProductCart(
            image = "asdasd",
            favorites = true,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00",
            id = "123"
        ),
        ProductCart(
            image = "asdasd",
            favorites = true,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00",
            id = "123"
        ),
        ProductCart(
            image = "asdasd",
            favorites = true,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00",
            id = "123"
        ),
        ProductCart(
            image = "asdasd",
            favorites = true,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00",
            id = "123"
        )
    )
    Column(
        Modifier.padding(bottom = 100.dp)
    ) {
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
                text = "Избранное",
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.favactive),
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
                Popular(it, navController)
            }
        }
    }
}
