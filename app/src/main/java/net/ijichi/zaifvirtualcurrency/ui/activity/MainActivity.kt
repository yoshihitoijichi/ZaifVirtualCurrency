package net.ijichi.zaifvirtualcurrency.ui.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import net.ijichi.cryptocurrencychecker.api.service.ZaifService
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.enum.ExchangeType
import net.ijichi.zaifvirtualcurrency.api.model.extension.fetch
import net.ijichi.zaifvirtualcurrency.databinding.ActivityMainBinding
import net.ijichi.zaifvirtualcurrency.ui.MainPagerAdapter
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val service = ZaifService()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = MainPagerAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = adapter
        binding.mainTabLayout.setupWithViewPager(binding.mainViewPager)

        binding.mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                Timber.i("position:$position")
            }
        })

        val exchangeType: ExchangeType = ExchangeType.BTC_JPY

        service.getLastPrice(exchangeType).fetch({
            Timber.i("onSuccess lastPrice:${it.lastPrice}")
        },{
            Timber.e(it)
        })

        service.getTicker(exchangeType).fetch({
            Timber.i("onSuccess ticker:$it")
        },{
            Timber.e(it)
        })

        service.getTrades(exchangeType).fetch({
            Timber.i("onSuccess trades:$it")
        },{
            Timber.e(it)
        })

        service.getDepth(exchangeType).fetch({
            Timber.i("onSuccess depth:$it")
        },{
            Timber.e(it)
        })

        service.getCurrencyPairs(ZaifService.CurrencyPairType.ALL).fetch({
            Timber.i("onSuccess currencyPairs:$it")
        },{
            Timber.e(it)
        })

        service.getCurrencies(ZaifService.CurrencyType.ALL).fetch({
            Timber.i("onSuccess currencies:$it")
        },{
            Timber.e(it)
        })



    }
}

