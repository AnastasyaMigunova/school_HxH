package com.example.lesson_4_migunova

sealed class ListItem {
    data class DetailInfoItem(val detailInfo: DetailInfo) : ListItem()

    data class BaseInfoItem(val baseInfo: BaseInfo) : ListItem()
}
