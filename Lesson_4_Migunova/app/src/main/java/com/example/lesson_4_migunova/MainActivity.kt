package com.example.lesson_4_migunova

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson_4_migunova.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val itemsAdapter = ItemsAdapter()
    private val listItems = mutableListOf<ListItem.CategoryItem>()
    private val listItems1 = mutableListOf<ListItem.Category1Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = GridLayoutManager(this, 2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return itemsAdapter.getSpanSize(position)
            }
        }

        binding.recyclerViewCategories.layoutManager = layoutManager

        binding.toolbar.menu.findItem(R.id.info).setOnMenuItemClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Cообщение")
                .setMessage("Информация о приложении")
                .setPositiveButton("ОК") { dialog, _ -> dialog.cancel() }
                .show()
            true
        }

        binding.toolbar.menu.findItem(R.id.home).setOnMenuItemClickListener {
            Toast.makeText(this, "Сменить квартиру", Toast.LENGTH_SHORT).show()
            true
        }

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.recyclerViewCategories.adapter = itemsAdapter.apply {
            categoryListener = object : CategoryListener {
                override fun onCategoryClick(category: Category) {
                    Snackbar.make(binding.root, category.title, Snackbar.LENGTH_SHORT).show()
                }

                override fun onCategory1Click(category1: Category1) {
                    Snackbar.make(binding.root, category1.title, Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        listItems.addAll(
            listOf(
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_bill,
                        getString(R.string.bill_title),
                        getString(R.string.bill_description)
                    )
                ),
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_counter,
                        getString(R.string.counter_title),
                        getString(R.string.counter_description)
                    )
                ),
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_installment,
                        getString(R.string.installment_title),
                        getString(R.string.installment_description)
                    )
                ),
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_insurance,
                        getString(R.string.insurance_title),
                        getString(R.string.insurance_description)
                    )
                ),
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_tv,
                        getString(R.string.tv_title),
                        getString(R.string.tv_description)
                    )
                ),
                ListItem.CategoryItem(
                    Category(
                        R.drawable.ic_homephone,
                        getString(R.string.homephone_title),
                        getString(R.string.homephone_description)
                    )
                ),
            )
        )

        listItems1.addAll(
            listOf(
                ListItem.Category1Item(
                    Category1(
                        R.drawable.ic_security,
                        getString(R.string.security_title),
                        getString(R.string.security_description)
                    )
                ),
                ListItem.Category1Item(
                    Category1(
                        R.drawable.contacts_image,
                        getString(R.string.contacts),
                        getString(R.string.empty)
                    )
                ),
                ListItem.Category1Item(
                    Category1(
                        R.drawable.request_image,
                        getString(R.string.requests),
                        getString(R.string.empty)
                    )
                ),
                ListItem.Category1Item(
                    Category1(
                        R.drawable.memo_image,
                        getString(R.string.memo),
                        getString(R.string.empty)
                    )
                )
            )
        )

        itemsAdapter.setList(
            listOf(
                *listItems.map { categoryItem ->
                    val category = Category(
                        image = categoryItem.category.image,
                        title = categoryItem.category.title,
                        description = categoryItem.category.description
                    )
                    ListItem.CategoryItem(category)
                }.toTypedArray(),
                *listItems1.map { category1Item ->
                    val category1 = Category1(
                        image = category1Item.category1.image,
                        title = category1Item.category1.title,
                        description = category1Item.category1.description
                    )
                    ListItem.Category1Item(category1)
                }.toTypedArray()
            )
        )

        val space = (8 * resources.displayMetrics.density).toInt()
        binding.recyclerViewCategories.addItemDecoration(SpacingItemDecorator(space, 2, true))
    }
}