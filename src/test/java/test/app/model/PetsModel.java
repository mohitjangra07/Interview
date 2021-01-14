package test.app.model;

import lombok.Data;

@Data
public class PetsModel {
    private String[] photoUrls;

    private String name;

    private String id;

    private Category category;

    private Tags[] tags;

    private String status;

    @Data
    public static class Tags {
        private String name;

        private String id;
    }

    @Data
    public static class Category {
        private String name;

        private String id;
    }
}