package com.surrus.galwaybus.data.source

import com.surrus.galwaybus.data.repository.GalwayBusDataStore
import com.surrus.galwaybus.data.repository.GalwayBusRemote
import com.surrus.galwaybus.model.BusRoute
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class GalwayBusRemoteDataStore @Inject constructor(private val galwayBusRemote: GalwayBusRemote) : GalwayBusDataStore {

    override fun getBusRoutes(): Flowable<List<BusRoute>> {
        return galwayBusRemote.getBusRoutes()
    }

    override fun clearBusRoutes(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBusRoutes(bufferoos: List<BusRoute>): Completable {
        throw UnsupportedOperationException()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

}