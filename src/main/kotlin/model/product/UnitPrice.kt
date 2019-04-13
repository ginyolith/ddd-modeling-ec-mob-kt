package model.product

/** 単価を表すValueObject */
data class UnitPrice(val value : Int) {

    init {
        require(value >= 0) { "単価は0以上の整数であること" }
    }
}