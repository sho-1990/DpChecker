package shosato.dpchecker.logic

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import shosato.dpchecker.R

/**
 * densityから対応する出力用文字列、リソースIDを生成する
 */
class DpOutputGenerator {

    val mMetricsMap:MutableMap<Int, Int> = mutableMapOf(
            DisplayMetrics.DENSITY_DEFAULT to R.string.density_default,
            DisplayMetrics.DENSITY_HIGH    to R.string.density_high,
            DisplayMetrics.DENSITY_LOW     to R.string.density_low,
            DisplayMetrics.DENSITY_MEDIUM  to R.string.density_medium,
            DisplayMetrics.DENSITY_TV      to R.string.density_tv,
            DisplayMetrics.DENSITY_XHIGH   to R.string.density_xhigh,
            DisplayMetrics.DENSITY_XXHIGH  to R.string.density_xxhigh,
            DisplayMetrics.DENSITY_XXXHIGH to R.string.density_xxxhigh
    )

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            mMetricsMap[DisplayMetrics.DENSITY_260] = R.string.density_260
            mMetricsMap[DisplayMetrics.DENSITY_280] = R.string.density_280
            mMetricsMap[DisplayMetrics.DENSITY_300] = R.string.density_300
            mMetricsMap[DisplayMetrics.DENSITY_340] = R.string.density_340
            mMetricsMap[DisplayMetrics.DENSITY_360] = R.string.density_360
            mMetricsMap[DisplayMetrics.DENSITY_400] = R.string.density_400
            mMetricsMap[DisplayMetrics.DENSITY_420] = R.string.density_420
            mMetricsMap[DisplayMetrics.DENSITY_560] = R.string.density_560
        }
    }

    fun getId(density :Int): Int? {
        return mMetricsMap[density]
    }

    fun getString(context: Context, density: Int): String? {
        mMetricsMap[density]?.let {
            return context.resources.getString(it)
        } ?: return null

    }
}