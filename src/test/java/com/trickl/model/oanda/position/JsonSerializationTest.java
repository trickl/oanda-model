package com.trickl.model.oanda.position;

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
         CalculatedPositionState.builder()
         .build(),
         Position.builder()
         .build(),
         PositionSide.builder()
         .build(),
         GetPositionsResponse.builder()
         .build(),
         GetPositionResponse.builder()
         .build()
     );
  }   
}
