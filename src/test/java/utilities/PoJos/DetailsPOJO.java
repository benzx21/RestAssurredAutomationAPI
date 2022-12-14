package utilities.PoJos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class DetailsPOJO {
    @JsonProperty("DETAILS")
    private Details DETAILS;
    @JsonProperty("MESSAGE_TYPE")
    private String messageType;
    @JsonProperty("SERVICE_NAME")
    private String serviceName;

}

