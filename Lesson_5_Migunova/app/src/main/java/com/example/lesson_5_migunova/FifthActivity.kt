package com.example.lesson_5_migunova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_5_migunova.databinding.ActivityFifthBinding

class  FifthActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityFifthBinding::bind)

    private var data : Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        binding.buttonDeliverResult.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(KEY_QUERY, binding.editText.text?.toString().orEmpty())
            })
            finish()
        }

        binding.buttonSaveText.setOnClickListener {
            val text = binding.editText.text.toString()
            data = Data(text)
            binding.textViewSaved.text = text
        }

        if (data != null) {
            binding.textViewSaved.text = data?.value
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_TEXT, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        data = savedInstanceState.getParcelable(KEY_TEXT)
        binding.textViewSaved.text = data?.value ?: ""
    }

    companion object {
        const val KEY_QUERY = "key_query"
        const val KEY_TEXT = "key_text"

        fun createStartIntent(context: Context): Intent {
            return Intent(context, FifthActivity::class.java)
        }
    }
}