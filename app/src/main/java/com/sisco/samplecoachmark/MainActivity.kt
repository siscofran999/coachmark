package com.sisco.samplecoachmark

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.sisco.coachmark.CoachMarkSequence
import com.sisco.coachmark.Gravity
import com.sisco.samplecoachmark.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coachMarkSequence = CoachMarkSequence(this)
        coachMarkSequence.apply {
            addItem(
                binding.txvTop,
                getString(R.string.title_top),
                getString(R.string.lorem_ipsum_text)
            )
            addItem(
                targetView = binding.txvStartTop,
                title = getString(R.string.title_start_top),
                subTitle = getString(R.string.lorem_ipsum_text),
                gravity = Gravity.END_BOTTOM
            )
            addItem(
                binding.txvEndTop,
                getString(R.string.title_end_top),
                getString(R.string.lorem_ipsum_text)
            )
            addItem(
                binding.txvEndBottom,
                getString(R.string.title_end_bottom),
                getString(R.string.lorem_ipsum_text)
            )
            addItem(
                binding.txvStartBottom,
                getString(R.string.title_start_bottom),
                getString(R.string.lorem_ipsum_text)
            )
            addItem(
                targetView = binding.txvBottom,
                title = getString(R.string.title_bottom),
                subTitle = getString(R.string.lorem_ipsum_text),
                positiveButtonText = getString(R.string.label_btn_explore),
                skipButtonText = null
            )
            start(window?.decorView as ViewGroup)
            setOnFinishCallback {
                Toast.makeText(this@MainActivity,
                    getString(R.string.label_finish), Toast.LENGTH_SHORT).show()
            }
        }
    }
}