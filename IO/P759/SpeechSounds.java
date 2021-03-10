package ThinkingInJava.IO.P759;

public enum SpeechSounds {
    A;
    String[] letters;
    private SpeechSounds(String... args) {
        letters = args;
    }
}
