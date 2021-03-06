package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** The possible types of a Transaction. */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransactionStreamMessageType {
  CREATE(CreateTransaction.class),
  CLOSE(CloseTransaction.class),
  REOPEN(ReopenTransaction.class),
  CLIENT_CONFIGURE(ClientConfigureTransaction.class),
  CLIENT_CONFIGURE_REJECT(ClientConfigureRejectTransaction.class),
  TRANSFER_FUNDS(TransferFundsTransaction.class),
  TRANSFER_FUNDS_REJECT(TransferFundsRejectTransaction.class),
  MARKET_ORDER(MarketOrderTransaction.class),
  MARKET_ORDER_REJECT(MarketOrderRejectTransaction.class),
  FIXED_PRICE_ORDER(FixedPriceOrderTransaction.class),
  LIMIT_ORDER(LimitOrderTransaction.class),
  LIMIT_ORDER_REJECT(LimitOrderRejectTransaction.class),
  STOP_ORDER(StopOrderTransaction.class),
  STOP_ORDER_REJECT(StopOrderRejectTransaction.class),
  MARKET_IF_TOUCHED_ORDER(MarketIfTouchedOrderTransaction.class),
  MARKET_IF_TOUCHED_ORDER_REJECT(MarketIfTouchedOrderRejectTransaction.class),
  TAKE_PROFIT_ORDER(TakeProfitOrderTransaction.class),
  TAKE_PROFIT_ORDER_REJECT(TakeProfitOrderRejectTransaction.class),
  STOP_LOSS_ORDER(StopLossOrderTransaction.class),
  STOP_LOSS_ORDER_REJECT(StopLossOrderRejectTransaction.class),
  TRAILING_STOP_LOSS_ORDER(TrailingStopLossOrderTransaction.class),
  TRAILING_STOP_LOSS_ORDER_REJECT(TrailingStopLossOrderRejectTransaction.class),
  ORDER_FILL(OrderFillTransaction.class),
  ORDER_CANCEL(OrderCancelTransaction.class),
  ORDER_CANCEL_REJECT(OrderCancelRejectTransaction.class),
  ORDER_CLIENT_EXTENSIONS_MODIFY(OrderClientExtensionsModifyTransaction.class),
  ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT(OrderClientExtensionsModifyRejectTransaction.class),
  TRADE_CLIENT_EXTENSIONS_MODIFY(TradeClientExtensionsModifyTransaction.class),
  TRADE_CLIENT_EXTENSIONS_MODIFY_REJECT(TradeClientExtensionsModifyRejectTransaction.class),
  MARGIN_CALL_ENTER(MarginCallEnterTransaction.class),
  MARGIN_CALL_EXTEND(MarginCallExtendTransaction.class),
  MARGIN_CALL_EXIT(MarginCallExitTransaction.class),
  DELAYED_TRADE_CLOSURE(DelayedTradeClosureTransaction.class),
  DAILY_FINANCING(DailyFinancingTransaction.class),
  RESET_RESETTABLE_PL(ResetResettablePandLTransaction.class),
  HEARTBEAT(TransactionHeartbeat.class);

  @Getter private final Class<? extends TransactionStreamMessage> transactionStreamMessageClass;

  private static final Map<Class<? extends TransactionStreamMessage>, TransactionStreamMessageType>
      CONSTANTS = new HashMap<>();

  static {
    for (TransactionStreamMessageType c : values()) {
      CONSTANTS.put(c.transactionStreamMessageClass, c);
    }
  }

  /**
   * Create the enum from a string representation.
   *
   * @param transactionStreamMessageClass The transaction class
   * @return The enum
   */
  @JsonCreator
  public static TransactionStreamMessageType fromTransactionStreamMessageClass(
      Class<? extends TransactionStreamMessage> transactionStreamMessageClass) {
    TransactionStreamMessageType constant = CONSTANTS.get(transactionStreamMessageClass);
    if (constant == null) {
      throw new IllegalArgumentException(transactionStreamMessageClass.toString());
    } else {
      return constant;
    }
  }
}
