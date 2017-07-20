package shosato.dpchecker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import shosato.dpchecker.logic.DpStringGenerator

class MainActivity : AppCompatActivity() {

    lateinit var mAdView :AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, resources.getString(R.string.banner_ad_unit_id))
        loadAd()

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

    override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mAdView.destroy()
    }

    override fun onPause() {
        super.onPause()
        mAdView.pause()
    }

    private fun loadAd() {
        mAdView = findViewById(R.id.adView) as AdView
        val adRequest :AdRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
