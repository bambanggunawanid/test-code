package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokerRuleTests {

    @Test
    void contextLoads() throws Exception {
        System.out.println(poker(List.of("A", "A", "J", "A", "A")));
        System.out.println(poker(List.of("10", "6", "7", "9", "8")));
        System.out.println(poker(List.of("K", "2", "2", "K", "3")));
        System.out.println(poker(List.of("9", "10", "A", "2", "3")));
    }

    @Test
    String poker(List<String> kartu) {
        // Write your code here
        List<String> sortedKartu = kartu.stream().sorted().collect(Collectors.toList());
        List<String> kartuTangan = new ArrayList<>();
        String result = "";
        int jumlahKartuTerbanyak = 0;
        int jumlahKartuTerbanyakKedua = 0;
        int straightScore = 0;
        for (int a = 0; a < sortedKartu.size() / 5; a++) {
            int n = 5;
            for (int i = 0; i < n; i++) {
                kartuTangan.add(sortedKartu.get(i));
                int frekuensiKartu = Collections.frequency(kartuTangan, kartuTangan.get(i));
                if (frekuensiKartu > jumlahKartuTerbanyak) {
                    jumlahKartuTerbanyakKedua = frekuensiKartu;
                    jumlahKartuTerbanyak = frekuensiKartu;
                }
                result = pokerSameRule(jumlahKartuTerbanyak, jumlahKartuTerbanyakKedua);
                if ((i + 1) % 5 != 0
                        && Math.abs((int) sortedKartu.get(i).charAt(0) - (int) sortedKartu.get(i + 1).charAt(0)) == 1) {
                    straightScore++;
                }
                if (straightScore == 5) {
                    result = "STRAIGHT";
                }
            }
            n += 5;
        }
        // hitung jumlah kartu yang sama
        return result;
    }

    String pokerSameRule(int jumlahKartuTerbanyak, int jumlahKartuTerbanyakKedua) {
        if (jumlahKartuTerbanyak == 4) {
            return "FOUR-OF-A-KIND";
        } else if (jumlahKartuTerbanyak == 3) {
            return "FULL-HOUSE";
        } else if (jumlahKartuTerbanyak == 2 && jumlahKartuTerbanyakKedua == 2) {
            return "TWO-PAIR";
        }
        return "HIGH-CARD";
    }
}
