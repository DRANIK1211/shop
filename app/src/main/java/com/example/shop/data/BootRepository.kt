package com.example.shop.data

import kotlinx.coroutines.flow.MutableStateFlow

data class Boot(
    var image: String,
    var favorites: Boolean,
    var count: Int,
    var status: String,
    var name: String,
    var price: String,
    var id: String,
    var desc: String,
    var smallImages: List<String>,
    var gender: String,
    var category: String
)

enum class Category {
    Tennis,
    Outdoor,
    Running
}


object BootRepository {

    private val _boots: List<Boot> = mutableListOf(
        Boot(
            image = "https://e-mm.ru/files/holder/88/b9/88b964d885bdf258c166a5a1423c9db0.jpg",
            favorites = false,
            count = 0,
            status = "BEST SELLER",
            name = "Зимние боты",
            price = "6500",
            id = "0",
            desc = "Зимние боты для настоящих мужиков. Бери и на рыбалку",
            smallImages = listOf(
                "https://e-mm.ru/files/holder/88/b9/88b964d885bdf258c166a5a1423c9db0.jpg",
                "https://e-mm.ru/files/holder/4a/7f/4a7f6b33d81412a0a1be1daa58f56669.jpg",
                "https://e-mm.ru/files/holder/04/34/0434994140def538d708023efe31d01f.jpg",
                "https://e-mm.ru/files/holder/db/c1/dbc1374b901eef2de43e0d906f8f703e.jpg"
            ),
            gender = "Men's Shoes",
            category = Category.Tennis.name
        ),

        Boot(
            image = "https://kimex.kz/upload/iblock/aac/5llbryq9thu3hja9bcfp9fh3pczdi2kz.png",
            favorites = false,
            count = 0,
            status = "BEST SELLER",
            name = "Зимние боты",
            price = "10900",
            id = "1",
            desc = "специально для трассы",
            smallImages = listOf(
                "https://kimex.kz/upload/iblock/aac/5llbryq9thu3hja9bcfp9fh3pczdi2kz.png",
                "https://image-thumbs.shafastatic.net/1531909957_310_430"
            ),
            gender = "Women's Shoes",
            category = Category.Running.name
        ),

        Boot(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjIcpKLNxeOv3PanFjo0_qFYFOFdnakfPqDw&s",
            favorites = false,
            count = 0,
            status = "BEST SELLER",
            name = "Кросы",
            price = "10900",
            id = "2",
            desc = "в футбик погонять",
            smallImages = listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjIcpKLNxeOv3PanFjo0_qFYFOFdnakfPqDw&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5PRwQPOIpYX34DLFIfR-aI58Zuf_kvX3JcQaqEYFSlP4nxAS9boZopocHm4uu4CbGalI&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRafHvk9pCzPUHMlQr5uuCDgaIrX7tpbI5oUAM-OYIL97wECuVfbNee5d9NGyXb-owtfP4&usqp=CAU"
            ),
            gender = "Shoes",
            category = Category.Outdoor.name
        ),

        Boot(
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMpGA3GbuRNj0HmhhzIbLjUZ13Ccr2mg12gNMpoiYv3Suzijzt6QF-RIyKb6kzlMvsI9Y&usqp=CAU",
            favorites = false,
            count = 0,
            status = "BEST SELLER",
            name = "Кросы",
            price = "13900",
            id = "3",
            desc = "в клуб сходить",
            smallImages = listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMpGA3GbuRNj0HmhhzIbLjUZ13Ccr2mg12gNMpoiYv3Suzijzt6QF-RIyKb6kzlMvsI9Y&usqp=CAU",
                "https://ir.ozone.ru/s3/multimedia-h/c1000/6709754093.jpg",
                "https://ir.ozone.ru/s3/multimedia-1-1/c400/6983012905.jpg"
            ),
            gender = "Women's Shoes",
            category = Category.Outdoor.name
        ),

        Boot(
            image = "https://tzro.ru/wp-content/uploads/2022/12/310-7.jpg",
            favorites = false,
            count = 0,
            status = "BEST SELLER",
            name = "Кросы",
            price = "10900",
            id = "4",
            desc = "рыба",
            smallImages = listOf(
                "https://tzro.ru/wp-content/uploads/2022/12/310-7.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZAuZ_i_oeA0eBnku4tJDfI4E82F3mpFNQZYCOjcsRAA8NsEQZcOA5wDVV_kBRKjvBdfk&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMhELVhnDpzJ4T-ZoYv7YeScRKGUH6ENw-dla_QvTuMvSuvLJL5zpSS-e6BcAinRpyCWo&usqp=CAU"
            ),
            gender = "Women's Shoes",
            category = Category.Tennis.name
        ),


        )

    val boots = MutableStateFlow(_boots)

    fun setFav(id: String) {
        var item = _boots.find { it.id == id }
        var st = item?.favorites ?: false
        item?.favorites = !st
    }

    fun setCart(id: String) {
        var item = _boots.find { it.id == id }
        item?.count = item?.count!! + 1
    }

    fun dec(id: String) {
        var item = _boots.find { it.id == id }
        item?.count = item?.count!! - 1
    }


}