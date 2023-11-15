package com.example.lesson_6_migunova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_6_migunova.data_classes.EnergyDetails
import com.example.lesson_6_migunova.data_classes.ListItem
import com.example.lesson_6_migunova.data_classes.WaterDetails
import com.example.lesson_6_migunova.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)
    private val itemsAdapter = ItemsAdapter()

    private val listWaterItems = mutableListOf<ListItem.WaterDetailsItem>()
    private val listEnergyItems = mutableListOf<ListItem.EnergyDetailsItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.menu.findItem(R.id.lamp_item).setOnMenuItemClickListener {
            Toast.makeText(activity, "Свет", Toast.LENGTH_SHORT).show()
            true
        }

        binding.recyclerViewCategories.adapter = itemsAdapter.apply {
            infoListener = object : InfoListener {
                override fun onWaterInfoClick(waterDetails: WaterDetails) {
                    Snackbar.make(binding.root, waterDetails.item_name, Snackbar.LENGTH_SHORT).show()
                }

                override fun onEnergyInfoClick(energyDetails: EnergyDetails) {
                    Snackbar.make(binding.root, energyDetails.item_name, Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        listWaterItems.addAll(
            listOf(
                ListItem.WaterDetailsItem(
                    WaterDetails(
                        R.drawable.ic_water_cold,
                        getString(R.string.cold_water),
                        R.drawable.ic_serial_number,
                        getString(R.string.number),
                        R.drawable.ic_info,
                        R.drawable.shape,
                        getString(R.string.new_indications),
                        R.drawable.ic_alert,
                        getString(R.string.text_alert),
                    )
                ),
                ListItem.WaterDetailsItem(
                    WaterDetails(
                        R.drawable.ic_water_hot,
                        getString(R.string.hot_water),
                        R.drawable.ic_serial_number,
                        getString(R.string.number),
                        R.drawable.ic_info,
                        R.drawable.shape,
                        getString(R.string.new_indications),
                        R.drawable.ic_alert,
                        getString(R.string.text_alert),
                    )
                )
            )
        )

        listEnergyItems.addAll(
            listOf(
                ListItem.EnergyDetailsItem(
                    EnergyDetails(
                        R.drawable.ic_electro_copy,
                        getString(R.string.energy),
                        R.drawable.ic_serial_number,
                        getString(R.string.number),
                        R.drawable.ic_info,
                        R.drawable.shape,
                        getString(R.string.energy_text_alert),
                        getString(R.string.text_day),
                        getString(R.string.text_month),
                        getString(R.string.text_pick)
                    )
                ),
            )
        )

        itemsAdapter.setList(
            listOf(
                *listWaterItems.map { waterItem ->
                    val waterItem = WaterDetails(
                        image = waterItem.waterDetails.image,
                        item_name = waterItem.waterDetails.item_name,
                        barcode = waterItem.waterDetails.barcode,
                        serial_number = waterItem.waterDetails.serial_number,
                        info = waterItem.waterDetails.info,
                        three_dots_info = waterItem.waterDetails.three_dots_info,
                        new_indications = waterItem.waterDetails.new_indications,
                        icon_alert = waterItem.waterDetails.icon_alert,
                        text_alert = waterItem.waterDetails.text_alert,
                    )
                    ListItem.WaterDetailsItem(waterItem)
                }.toTypedArray(),
                *listEnergyItems.map { energyItem ->
                    val energyItem = EnergyDetails(
                        image = energyItem.energyDetails.image,
                        item_name = energyItem.energyDetails.item_name,
                        barcode = energyItem.energyDetails.barcode,
                        serial_number = energyItem.energyDetails.serial_number,
                        info = energyItem.energyDetails.info,
                        three_dots_info = energyItem.energyDetails.three_dots_info,
                        text_alert = energyItem.energyDetails.text_alert,
                        day = energyItem.energyDetails.day,
                        month = energyItem.energyDetails.month,
                        pick = energyItem.energyDetails.pick,
                    )
                    ListItem.EnergyDetailsItem(energyItem)
                }.toTypedArray()
            )
        )

        val space = (8 * resources.displayMetrics.density).toInt()
        binding.recyclerViewCategories.addItemDecoration(SpacingItemDecor(space, 1, true))
    }

    companion object {
        fun newInstance() : SecondFragment {
            return SecondFragment()
        }
    }
}