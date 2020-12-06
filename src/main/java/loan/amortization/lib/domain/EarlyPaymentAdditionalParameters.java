package loan.amortization.lib.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public enum EarlyPaymentAdditionalParameters implements Serializable {
    /**
     *  Parameter for {@link EarlyPaymentRepeatingStrategy#TO_CERTAIN_MONTH}
     */
    @JsonProperty("repeat_to_month_number")
    REPEAT_TO_MONTH_NUMBER
}