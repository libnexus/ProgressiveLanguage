package ProgLang.Lexer;

public record Token(TT type, String value, Integer column) {
    public boolean matchesTypeAndValue(TT type, String value) {
        return (this.type().equals(type)) && (this.value().equals(value));
    }

    public boolean matchesKeyword(String keyword) {
        return this.matchesTypeAndValue(TT.KEYWORD, keyword);
    }

    public boolean matchesIdentifier(String name) {
        return this.matchesTypeAndValue(TT.IDENTIFIER, name);
    }

    public boolean matches(TT type) {
        return this.type().equals(type);
    }
}