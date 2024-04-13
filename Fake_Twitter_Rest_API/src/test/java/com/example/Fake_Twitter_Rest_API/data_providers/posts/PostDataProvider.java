package com.example.Fake_Twitter_Rest_API.data_providers.posts;


import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PostDataProvider {
    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of( "Fă ceea ce poți, cu ceea ce ai, acolo unde ești."),
                Arguments.of( "Succesul nu este final, eșecul nu este fatal: curajul de a continua este ceea ce contează."),
                Arguments.of( "Dacă poți visa, poți face și visul să devină realitate.")
        );
    }
}
