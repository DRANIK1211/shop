package com.example.shop.home.components

import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop.R


data class ProductCart(
    val image: String,
    val favorites: Boolean,
    val inCart: Boolean,
    val status: String,
    val name: String,
    val price: String
)

@Composable
fun Popular(cart: ProductCart){
    Card (
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.width(160.dp).height(182.dp)
            .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(16.dp))),
        //verticalArrangement = Arrangement.SpaceBetween,

    ){
        Column(
            modifier = Modifier.padding(top = 9.dp, start = 9.dp, end = 9.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.favorite),
                contentDescription = null
            )
            Image(
                painter = painterResource(R.drawable.botinok),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(70.dp)
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

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.add),
                contentDescription = null
            )
        }




    }
}

@Preview
@Composable
fun PopularPreview(){
    Popular(
        ProductCart(
            image = "asdasd",
            favorites = false,
            inCart = false,
            status = "Best Seller",
            name = "Nike Air Max",
            price = "752.00"
        )
    )
}