package com.gdg.donation

import com.gdg.donation.donationcenter.DCFunding
import com.gdg.donation.donationcenter.Product

val dummyDCFundingList : List<DCFunding> = listOf(
    DCFunding(
        image = "",
        collectedAmount = 70,
        targetAmount = 100,
        title = "카레 재료 모으기 프로젝트",
        writer = "그린 아동센터",
        dc_tag = "아동복지",
        product_1 = "감자",
        product_2 = "토마토",
        product_3 = "양파",
        deadline_alarm = "마감 임박",
        deadline_dday = "D-3"
    ),
    DCFunding(
        image = "",
        collectedAmount = 20,
        targetAmount = 100,
        title = "밥상 나누기 프로젝트",
        writer = "푸드뱅크",
        dc_tag = "노인복지",
        product_1 = "쌀",
        product_2 = "김치",
        product_3 = "된장",
        deadline_alarm = "마감 임박",
        deadline_dday = "D-5"
    ),
    DCFunding(
        image = "https://example.com/images/3.jpg",
        collectedAmount = 40,
        targetAmount = 100,
        title = "겨울 의류 지원",
        writer = "사랑의 열매",
        dc_tag = "의류지원",
        product_1 = "겨울 코트",
        product_2 = "모자",
        product_3 = "장갑",
        deadline_alarm = "마감 임박",
        deadline_dday = "D-2"
    ),
    DCFunding(
        image = "https://example.com/images/4.jpg",
        collectedAmount = 0,
        targetAmount = 100,
        title = "농산물 기부 프로젝트",
        writer = "농부의 손길",
        dc_tag = "농산물 기부",
        product_1 = "사과",
        product_2 = "배",
        product_3 = "귤",
        deadline_alarm = "",
        deadline_dday = "D-10"
    ),
    DCFunding(
        image = "https://example.com/images/5.jpg",
        collectedAmount = 110,
        targetAmount = 100,
        title = "방한용품 지원 프로젝트",
        writer = "희망 온돌",
        dc_tag = "방한용품 지원",
        product_1 = "담요",
        product_2 = "온열매트",
        product_3 = "손난로",
        deadline_alarm = "마감 임박",
        deadline_dday = "D-1"
    )
)

val dummyImageUrlList = listOf(
    "",
    "",
    "",
)

val dummyProductList = listOf(
    Product(
        image = "",
        targetAmount = 10,
        collectedAmount = 7,
        name = "Potato"
    ),
    Product(
        image = "",
        targetAmount = 15,
        collectedAmount = 10,
        name = "Carrot"
    ),
    Product(
        image = "",
        targetAmount = 20,
        collectedAmount = 5,
        name = "Onion"
    )
)