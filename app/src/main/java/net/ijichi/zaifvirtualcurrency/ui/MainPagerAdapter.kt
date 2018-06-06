package net.ijichi.zaifvirtualcurrency.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * pager adapter
 * Created by ijichiyoshihito on 2018/06/05.
 */
class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BtcJpyFragment()
            else -> throw Exception()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "BTC/JPY"
            else -> throw Exception()
        }
    }

    override fun getCount(): Int {
        return 1
    }

}
