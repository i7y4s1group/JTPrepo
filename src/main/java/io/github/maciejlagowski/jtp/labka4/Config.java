package io.github.maciejlagowski.jtp.labka4;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Config {
    private int howManyClients;
    private int maxClientDelay;
    private Double money;
    private int minQuantity;
    private boolean isConfigured = false;
}
