package cating;

public class MeowCaller {
    public static void makeThemMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}