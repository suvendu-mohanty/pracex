package com.ds.util;

import java.util.*;

/**
 * DeDup illustrates removing the deletion of duplicates from a static array of integers
 *  It has three methods to achieve it which uses a collection class,with iteration after sorting the array
 *  & another one without sorting the array
 */
public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

    public static void main(String [] args) {
        try {
            DeDup delObj = new DeDup();
            int noDupArrUsingCollection[]= delObj.delDupSortItr(delObj.randomIntegers);
            int noDupArrUsingSort[] = delObj.delDupItrWithSort(delObj.randomIntegers);
            int noDupArrWithoutSort[] = delObj.delDupItrWithOutSort(delObj.randomIntegers);
        }catch (Exception ex){
            System.err.print("Error while deleting duplicates " + ex);
        }
    }

    /**
     *
     * @param withDup
     * @return array without duplicates
     * @throws Exception
     */
    public  int[] delDupSortItr(int withDup[]) throws Exception{
        Set<Integer> alreadyPresent = new HashSet<Integer>();
        int[] noDup = new int[0];

        for (int nextElem : withDup) {
            if (!alreadyPresent.contains(nextElem)) {
                noDup = Arrays.copyOf(noDup, noDup.length + 1);
                noDup[noDup.length - 1] = nextElem;
                alreadyPresent.add(nextElem);
            }
        }
        return noDup;
    }


    /**
     *
     * @param withDup
     * @return sorted array without duplicates
     * @throws Exception
     */
    public int[] delDupItrWithSort(int []withDup) throws Exception {

        Arrays.sort(withDup);
        int arrLen = withDup.length;
        int j = 0;
        int i = 1;
        while(i < withDup.length){
            if(withDup[i] == withDup[j]){
                i++;
            }else{
                withDup[++j] = withDup[i++];
            }
        }
        int[] noDup = new int[j+1];
        for(int k=0; k<noDup.length; k++){
            noDup[k] = withDup[k];
        }

        return noDup;



    }

    /**
     *
     * @param withDup
     * @return array without duplicates
     * @throws Exception
     */
    public int[] delDupItrWithOutSort(int []withDup) throws Exception {
        int arrLen = withDup.length;

        for(int i=0;i<arrLen;++i){

            for(int j=i+1;j<arrLen;++j){
                if(withDup[i]==withDup[j]) {
                    int pos = j;
                    for (int k = j + 1; k < arrLen; k++, pos++) {
                        withDup[pos] = withDup[k];
                    }
                    arrLen--;
                    j--;

                }

            }

        }
        int []noDup = new int[arrLen];
        for(int i = 0; i < arrLen; i++){
            noDup[i] = withDup[i];
        }
       return noDup;
     }
    }



