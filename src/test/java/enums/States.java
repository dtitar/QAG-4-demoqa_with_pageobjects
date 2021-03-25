package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum States {
    NCR("NCR", List.of("Delhi", "Gurgaon", "Noida")),
    UTTAR_PRADESH("Uttar Pradesh", List.of("Agra", "Lucknow", "Berrut")),
    HARYANA("Haryana", List.of("Karnal", "Panipat")),
    RAJASTHAN("Rajasthan", List.of("Jaipur", "Jaicelmer"));

    private String value;
    private List<String> cities;
}
