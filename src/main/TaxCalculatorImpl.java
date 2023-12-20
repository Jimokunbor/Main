/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author jimok
 */
public class TaxCalculatorImpl implements TaxCalculator {
     @Override
    public double calculateTax(double grossIncome, double taxCredits) {
        // Example: Simplified tax calculation
        // Assume a tax rate of 20% on income after deducting tax credits
        double taxRate = 0.20;
        
        // Calculate taxable income
        double taxableIncome = grossIncome - taxCredits;

        // Ensure taxable income is not negative
        taxableIncome = Math.max(0, taxableIncome);

        // Calculate tax
        double taxAmount = taxableIncome * taxRate;

        return taxAmount;
    }
}