package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.OrderTriggerCondition;
import com.trickl.model.oanda.order.TimeInForce;
import lombok.Data;

/**
 * A MarketIfTouchedOrderRejectTransaction represents the rejection of the creation of a
 * MarketIfTouched Order.
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
    "instrument",
    "units",
    "price",
    "priceBound",
    "timeInForce",
    "gtdTime",
    "positionFill",
    "triggerCondition",
    "reason",
    "clientExtensions",
    "takeProfitOnFill",
    "stopLossOnFill",
    "trailingStopLossOnFill",
    "tradeClientExtensions",
    "intendedReplacesOrderID",
    "rejectReason"
})
@Data
public class MarketIfTouchedOrderRejectTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation "
          + "of the Transaction.")
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
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in"
              + " the same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "MARKET_IF_TOUCHED_ORDER_REJECT" in a
   * MarketIfTouchedOrderRejectTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"MARKET_IF_TOUCHED_ORDER_REJECT\" "
              + "in a MarketIfTouchedOrderRejectTransaction.")
  private TransactionType type;
  
  /** The MarketIfTouched Order's Instrument. */
  @JsonPropertyDescription("The MarketIfTouched Order's Instrument.")
  private String instrument;
  
  /**
   * The quantity requested to be filled by the MarketIfTouched Order. A positive number of units
   * results in a long Order, and a negative number of units results in a short Order.
   */
  @JsonPropertyDescription(
      "The quantity requested to be filled by the MarketIfTouched Order."
              + " A positive number of units results in a long Order, and a negative "
              + "number of units results in a short Order.")
  private String units;
  
  /**
   * The price threshold specified for the MarketIfTouched Order. The MarketIfTouched Order will
   * only be filled by a market price that crosses this price from the direction of the market price
   * at the time when the Order was created (the initialMarketPrice). Depending on the value of the
   * Order's price and initialMarketPrice, the MarketIfTouchedOrder will behave like a Limit or a
   * Stop Order.
   */
  @JsonPropertyDescription(
      "The price threshold specified for the MarketIfTouched Order. "
              + "The MarketIfTouched Order will only be filled by a market price "
              + "that crosses this price from the direction of the market price "
              + "at the time when the Order was created (the initialMarketPrice)."
              + " Depending on the value of the Order's price and initialMarketPrice, "
              + "the MarketIfTouchedOrder will behave like a Limit or a Stop Order.")
  private String price;
  
  /** The worst market price that may be used to fill this MarketIfTouched Order. */
  @JsonPropertyDescription(
      "The worst market price that may be used to fill this MarketIfTouched Order.")
  private String priceBound;
  
  /**
   * The time-in-force requested for the MarketIfTouched Order. Restricted to "GTC", "GFD" and "GTD"
   * for MarketIfTouched Orders.
   */
  @JsonPropertyDescription(
      "The time-in-force requested for the MarketIfTouched Order. Restricted to"
              + " \"GTC\", \"GFD\" and \"GTD\" for MarketIfTouched Orders.")
  private TimeInForce timeInForce;
  
  /** The date/time when the MarketIfTouched Order will be cancelled if its timeInForce is "GTD". */
  @JsonPropertyDescription(
      "The date/time when the MarketIfTouched Order will be cancelled if its "
              + "timeInForce is \"GTD\".")
  private String gtdTime;
  
  /** Specification of how Positions in the Account are modified when the Order is filled. */
  @JsonPropertyDescription(
      "Specification of how Positions in the Account are modified when the Order is"
              + " filled.")
  private PositionFill positionFill;
  
  /**
   * Specification of which price component should be used when determining if an Order should be
   * triggered and filled. This allows Orders to be triggered based on the bid, ask, mid, default
   * (ask for buy, bid for sell) or inverse (ask for sell, bid for buy) price depending on the
   * desired behaviour. Orders are always filled using their default price component. This feature
   * is only provided through the REST API. Clients who choose to specify a non-default trigger
   * condition will not see it reflected in any of OANDA's proprietary or partner trading platforms,
   * their transaction history or their account statements. OANDA platforms always assume that an
   * Order's trigger condition is set to the default value when indicating the distance from an
   * Order's trigger price, and will always provide the default trigger condition when creating or
   * modifying an Order. A special restriction applies when creating a guaranteed Stop Loss Order.
   * In this case the TriggerCondition value must either be "DEFAULT", or the "natural" trigger side
   * "DEFAULT" results in. So for a Stop Loss Order for a long trade valid values are "DEFAULT" and
   * "BID", and for short trades "DEFAULT" and "ASK" are valid.
   */
  @JsonPropertyDescription(
      "Specification of which price component should be used when determining if "
              + "an Order should be triggered and filled. This allows Orders to"
              + " be triggered based on the bid, ask, mid, default (ask for buy,"
              + " bid for sell) or inverse (ask for sell, bid for buy) price depending "
              + "on the desired behaviour. Orders are always filled using their default"
              + " price component.\nThis feature is only provided through the REST API."
              + " Clients who choose to specify a non-default trigger condition will"
              + " not see it reflected in any of OANDA's proprietary or partner "
              + "trading platforms, their transaction history or their account statements. "
              + "OANDA platforms always assume that an Order's trigger condition is "
              + "set to the default value when indicating the distance from an Order's"
              + " trigger price, and will always provide the default trigger condition"
              + " when creating or modifying an Order.\nA special restriction applies "
              + "when creating a guaranteed Stop Loss Order. In this case the TriggerCondition "
              + "value must either be \"DEFAULT\", or the \"natural\" trigger side"
              + " \"DEFAULT\" results in. So for a Stop Loss Order for a long trade "
              + "valid values are \"DEFAULT\" and \"BID\", and for short trades "
              + "\"DEFAULT\" and \"ASK\" are valid.")
  private OrderTriggerCondition triggerCondition;
  
  /** The reason that the Market-if-touched Order was initiated. */
  @JsonPropertyDescription("The reason that the Market-if-touched Order was initiated")
  private TransactionReason reason;
  
  private Object clientExtensions;

  private Object takeProfitOnFill;

  private Object stopLossOnFill;

  private Object trailingStopLossOnFill;

  private Object tradeClientExtensions;
  /**
   * The ID of the Order that this Order was intended to replace (only provided if this Order was
   * intended to replace an existing Order).
   */
  @JsonProperty("intendedReplacesOrderID")
  @JsonPropertyDescription(
      "The ID of the Order that this Order was intended to replace (only provided "
              + "if this Order was intended to replace an existing Order).")
  private String intendedReplacesOrderId;
  
  /** The reason that the Reject Transaction was created. */
  @JsonPropertyDescription("The reason that the Reject Transaction was created")
  private RejectReason rejectReason;
}