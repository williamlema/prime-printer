package com.masiv.primeprinter.usecase.impl;

import com.masiv.primeprinter.adapter.stream.OutputBinding;
import com.masiv.primeprinter.usecase.PrimerPrinterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PrimePrinterUseCaseImpl implements PrimerPrinterUseCase {

    @Value("${prime.number-of-primes}")
    private Integer numberOfPrimes;
    @Value("${prime.number-rows-in-page}")
    private Integer numberRowsInPage;
    @Value("${prime.numbers-per-line}")
    private Integer numbersPerLine;
    private static final String PAGE_MESSAGE_STRUCTURE = "The First %s Prime Numbers === Page %s";
    private static final String PAGE_ROW_MESSAGE_STRUCTURE = "%10d%10d%10d%10d";

    private final OutputBinding outputBinding;

    @Override
    public List<Integer> findPrimeNumbers() {
        List<Integer> primeNumbers = new ArrayList<>();
        int initialNumber = 2;
        do {
            if (isPrime(initialNumber)) {
                primeNumbers.add(initialNumber);
            }
            initialNumber++;
        } while (primeNumbers.size() < numberOfPrimes);


        return primeNumbers;
    }

    private boolean isPrime(int number) {
        for (int i = (int) Math.sqrt(number); i > 1; i--) {
            if (number % i == 0) {

                return false;
            }
        }

        return true;
    }

    @Override
    public void printValues(List<Integer> primeNumbers) {
        int page = 1;
        int offSet = 0;
        int recordsInPage = numberRowsInPage * numbersPerLine;
        while (offSet < numberOfPrimes) {
            outputBinding.send(String.format(PAGE_MESSAGE_STRUCTURE, numberOfPrimes, page));
            printPage(primeNumbers.subList(offSet, offSet + recordsInPage));
            page++;
            offSet += recordsInPage;
        }
    }

    private void printPage(List<Integer> primeNumbersInPage) {
        for (int row = 0; row < numberRowsInPage; row++) {
            Object[] rowValues = new Object[numbersPerLine];
            for (int record = 0; record < numbersPerLine; record++) {
                rowValues[record] = primeNumbersInPage.get(row + record * numberRowsInPage);
            }
            outputBinding.send(String.format(PAGE_ROW_MESSAGE_STRUCTURE, rowValues));
        }
    }
}
