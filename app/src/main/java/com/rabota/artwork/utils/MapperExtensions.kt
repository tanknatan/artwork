package com.rabota.artwork.utils

import com.rabota.artwork.data.ProductInfoDto
import com.rabota.artwork.domain.ProductInfo

fun ProductInfoDto.toProductInfo() = ProductInfo(
    icon = icon,
    rating = rating,
    text1 = text1,
    text2 = text2,
    text3 = text3,
    text4 = text4,
    text5 = text5,
    text6 = text6,
    text7 = text7,
    text8 = text8,
    text9 = text9,
    text10 = text10,
    text11 = text11,
    text12 = text12,
    link1 = link1,
    link2 = link2,
    link3 = link3,
    link13 = link13,
    linkTextButton = linkTextButton,
    text14 = text14,
    newBlock = newBlock,
    logo1 = logo1,
    logo2 = logo2,
    link = link,
    textbutton = textbutton,
)

fun List<ProductInfoDto>.toProductInfoList() = map(ProductInfoDto::toProductInfo)