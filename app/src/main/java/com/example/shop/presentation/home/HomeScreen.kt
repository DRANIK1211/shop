package com.example.shop.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.catalog.CatalogSc
import com.example.shop.presentation.components.Popular
import com.example.shop.presentation.components.ProductCart
import com.example.shop.presentation.popular.PopularSc
import kotlinx.serialization.Serializable

val popularCart = ProductCart(
    image = "asdasd",
    favorites = false,
    inCart = false,
    status = "Best Seller",
    name = "Nike Air Max",
    price = "752.00"
)
val popularCart1 = ProductCart(
    image = "asdasd",
    favorites = false,
    inCart = true,
    status = "Best Seller",
    name = "Nike Air Max",
    price = "752.00"
)

@Serializable
data object HomeSc

@Composable
fun HomeScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp, bottom = 30.dp).verticalScroll(
            state = rememberScrollState()
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.hamburger),
                contentDescription = null,
                modifier = Modifier.width(26.dp).height(18.dp)
            )
            Text(
                text = "Главная",
                fontSize = 32.sp,
                fontWeight = FontWeight(400),
                color = Color(43, 43, 43)
            )
            Box(){
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.basket),
                    contentDescription = null,
                    modifier = Modifier.width(44.dp).height(44.dp)
                )
                Box(Modifier.background(Color.Red, shape = CircleShape).align(Alignment.TopEnd).size(8.dp,8.dp))
            }

        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(top=21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val search = remember { mutableStateOf("") }
            OutlinedTextField(
                value = search.value,
                onValueChange = {search.value = it},
                modifier = Modifier.width(269.dp).height(52.dp)
                    .clip(
                        shape = RoundedCornerShape(corner = CornerSize(14.dp))
                    ),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                leadingIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.search_icon),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(
                        text = "Поиск",
                        color = Color(106, 106, 106),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400))
                }
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.filters),
                contentDescription = null,
                Modifier.height(52.dp).width(52.dp),
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 22.dp)
        ) {
            Text(
                text = "Категории",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),

            )

            LazyRow(
                Modifier.padding(top=19.dp, bottom = 24.dp)
            ){
                item {
                    Box(
                        modifier = Modifier.height(40.dp).width(108.dp).clickable {
                            navController.navigate("CatalogSc/Все")
                        }
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Все",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp).clickable {
                            navController.navigate("CatalogSc/Outdoor")
                        }
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Outdoor",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp).clickable {
                            navController.navigate("CatalogSc/Tennis")
                        }
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Tennis",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp).clickable {
                            navController.navigate("CatalogSc/Running")
                        }
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Running",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                text = "Популярное",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),

            )
            Text(
                text = "Все",
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(72, 178, 231),
                modifier = Modifier.clickable {
                    navController.navigate(PopularSc)
                }
            )

        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(top=30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Popular(popularCart)
            Popular(popularCart1)
        }
//asd
        Row(
            modifier = Modifier.fillMaxWidth().padding(top=29.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                text = "Акции",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),

                )
            Text(
                text = "Все",
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(72, 178, 231)
            )

        }

        Image(
            painter = painterResource(R.drawable.special),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().padding(top=20.dp),
            contentScale = ContentScale.FillWidth
        )
    }

}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview(){
}