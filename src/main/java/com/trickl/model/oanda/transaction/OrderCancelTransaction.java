package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/** An OrderCancelTransaction represents the cancellation of an Order in the client's Account. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "orderID",
    "clientOrderID",
    "reason",
    "replacedByOrderID"
})
@Data
@Builder
public class OrderCancelTransaction extends Transaction {
  
  /** The ID of the Order cancelled. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order cancelled")
  private String orderId;
  
  /** The client ID of the Order cancelled (only provided if the Order has a client Order ID). */
  @JsonProperty("clientOrderID")
  @JsonPropertyDescription(
      "The client ID of the Order cancelled (only provided if the Order has a"
              + " client Order ID).")
  private String clientOrderId;
  
  /** The reason that the Order was cancelled. */
  @JsonPropertyDescription("The reason that the Order was cancelled.")
  private OrderCancelReason reason;
  
  /**
   * The ID of the Order that replaced this Order (only provided if this Order was cancelled for
   * replacement).
   */
  @JsonProperty("replacedByOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that replaced this Order (only provided if this Order "
              + "was cancelled for replacement).")
  private String replacedByOrderId;
}
