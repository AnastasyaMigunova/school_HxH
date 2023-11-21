package com.example.lesson_6_migunova

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecor(
    private val padding: Int,
    private val span: Int,
    private val includeEdge: Boolean
) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % span

        if (includeEdge) {
            outRect.left = padding - column * padding / span
            outRect.right = (column + 1) * padding / span

            if (position < span) {
                outRect.top = padding
            }
            outRect.bottom = padding
        } else {
            outRect.left = column * padding / span
            outRect.right = padding - (column + 1) * padding / span

            if (position >= span) {
                outRect.top = padding
            }
        }
    }
}