package app.sosocom.data.mapper

import app.sosocom.data.remote.model.DataLoveResponse
import app.sosocom.domain.model.DomainLoveResponse

object MainMapper {
    fun loveMapper(
        dataResponse: DataLoveResponse?
    ): DomainLoveResponse? {
        return if(dataResponse != null) {
            DomainLoveResponse(
                fname = dataResponse.fname,
                sname = dataResponse.sname,
                percentage = dataResponse.percentage,
                result = dataResponse.result
            )
        } else dataResponse
    }
}