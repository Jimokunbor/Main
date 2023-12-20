/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

/**
 * TaxCalculator interface provides a method for calculating tax based on income and tax credits.
 * @author jimok
 */
public interface TaxCalculator {
     /**
     * Calculates tax based on gross income and tax credits.
     *
     * @param grossIncome Gross income of the user.
     * @param taxCredits  Tax credits applicable to the user.
     * @return Calculated tax amount.
     */
    double calculateTax(double grossIncome, double taxCredits);
}
