package br.com.alura.codechella.translation;

public record ResponseData(ResponseContent responseData) {

    public String getTranslatedText() {
        return this.responseData.translatedText();
    }

    public record ResponseContent(String translatedText) {
    }
}
