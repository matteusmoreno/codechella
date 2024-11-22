package br.com.alura.codechella.translation;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Translation {

    public static Mono<String> getTranslatedTextMyMemoryApi(String text, String language) {
        String url = "https://api.mymemory.translated.net/get?q=" + text + "&langpair=pt-br|" + language;

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(ResponseData.class)
                .map(ResponseData::getTranslatedText);

    }

}
