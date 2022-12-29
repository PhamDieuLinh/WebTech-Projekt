package htw.berlin.webtech.persistence;

public enum Rating {
    VERYBAD(1), BAD(2), OK(3), GOOD(4), VERYGOOD(5);

    private int value;
    private Rating(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
