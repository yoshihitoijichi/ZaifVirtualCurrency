package net.ijichi.zaifvirtualcurrency.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import net.ijichi.zaifvirtualcurrency.ui.fragment.BtcJpyFragment
import net.ijichi.zaifvirtualcurrency.ui.fragment.MonaBtcFragment
import net.ijichi.zaifvirtualcurrency.ui.fragment.MonaJpyFragment
import net.ijichi.zaifvirtualcurrency.ui.fragment.XemJpyFragment

/**
 * pager adapter
 * Created by ijichiyoshihito on 2018/06/05.
 */
class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BtcJpyFragment()
            1 -> XemJpyFragment()
            2 -> MonaJpyFragment()
            3 -> MonaBtcFragment()
            else -> throw Exception()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "BTC/JPY"
            1 -> "XEM/JPY"
            2 -> "MONA/JPY"
            3 -> "MONA/BTC"
            else -> throw Exception()
        }
    }

    override fun getCount(): Int {
        return 4
    }

}
