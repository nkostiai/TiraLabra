/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Sorters.IntroSorter;
import Sorters.MergeSorter;
import Sorters.ShellSorter;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Kayttoliittyma {

    private Random randomizer;
    private int[] smallArray;
    private int[] mediumArray;
    private int[] largeArray;
    private MergeSorter mergeSorter;
    private ShellSorter shellSorter;
    private IntroSorter introSorter;

    public Kayttoliittyma() {
        randomizer = new Random();
        smallArray = new int[1000];
        mediumArray = new int[100000];
        largeArray = new int[10000000];
        mergeSorter = new MergeSorter();
        shellSorter = new ShellSorter();
        introSorter = new IntroSorter();
    }

    public void kaynnista() {
        System.out.println("Muodostetaan taulukot...");
        muodostaTaulukot();
        System.out.println("Järjestetään pieni taulukko...");
        jarjestaTaulukko(smallArray);
        System.out.println("Järjestetään keskikokoinen taulukko...");
        jarjestaTaulukko(mediumArray);
        System.out.println("Järjestetään suuri taulukko...");
        jarjestaTaulukko(largeArray);
    }

    public void jarjestaTaulukko(int[] jarjestettava) {
        System.out.println("Mergesort...");
        jarjestaMergesortilla(jarjestettava);
//        System.out.println("Shellsort...");
//        jarjestaShellsortilla(jarjestettava);
        System.out.println("Introsort");
        jarjestaIntrosortilla(jarjestettava);
    }

    private void jarjestaMergesortilla(int[] jarjestettava) {
        long aloitus = System.nanoTime();
        mergeSorter.mergeSort(jarjestettava);
        long lopetus = System.nanoTime();
        System.out.println("Mergesortilla aikaa meni: " + ((lopetus - aloitus) / 1000000) + "ms");

    }

    private void jarjestaShellsortilla(int[] jarjestettava) {
        long aloitus = System.nanoTime();
        shellSorter.shellSort(jarjestettava);
        long lopetus = System.nanoTime();
        System.out.println("shellSortilla aikaa meni: " + ((lopetus - aloitus) / 1000000) + "ms");

    }
    
    
    
    private void jarjestaIntrosortilla(int[] jarjestettava) {
        long aloitus = System.nanoTime();
        introSorter.introSort(jarjestettava);
        long lopetus = System.nanoTime();
        System.out.println("Introsortilla aikaa meni: " + ((lopetus - aloitus) / 1000000) + "ms");

    }

    private void muodostaTaulukot() {
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = randomizer.nextInt(smallArray.length);
        }
        for (int i = 0; i < mediumArray.length; i++) {
            mediumArray[i] = randomizer.nextInt(mediumArray.length);
        }
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = randomizer.nextInt(largeArray.length);
        }
    }

}