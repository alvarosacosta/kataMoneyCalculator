package main;

import control.CalculateCommand;
import persistence.CurrencyListLoader;
import persistence.ExchangeRateLoader;
import persistence.rest.RestExchangeRateLoader;
import persistence.files.FileCurrencyListLoader;

public class main {

    public static void main(String[] args) {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }





    
}
