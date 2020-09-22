package ${package}.${artifactIdPath}.enums;

public enum TagHandle {
    CREATE("create"),ADDTAGUSERS("addtagusers"),GET("get"),DELTAGUSERS("deltagusers");
    private String value;
    TagHandle(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
