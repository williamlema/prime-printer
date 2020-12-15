package com.masiv.primeprinter;

import com.masiv.primeprinter.usecase.PrimerPrinterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class PrimePrinterApplication implements ApplicationRunner {

    @Autowired
    private PrimerPrinterUseCase primerPrinterUseCase;

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(PrimePrinterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Integer> primeNumbers = primerPrinterUseCase.findPrimeNumbers();
        primerPrinterUseCase.printValues(primeNumbers);
        SpringApplication.exit(appContext, () -> 0);
    }
}
