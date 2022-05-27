package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class SpringBootTestExample {

    Calculator calculatorUnderTest = new Calculator();

    @Test
    public void shouldAddTwoNumbers() {
        // given
        int a = 10;
        int b = 20;

        // when
        int result = calculatorUnderTest.add(a, b);

        // then
        assertThat(result).isEqualTo(30);

    }

    class Calculator{
        int add(int a, int b){
            return a + b;
        }
    }

}
