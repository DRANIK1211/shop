package com.example.shop.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.data.Boot


@Composable
fun BootItem(
    cart: Boot,
    onChangedFav: (id: String) -> Unit,
    onChangedCart: (id: String) -> Unit,
    onClick: (id: String) -> Unit
) {


    var stateFav = remember { mutableStateOf(cart.favorites) }
    var stateCart = remember { mutableStateOf(cart.count) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(150.dp)//.height(182.dp)
            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(16.dp)))
            .clickable {

                onClick(cart.id)
            }

    ) {
        Column(
            modifier = Modifier.padding(top = 9.dp, start = 9.dp, end = 9.dp)
        ) {
            Image(
                imageVector = if (stateFav.value) ImageVector.vectorResource(R.drawable.favbotinfav)
                else ImageVector.vectorResource(R.drawable.favorite),
                contentDescription = null,
                modifier = Modifier
                    .height(28.dp)
                    .width(28.dp)
                    .clickable {
                        onChangedFav(cart.id)
                    }
            )
            Image(
                painter = painterResource(R.drawable.botinok),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            )
            Text(
                text = cart.status,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(72, 178, 231),
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = cart.name,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(106, 106, 106),
                modifier = Modifier.padding(top = 8.dp)
            )


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "₽" + cart.price,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(start = 9.dp),
                textAlign = TextAlign.End
            )
            var im = ImageVector.vectorResource(R.drawable.add)
            if (stateCart.value > 0)
                im = ImageVector.vectorResource(R.drawable.incart)
            else
                im = ImageVector.vectorResource(R.drawable.add)

            Image(
                imageVector = im,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onChangedCart(cart.id)
                }
            )
        }


    }
}

@Preview
@Composable
fun PopularPreview() {

}