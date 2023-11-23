package src.ex05.user;

public class UserIdsGenerator {
    private static UserIdsGenerator instance = null;
    Integer lastGeneratedId = 0;
    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public Integer generatedId() {
        return  lastGeneratedId++;
    }
}
