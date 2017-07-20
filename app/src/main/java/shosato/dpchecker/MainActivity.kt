package shosato.dpchecker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.TextView
import shosato.dpchecker.logic.DpStringGenerator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val dp = displayMetrics.densityDpi

        val generator :DpStringGenerator = DpStringGenerator()
        val dpContent = generator.getString(this, dp)
        val contentText: TextView = findViewById(R.id.dpContent) as TextView
        contentText.text = dpContent
        val contentNumText: TextView = findViewById(R.id.dpContentNum) as TextView
        contentNumText.text = dp.toString()

    }
}
