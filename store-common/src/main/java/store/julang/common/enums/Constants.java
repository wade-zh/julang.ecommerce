package store.julang.common.enums;

import store.julang.common.config.RemoteNameManager;

public enum Constants {
    SERVICE_API_GATEWAY("store-api-gateway");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Constants(String name) {
        this.name = name;
    }

}
