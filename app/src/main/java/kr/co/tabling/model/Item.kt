package kr.co.tabling.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.ToString

@ToString
class Item {
    var id : Int? = null
    var author : String? = null
    var width : Int? = null
    var height : Int? = null
    var url : String? = null

    @JsonProperty("download_url")
    var downloadUrl : String? = null


}