package net.ijichi.zaifvirtualcurrency.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
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
import net.ijichi.zaifvirtualcurrency.databinding.FragmentTabBinding
import net.ijichi.zaifvirtualcurrency.ui.adapter.AbstractRecyclerAdapter

abstract class AbstractTabFragment<D> : Fragment() {

    private lateinit var binding: FragmentTabBinding
    protected var adapter: AbstractRecyclerAdapter<D>? = null

    abstract val streamExchangeType: ExchangeType
    private var streamService = StreamService()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()

        streamService.start(streamExchangeType) {
            activity?.runOnUiThread {
                onUpdate(it)
            }
        }
    }

    private fun setupView() {
        binding.tabRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // divider
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.tabRecycler.addItemDecoration(itemDecoration)

        binding.tabRecycler.setHasFixedSize(false)
        binding.tabRecycler.itemAnimator = DefaultItemAnimator()
        // 要素変更時のアニメーションを抑止して、ちらつきを防ぐ
        (binding.tabRecycler.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
        binding.tabRecycler.overScrollMode = View.OVER_SCROLL_ALWAYS

        if (adapter == null) {
            adapter = initAdapter()
        }
        binding.tabRecycler.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        streamService.disconnect()
    }

    abstract fun initAdapter(): AbstractRecyclerAdapter<D>

    abstract fun onUpdate(streamStatus: StreamStatus)
}