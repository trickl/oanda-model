package com.trickl.model.oanda.trade;

import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class JsonSerializationTest {

  @ParameterizedTest
  @MethodSource("pojoProvider")
  public void testSerialization(Object obj) throws Exception {  
    assertThat(obj)
        .serializesAsExpected()
        .deserializesAsExpected()
        .schemaAsExpected();
  }
  
  static Stream<Object> pojoProvider() {
     return Stream.of(
         CalculatedTradeState.builder()
         .build(),
         Trade.builder()
         .build(),
         TradeSummary.builder()
         .build(),
         GetTradesResponse.builder()
         .build()
     );
  }   
}
