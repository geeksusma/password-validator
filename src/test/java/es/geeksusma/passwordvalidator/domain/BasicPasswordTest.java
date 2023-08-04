package es.geeksusma.passwordvalidator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicPasswordTest {

    @Test
    void should_returnValid_when_moreThanEightCharsAndCapitalLetterAndLowercaseAndAtLeastANumberAndAnUnderScore() {

        assertThat(BasicPassword.of("12_34567Ca").check()).isTrue();
        assertThat(BasicPassword.of("12345_678Ac").check()).isTrue();
    }

    @Test
    void should_returnNotValid_when_lessThanEightChars() {
        assertThat(BasicPassword.of(null).check()).isFalse();
        assertThat(BasicPassword.of("").check()).isFalse();
        assertThat(BasicPassword.of("1234567").check()).isFalse();
    }

    @Test
    void should_returnNotValid_when_noCapitalLetterFound() {
        assertThat(BasicPassword.of("12345678a").check()).isFalse();
    }

    @Test
    void should_returnNotValid_when_noLowerCaseFound() {
        assertThat(BasicPassword.of("12345678A").check()).isFalse();
    }

    @Test
    void should_returnNotValid_when_noNumberFound() {
        assertThat(BasicPassword.of("adffdAdfadsfA").check()).isFalse();
    }

    @Test
    void should_returnNotValid_when_noUnderScoreFound() {
        assertThat(BasicPassword.of("adffdAd1fadsfA").check()).isFalse();
    }
}