package com.surrus.galwaybus.domain.interactor

import com.orhanobut.logger.Logger
import com.surrus.galwaybus.domain.executor.ExecutorThread
import com.surrus.galwaybus.domain.executor.PostExecutionThread
import com.surrus.galwaybus.domain.repository.GalwayBusRepository
import com.surrus.galwaybus.model.BusStop
import com.surrus.galwaybus.model.Location
import io.reactivex.Flowable
import io.reactivex.functions.Function
import javax.inject.Inject
import java.util.concurrent.TimeUnit


open class GetNearestBusStopsUseCase @Inject constructor(val galwayRepository: GalwayBusRepository,
                                                         executorThread: ExecutorThread, postExecutionThread: PostExecutionThread):
        FlowableUseCase<List<BusStop>, Location>(executorThread, postExecutionThread) {

    override fun buildUseCaseObservable(location: Location?): Flowable<List<BusStop>> {
        return galwayRepository.getNearestBusStops(location!!)
                .repeatWhen { completed -> completed.delay(30, TimeUnit.SECONDS) }
                .retry(3)
    }
}