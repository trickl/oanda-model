package com.trickl.model.oanda.primitives;

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
         GuaranteedStopLossOrderLevelRestriction.builder()
         .build(),
         Instrument.builder()
         .build(),
         InstrumentCommission.builder()
         .build()
     );
  }   
}
