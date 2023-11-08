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
    private val listItems = mutableListOf<ListItem.DetailInfoItem>()
    private val listItems1 = mutableListOf<ListItem.BaseInfoItem>()

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
            infoListener = object : InfoListener {
                override fun onDetailInfoClick(detailInfo: DetailInfo) {
                    Snackbar.make(binding.root, detailInfo.title, Snackbar.LENGTH_SHORT).show()
                }

                override fun onBaseInfoClick(baseInfo: BaseInfo) {
                    Snackbar.make(binding.root, baseInfo.title, Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        listItems.addAll(
            listOf(
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_bill,
                        getString(R.string.bill_title),
                        getString(R.string.bill_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_counter,
                        getString(R.string.counter_title),
                        getString(R.string.counter_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_installment,
                        getString(R.string.installment_title),
                        getString(R.string.installment_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_insurance,
                        getString(R.string.insurance_title),
                        getString(R.string.insurance_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_tv,
                        getString(R.string.tv_title),
                        getString(R.string.tv_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_homephone,
                        getString(R.string.homephone_title),
                        getString(R.string.homephone_description)
                    )
                ),
                ListItem.DetailInfoItem(
                    DetailInfo(
                        R.drawable.ic_security,
                        getString(R.string.security_title),
                        getString(R.string.security_description)
                    )
                )
            )
        )

        listItems1.addAll(
            listOf(
                ListItem.BaseInfoItem(
                    BaseInfo(
                        R.drawable.contacts_image,
                        getString(R.string.contacts)
                    )
                ),
                ListItem.BaseInfoItem(
                    BaseInfo(
                        R.drawable.request_image,
                        getString(R.string.requests)
                    )
                ),
                ListItem.BaseInfoItem(
                    BaseInfo(
                        R.drawable.memo_image,
                        getString(R.string.memo)
                    )
                )
            )
        )

        itemsAdapter.setList(
            listOf(
                *listItems.map { detailInfoItem ->
                    val detailInfo = DetailInfo(
                        image = detailInfoItem.detailInfo.image,
                        title = detailInfoItem.detailInfo.title,
                        description = detailInfoItem.detailInfo.description
                    )
                    ListItem.DetailInfoItem(detailInfo)
                }.toTypedArray(),
                *listItems1.map { baseInfoItem ->
                    val baseInfo = BaseInfo(
                        image = baseInfoItem.baseInfo.image,
                        title = baseInfoItem.baseInfo.title,
                    )
                    ListItem.BaseInfoItem(baseInfo)
                }.toTypedArray()
            )
        )

        val space = (8 * resources.displayMetrics.density).toInt()
        binding.recyclerViewCategories.addItemDecoration(SpacingItemDecorator(space, 2, true))
    }
}