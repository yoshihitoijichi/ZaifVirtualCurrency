package net.ijichi.zaifvirtualcurrency.ui.fragment

import net.ijichi.zaifvirtualcurrency.api.model.entity.StreamStatus
import net.ijichi.zaifvirtualcurrency.api.model.entity.Trade
import net.ijichi.zaifvirtualcurrency.api.model.enum.ExchangeType
import net.ijichi.zaifvirtualcurrency.ui.adapter.AbstractRecyclerAdapter
import net.ijichi.zaifvirtualcurrency.ui.adapter.StreamAdapter
import timber.log.Timber

/**
 * mona/btc fragment
 * Created by ijichiyoshihito on 2018/06/05.
 */
class MonaBtcFragment : AbstractTabFragment<Trade>() {

    override val streamExchangeType: ExchangeType
        get() = ExchangeType.MONA_BTC

    override fun initAdapter(): AbstractRecyclerAdapter<Trade> {
        return StreamAdapter(context, ArrayList()) {
            Timber.i("adapter on click")
        }
    }

    override fun onUpdate(streamStatus: StreamStatus) {
        adapter?.addAllTop(streamStatus.trades)
    }

}