package test.app.model;

import lombok.Data;

@Data
public class BaseConfig {
    private String testType;
    private String browserName;
    private String env;
    private String appTestUrl;
}
