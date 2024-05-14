package com.fisglobal.fisglobalfranklinike.game;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a class with a score() method that accepts an array of dice values (up to 6). Scoring rules are as follows:
 * •	A single one (100)
 * •	A single five (50)
 * •	Triple ones [1,1,1] (1000)
 * •	Triple twos [2,2,2] (200)
 * •	Triple threes [3,3,3] (300)
 * •	Triple fours [4,4,4] (400)
 * •	Triple fives [5,5,5] (500)
 * •	Triple sixes [6,6,6] (600)
 * Note that the scorer should work for any number of dice up to 6.
 * •	Four-of-a-kind (Multiply Triple Score by 2)
 * •	Five-of-a-kind (Multiply Triple Score by 4)
 * •	Six-of-a-kind (Multiply Triple Score by 8)
 * •	Three Pairs [2,2,3,3,4,4] (800)
 * •	Straight [1,2,3,4,5,6] (1200)
 */
public class DiceGame {

    /**
     * This is the main method that scores the
     * @param entries
     * @return
     */
    public int score(int[] entries){
        int result = 0;

        sortAndValidateEntries(entries);

        //groupby with value as the count
        Map<Integer, Long> score = Arrays.stream(entries)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //get map entry of number with the highest count
        Optional<Map.Entry<Integer, Long>> mapEntryWithHighestCountOfSameNumber = getMapEntryWithHighestCountOfSameNumber(score);

        //is Straight [1,2,3,4,5,6] (1200)
        if(isStraight(entries, score)){
            return 1200;
        }
        //Three Pairs [2,2,3,3,4,4] (800)
        else if(is3Pairs(entries, score)){
            return 800;
        }
        //Six-of-a-kind (Multiply Triple Score by 8)
        else if(mapEntryWithHighestCountOfSameNumber.isPresent() && mapEntryWithHighestCountOfSameNumber.get().getValue() == 6){
            //if six ones in a row then Multiply Triple Score by 8 == 1000 * 8
            if(mapEntryWithHighestCountOfSameNumber.get().getKey() == 1){
                return 1000 * 8;
            }
            return mapEntryWithHighestCountOfSameNumber.get().getKey() * 800;
        }
        //Five-of-a-kind (Multiply Triple Score by 4)
        else if(mapEntryWithHighestCountOfSameNumber.isPresent() && mapEntryWithHighestCountOfSameNumber.get().getValue() == 5){
            //if five ones in a row then Multiply Triple Score by 4 == 1000 * 4
            if(mapEntryWithHighestCountOfSameNumber.get().getKey() == 1){
                result =  1000 * 4;
            } else {
                result = mapEntryWithHighestCountOfSameNumber.get().getKey() * 400;
            }

            //if we have a single 1 or a single 5, then add to the score. This is because remaining single number can be one of the 2
            if(score.get(5) != null && score.get(5) == 1){
                result = result + 50;
            }

            if(score.get(1) != null && score.get(1) == 1){
                result = result + 100;
            }
            return result;
        }
        //Four-of-a-kind (Multiply Triple Score by 2)
        else if(mapEntryWithHighestCountOfSameNumber.isPresent() && mapEntryWithHighestCountOfSameNumber.get().getValue() == 4){
            //if four ones in a row then Multiply Triple Score by 2 == 1000 * 2
            if(mapEntryWithHighestCountOfSameNumber.get().getKey() == 1){
                result = 1000 * 2;
            } else{
                result = mapEntryWithHighestCountOfSameNumber.get().getKey() * 200;
            }

            //if we have a single 1 or a single 5, then add to the score. This is because remaining single number can be one of the 2
            if(score.get(5) != null && score.get(5) == 1){
                result = result + 50;
            }

            if(score.get(1) != null && score.get(1) == 1){
                result = result + 100;
            }
            return result;
        }
        //	Triple ones [1,1,1] (1000)
        //	Triple twos [2,2,2] (200)
        //	Triple threes [3,3,3] (300)
        //	Triple fours [4,4,4] (400)
        //	Triple fives [5,5,5] (500)
        //	Triple sixes [6,6,6] (600)
        else if(mapEntryWithHighestCountOfSameNumber.isPresent() && mapEntryWithHighestCountOfSameNumber.get().getValue() == 3){
            if(mapEntryWithHighestCountOfSameNumber.get().getKey() == 1){
                result =  1000;
            }else{
                result =  mapEntryWithHighestCountOfSameNumber.get().getKey() * 100;
            }

            //we can have a situation where we have a pair of 3s. in that case we should cater to it
            //remove the current Key with hiqhest value that we calculated already
            score.remove(mapEntryWithHighestCountOfSameNumber.get().getKey());

            //get map entry of number with the highest count after 1st one has been removed
            mapEntryWithHighestCountOfSameNumber = getMapEntryWithHighestCountOfSameNumber(score);
            if(mapEntryWithHighestCountOfSameNumber.isPresent() && mapEntryWithHighestCountOfSameNumber.get().getValue() == 3){
                if(mapEntryWithHighestCountOfSameNumber.get().getKey() == 1){
                    result = result + 1000;
                }else{
                    result = result + (mapEntryWithHighestCountOfSameNumber.get().getKey() * 100);
                }
            }

            if(score.get(5) != null && score.get(5) == 1){
                result = result + 50;
            }

            if(score.get(1) != null && score.get(1) == 1){
                result = result + 100;
            }

            return result;
        }
        //if we have 1 of 1 or 1 of 5 then cater to the score below
        else if(score.get(1) != null && score.get(1) == 1){
            result = 100;
            if(score.get(5) != null && score.get(5) == 1){
                result = result + 50;
            }
            return result;
        }else if(score.get(5) != null && score.get(5) == 1){
            return 50;
        }
        return 0;

    }

    /**
     * This method makes sure the array falls within the rules and bondaries of the dice game. I validates the entries
     * and throws exceptions fi invalid.
     * @param entries original Integer array to be scored
     */
    private void sortAndValidateEntries(int[] entries) {

        //if array is null or contains less than 1 element, or more than 6 elements then throw an exception
        if(entries == null || entries.length > 6 || entries.length < 1 ){
            throw new IllegalArgumentException("Null or incorrect entries.");
        }
        Arrays.sort(entries);

        //if items in the array don't fall between the values of 1 and 6 then throw exception
        if(entries[0] < 1 || entries[entries.length-1] > 6){
            throw new IllegalArgumentException("Values should be between 1 and 6.");
        }
    }

    /**
     * This method takes an array and a map derived from the array which has the integer key and a value that is the
     * count of the number of appearances of that key. This method also assumes that the array has been validated
     * (not null, no values out of range e.g value range is 1-6, not more than 6 values)
     * @param entries original Integer array to be scored
     * @param score Map derived from the original Integer array
     * @return boolean true if straight (1,2,3,4,5,6)
     */
    private static boolean isStraight(int[] entries, Map<Integer, Long> score){
        //if we have 6 entries in the map, then we have one of each number 1 to 6 as with count of 1
        return score.size() == 6 && entries.length == 6;
    }

    /**
     * Return the Map entry with the highest value. This method assumes that the map has already been correctly generated
     * @param score Map derived from the original Integer array
     * @return the Map.Entry with the hiqhest count e.g [1,2,3,1,1] -> {1:3}
     */
    public static Optional<Map.Entry<Integer, Long>> getMapEntryWithHighestCountOfSameNumber(Map<Integer, Long> score){
        //get the number with the highest count
        return score.entrySet().stream().max(Comparator.comparing(a -> a.getValue()));
    }

    /**
     * Returns true if the array to be scored contains 3 pairs e.g [2,2,3,3,4,4], [1,1,3,3,6,6] etc
     * @param entries original Integer array to be scored
     * @param score Map derived from the original Integer array
     * @return true if the array to be scored contains 3 pairs
     */
    public static boolean is3Pairs(int[] entries, Map<Integer, Long> score){
        //if we have 6 entries in the array and  a total of 3 elements in the map then we now we have 3 pairs
        return entries.length == 6 && score.size() == 3 && getMapEntryWithHighestCountOfSameNumber(score).get().getValue() == 2;
    }





}
