package com.example.lesson_4_migunova

sealed class ListItem {
    data class CategoryItem(val category: Category) : ListItem()

    data class Category1Item(val category1: Category1) : ListItem()
}
