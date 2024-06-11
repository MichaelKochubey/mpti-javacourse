package ru.mfti;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


//REST API
@RestController
class SummatorController {
    
    @GetMapping("/make")
    public ResponseEntity<String> arithmeticExpression(String expression) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(String.valueOf(fun(expression)));
    }

    @GetMapping("/testme")
    public ResponseEntity<String> testIt() {
        String b = asserting();
        HttpStatus st;
        if (b == "Tests passed") st = HttpStatus.OK;
        else st = HttpStatus.CONFLICT;

        return ResponseEntity
                .status(st)
                .contentType(MediaType.TEXT_PLAIN)
                .body(b);
    }

    public static int fun(String str){
        String[] chars = str.split("");
        List<String> signsLowPr = new ArrayList<>();
        List<String> signsHighPr = new ArrayList<>();
        signsLowPr.add("+"); signsLowPr.add("-"); signsHighPr.add("/"); signsHighPr.add("*");

        // разбиваем строку по токенам - числам и знакам
        List<String> tokens = new ArrayList<>();
        int beg = 0;
        if (chars[0] == "-") { //если выражение начинается с отрицательного числа
            beg = 1;
            for (; beg < chars.length; beg ++) {
                if (signsLowPr.contains(chars[beg]) || signsHighPr.contains(chars[beg])) {
                    tokens.add(str.substring(0, beg));
                    tokens.add(str.substring(beg, beg + 1)); // добавляем следующий знак
                    beg = beg + 1;
                    break;
                }
            }
        }
        int start = beg;
        for (int i = beg; i < chars.length; i ++) {
            String c = chars[i];
            if (i == chars.length - 1) {
                tokens.add(str.substring(start, chars.length));
            }
            if (signsLowPr.contains(c) || signsHighPr.contains(c)){
                tokens.add(str.substring(start, i));
                tokens.add(c);
                start = i + 1;
            }
        }

        // исполняем операции с высшим приоритетом - умнож-е и дел-е
        List<String> tokensNew = new ArrayList<>(tokens);
        int res = 0; int shift = 0; int a, b; boolean wasCalcOnPrevIter = false;
        for (int i = 1; i < tokens.size(); i+=2) {
            String t = tokens.get(i);
            if (signsHighPr.contains(t)) {
                a = wasCalcOnPrevIter ?
                        Integer.parseInt(tokensNew.get(i - 1 - shift)) : Integer.parseInt(tokens.get(i - 1));
                b = Integer.parseInt(tokens.get(i + 1));
                res = eval(a, b, t);
                tokensNew.set(i - shift, String.valueOf(res));
                tokensNew.remove(i + 1 - shift); tokensNew.remove(i - 1 - shift);
                shift += 2;
                wasCalcOnPrevIter = true;
            }
            else wasCalcOnPrevIter = false;
        }

        // выполнение операций сложения и вычитания
        int sum = tokensNew.size() > 1 ?
                eval(Integer.parseInt(tokensNew.get(0)), Integer.parseInt(tokensNew.get(2)), tokensNew.get(1))
                : Integer.parseInt(tokensNew.get(0));
        for (int i = 3; i < tokensNew.size(); i +=2) {
            String t = tokensNew.get(i);
            b = Integer.parseInt(tokensNew.get(i + 1));
            sum = eval(sum, b, t);
        }
        return sum;
    }

    public static int eval(int a, int b, String sign) {
        if (Objects.equals(sign, "+")) {
            return a + b;
        }
        if (Objects.equals(sign, "-")) {
            return a - b;
        }
        if (Objects.equals(sign, "*")) {
            return a * b;
        }
        if (Objects.equals(sign, "/")) {
            return a / b;
        }
        return 0;
    }

    @Test
    public static String asserting() {
        try {
            assertEquals(fun("15-14+2*15/3-100+21/7"), -86);
            assertEquals(fun("15*2/30*5-4"), 1);
            assertEquals(fun("1*2*3/6-7*3*2/21"), -1);
            assertEquals(fun("150/15*10/50*128/16/8"), 2);
            assertEquals(fun("3*3-5+2*2-4*2-1+3-4/2"), 0);
            return "Tests passed";
        }
        catch (RuntimeException e) {
            return "Tests failed";
        }
    }
}
