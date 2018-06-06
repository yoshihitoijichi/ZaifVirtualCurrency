package net.ijichi.zaifvirtualcurrency.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.ijichi.zaifvirtualcurrency.R
import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.enum.ExchangeType
import net.ijichi.zaifvirtualcurrency.api.service.StreamService
import net.ijichi.zaifvirtualcurrency.databinding.FragmentBtcJpyBinding
import net.ijichi.zaifvirtualcurrency.ui.adapter.BtcJpyRecyclerAdapter
import timber.log.Timber

/**
 * btc/jpy fragment
 * Created by ijichiyoshihito on 2018/06/05.
 */
class  BtcJpyFragment : Fragment() {

    private lateinit var binding: FragmentBtcJpyBinding

    private var adapter: BtcJpyRecyclerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_btc_jpy, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupView()

        val streamService = StreamService()
        streamService.start(ExchangeType.BTC_JPY) {
            Timber.i("streamStatus:$it")
            activity?.runOnUiThread {
                Timber.i("adapter?.add(it)")
                adapter?.addAllTop(it.trades)
            }
        }
    }

    private fun setupView(){
        binding.btcJpyRefresh.setOnRefreshListener {
            reload()
        }

        binding.btcJpyRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // divider
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.btcJpyRecycler.addItemDecoration(itemDecoration)

        binding.btcJpyRecycler.setHasFixedSize(false)
        binding.btcJpyRecycler.itemAnimator = DefaultItemAnimator()
        // 要素変更時のアニメーションを抑止して、ちらつきを防ぐ
        (binding.btcJpyRecycler.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
        binding.btcJpyRecycler.overScrollMode = View.OVER_SCROLL_ALWAYS

        adapter?.let {
            binding.btcJpyRecycler.adapter = it
//            hideProgress()
        } ?: run {
            initAdapter()
        }
    }

    private fun initAdapter(){
        Timber.i("initAdapter()")
        adapter = BtcJpyRecyclerAdapter(context, ArrayList()) {
            Timber.i("adapter on click")
//            mPresenter?.onClickItem(it)
        }
        binding.btcJpyRecycler.adapter = adapter
    }

    private fun reload(){
        Timber.i("reload()")

        Handler().postDelayed({
            binding.btcJpyRefresh.isRefreshing = false
        }, 1000)
    }
}