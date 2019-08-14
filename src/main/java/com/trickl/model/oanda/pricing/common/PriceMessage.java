package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

/** The base Order specification used when requesting that an Order be created.
 * Each specific Order-type extends this definition."
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.CUSTOM, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "type"
)
@JsonTypeIdResolver(PriceMessageTypeIdResolver.class)
public interface PriceMessage {
}
