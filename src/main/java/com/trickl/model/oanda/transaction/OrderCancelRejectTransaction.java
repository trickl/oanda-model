package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * An OrderCancelRejectTransaction represents the rejection of the cancellation of an Order in the
 * client's Account.
 */
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
    "rejectReason"
})
@Data
public class OrderCancelRejectTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;

  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;

  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the Transaction.")
  private Integer userId;

  /** The ID of the Account the Transaction was created for. */
  @JsonProperty("accountID")
  @JsonPropertyDescription("The ID of the Account the Transaction was created for.")
  private String accountId;

  /**
   * The ID of the "batch" that the Transaction belongs to. Transactions in the same batch are
   * applied to the Account simultaneously.
   */
  @JsonProperty("batchID")
  @JsonPropertyDescription(
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in "
          + "the same batch are applied to the Account simultaneously.")
  private String batchId;

  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;

  /**
   * The Type of the Transaction. Always set to "ORDER_CANCEL_REJECT" for an
   * OrderCancelRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"ORDER_CANCEL_REJECT\" "
          + "for an OrderCancelRejectTransaction.")
  private TransactionType type;

  /** The ID of the Order intended to be cancelled. */
  @JsonProperty("orderID")
  @JsonPropertyDescription("The ID of the Order intended to be cancelled")
  private String orderId;
  /**
   * The client ID of the Order intended to be cancelled (only provided if the Order has a client
   * Order ID).
   */
  @JsonProperty("clientOrderId")
  @JsonPropertyDescription(
      "The client ID of the Order intended to be cancelled (only provided if the "
          + "Order has a client Order ID).")
  private String clientOrderId;

  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}
