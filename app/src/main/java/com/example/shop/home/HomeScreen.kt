package com.example.shop.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop.R
import com.example.shop.home.components.Popular
import com.example.shop.home.components.ProductCart

val popularCart = ProductCart(
    image = "asdasd",
    favorites = false,
    inCart = false,
    status = "Best Seller",
    name = "Nike Air Max",
    price = "752.00"
)


@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp)
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
                    Text("Поиск", color = Color(106, 106, 106), fontSize = 12.sp, fontWeight = FontWeight(400))
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
                        modifier = Modifier.height(40.dp).width(108.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Все"
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Outdoor"
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Tennis"
                        )
                    }
                    Box(
                        modifier = Modifier.height(40.dp).width(134.dp).padding(start = 16.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(8.dp))),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Running"
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
                color = Color(72, 178, 231)
            )

        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Popular(popularCart)
            Popular(popularCart)
        }
//asd
        Row {

        }
    }

}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}