package Sorters;

/**
 *
 * @author nkostiai
 *
 * Mergesort on vertailujärjestysalgoritmi joka jakaa järjestettävän taulukon
 * pieniin osiin, järjestää osat ja yhdistää osta "lomittamalla" niin, että
 * lopullinen taulukko muodostuu järjestyksessä.
 *
 */
public class MergeSorter {

    /**
     * Mergesortin aloitusmetodi. Mikäli järjestettävä taulukko on liian pieni,
     * palautetaan se sellaisenaan, muuten siirrytään varsinaiseen
     * järjestämismetodiin.
     *
     * @param arrayToSort Järjestettävä taulukko
     * @return Uusi, nyt järjestyksessä oleva taulukko.
     */
    public int[] mergeSortInit(int[] arrayToSort) {
        if (arrayToSort.length < 2) {
            return arrayToSort;
        } else {
            return mergeSort(arrayToSort);
        }
    }

    /**
     * Mergesortin päämetodi. Jakaa taulukon kahtia ja järjestää palaset
     * rekursiivisesti.
     *
     * @param arrayToSort Järjestettävä taulukko
     * @return Uusi taulukko järjestyksessä.
     */
    public int[] mergeSort(int[] arrayToSort) {
        int[] newArray = new int[arrayToSort.length];
        int middle = (int) arrayToSort.length / 2;
        int[] left = mergeSortInit(GlobalMethods.copyRange(arrayToSort, 0, middle));
        int[] right = mergeSortInit(GlobalMethods.copyRange(arrayToSort, middle, arrayToSort.length));

        return merge(left, right, newArray);

    }

    /**
     * Lomittaa taulukon puoliskot järjestyksessä yhteen.
     *
     * @param left Alkuperäisen taulukon vasen puoli.
     * @param right Alkuperäisen taulukon oikea puoli.
     * @param newArray Uusi taulukko.
     * @return
     */
    public int[] merge(int[] left, int[] right, int[] newArray) {
        int leftArrayIndex = 0, rightArrayIndex = 0, newArrayIndex = 0;
        while (leftArrayIndex < left.length && rightArrayIndex < right.length) {
            if (left[leftArrayIndex] < right[rightArrayIndex]) {
                newArray[newArrayIndex] = left[leftArrayIndex];
                newArrayIndex++;
                leftArrayIndex++;
            } else {
                newArray[newArrayIndex] = right[rightArrayIndex];
                newArrayIndex++;
                rightArrayIndex++;
            }
        }

        return mergeSortAfterMath(newArray, left, right, newArrayIndex, leftArrayIndex, rightArrayIndex);
    }

    /**
     * Lomituksen jälkeen tarkistetaan jäikö jommasta kummasta taulukosta arvoja
     * yli. Mikäli arvoja jäi yli, siirretään ne järjestyksessä uuteen
     * taulukkoon.
     *
     * @param newArray Palautettava taulukko.
     * @param left Vasen taulukko.
     * @param right Oikeataulukko.
     * @param newArrayIndex Uuden taulukon indeksi.
     * @param leftArrayIndex Vasemman taulukon indeksi.
     * @param rightArrayIndex Oikean taulukon indeksi.
     * @return
     */
    public int[] mergeSortAfterMath(int[] newArray, int[] left, int[] right, int newArrayIndex, int leftArrayIndex, int rightArrayIndex) {
        newArray = mergeLeftOvers(newArray, left, newArrayIndex, leftArrayIndex);
        newArray = mergeLeftOvers(newArray, right, newArrayIndex, rightArrayIndex);
        return newArray;
    }

    /**
     * Siirtää jäljelle jääneet taulukon arvot uuteen taulukkoon.
     *
     * @param newArray Uusi taulukko.
     * @param arrayToMerge Taulukko josta siirretään.
     * @param newArrayIndex Uuden taulukon indeksi.
     * @param arrayIndex Siirrettävän taulukon indeksi.
     * @return Uusi taulukko.
     */
    public int[] mergeLeftOvers(int[] newArray, int[] arrayToMerge, int newArrayIndex, int arrayIndex) {
        while (arrayIndex < arrayToMerge.length) {
            newArray[newArrayIndex] = arrayToMerge[arrayIndex];
            arrayIndex++;
            newArrayIndex++;
        }

        return newArray;
    }
}
