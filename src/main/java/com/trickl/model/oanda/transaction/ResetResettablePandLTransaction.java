package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A ResetResettablePLTransaction represents the resetting of the Account's resettable PL counters.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "time", "userID", "accountID", "batchID", "requestID", "type"})
@Data
@Builder
public class ResetResettablePandLTransaction extends Transaction {
}
