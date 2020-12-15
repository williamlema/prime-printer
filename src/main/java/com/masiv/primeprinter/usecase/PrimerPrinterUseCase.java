package com.masiv.primeprinter.usecase;

import java.util.List;

public interface PrimerPrinterUseCase {
    List<Integer> findPrimeNumbers();

    void printValues(List<Integer> primeNumbers);
}
