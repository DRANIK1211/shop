package com.example.shop.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.mycart.MyCartSc
import com.example.shop.presentation.home.HomeSc
import kotlinx.serialization.Serializable

@Serializable
data object DetailsSc

data class DetailsCros(
    val name: String,
    val gender: String,
    val sale: String,
    val smallImages: List<String>,
    val desc: String,
    val favorite: Boolean,
    val inCart: Boolean
)

@Composable
fun DetailsScreen(navController: NavController, id: String) {
    val detailsProduct = DetailsCros(
        name = "Nike Air Max 270 Essential",
        gender = "Men’s Shoes",
        sale = "179.39",
        smallImages = listOf("asd", "dsa", "sdf", "fds", "dfg", "gfd", "fgh", "hgf"),
        desc = "Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн",
        favorite = false,
        inCart = false
    )

    val stateFav = remember { mutableStateOf(detailsProduct.favorite) }
    val stateCart = remember { mutableStateOf(detailsProduct.inCart) }


    Column {

        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                Text(
                    text = "Sneaker Shop",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
                Box() {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.basket),
                        contentDescription = null,
                        modifier = Modifier
                            .width(44.dp)
                            .height(44.dp).clickable {
                                navController.navigate(MyCartSc)
                            }
                    )
                    Box(
                        Modifier
                            .background(Color.Red, shape = CircleShape)
                            .align(Alignment.TopEnd)
                            .size(8.dp, 8.dp)
                    )
                }
            }

            Text(
                text = detailsProduct.name,
                fontSize = 26.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top = 6.dp)
            )

            Text(
                text = detailsProduct.gender,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(106, 106, 106),
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "₽" + detailsProduct.sale,
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top = 11.dp)

            )
            var flag = remember { mutableStateOf(0) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(R.drawable.lineindetails),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 83.dp)
                        .align(alignment = Alignment.Center)
                )
                Image(
                    painter = painterResource(R.drawable.botinok),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(241.dp)
                        .height(125.dp)
                        .align(alignment = Alignment.Center)
                )
            }

            LazyRow(
                modifier = Modifier.padding(top = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(detailsProduct.smallImages) { it ->
                    Box(
                        modifier = Modifier
                            .background(Color(255, 255, 255), shape = RoundedCornerShape(16.dp))
                            .width(56.dp)
                            .height(56.dp)
                            .clickable {
                                flag.value = detailsProduct.smallImages.indexOf(it)
                            }
                            .border(
                                width = 3.dp,
                                color = if (flag.value == detailsProduct.smallImages.indexOf(it))
                                    Color(72, 178, 231)
                                else Color.White,
                                shape = RoundedCornerShape(16.dp)
                            ),

                        ) {
                        Image(
                            painter = painterResource(R.drawable.botinok),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center),
                        )
                    }
                }
            }
            val statusText = remember { mutableStateOf(false) }
            Text(
                text = detailsProduct.desc,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(106, 106, 106),

                maxLines = if(!statusText.value) 3 else Int.MAX_VALUE,
                overflow = if(!statusText.value) TextOverflow.Ellipsis else TextOverflow.Visible
            )
            Text(
                text = "Подробнее",
                color = Color(72, 178, 231),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top=5.dp).align(Alignment.End).clickable {
                    if(statusText.value) statusText.value = false else statusText.value = true
                },

            )


        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp).fillMaxWidth()
        ) {
            val im = if(stateFav.value)
                painterResource(R.drawable.favbotinfav)
            else
                painterResource(R.drawable.favorite101)
            Image(
                painter = im,
                contentDescription = null,
                modifier = Modifier.height(52.dp).width(52.dp).clickable {
                    if(stateFav.value)
                        stateFav.value = false
                    else
                        stateFav.value = true
                }
            )
            IconButton(
                onClick = {
                    if(stateCart.value)
                        stateCart.value = false
                    else
                        stateCart.value = true
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(72, 178, 231),
                    disabledContainerColor = Color(72, 178, 231)
                ),
                modifier = Modifier.border(width = 10.dp, shape = RoundedCornerShape(12.dp),
                    color = Color(72, 178, 231)).height(52.dp).width(245.dp),

            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.incart2),
                        contentDescription = null,
                        modifier = Modifier.width(52.dp).height(52.dp).align(Alignment.CenterStart)
                    )
                    Text(
                        text = if(!stateCart.value)"В корзину" else "Добавлено",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color.White
                    )
                }

            }
        }
    }

}
