public enum Singleton {
    INSTANCE;

    private String message;

    public String getMessage() {
        return message;
    }

    public void print(String something){
        message = something;
    }
}
