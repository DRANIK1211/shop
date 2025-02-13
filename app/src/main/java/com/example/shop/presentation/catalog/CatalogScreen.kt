package com.example.shop.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.Popular
import com.example.shop.presentation.components.ProductCart
import com.example.shop.presentation.home.HomeSc
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable


@Serializable
data object CatalogSc

@Composable
fun CatalogScreen(navController: NavController, flag: String) {

    var category = remember { mutableStateOf(flag) }


    var list = mutableListOf<ProductCart>(
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        ),
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        ),
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        ),
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        ),
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        )
    )
    Column() {
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
        ) {

            Text(
                text = category.value,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .height(44.dp)
                    .width(44.dp)
                    .clickable {
                        navController.navigate(HomeSc)
                    }
            )

        }
        val cats = listOf("Все", "Outdoor", "Tennis", "Running")
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        LaunchedEffect(scope) {
            listState.animateScrollToItem(cats.indexOf(category.value))
        }

        LazyRow(
            modifier = Modifier.padding(top = 16.dp, bottom = 20.dp, start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            state = listState
        ) {
            items(cats) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(108.dp)
                        .clickable {
                            category.value = it
                        }
                        .background(
                            color = if (it == category.value) Color(72, 178, 231) else Color.White,
                            shape = RoundedCornerShape(corner = CornerSize(8.dp))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = if (category.value == it) Color.White else Color.Black
                    )
                }
            }
        }


        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalItemSpacing = 15.dp
        ) {
            items(list) {
                Popular(it)
            }
        }


    }
}

@Composable
fun CatalogScreenPreview() {
    CatalogScreen(navController = rememberNavController(), "Все")
}
