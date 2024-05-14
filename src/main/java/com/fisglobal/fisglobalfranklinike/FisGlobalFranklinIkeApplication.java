package com.fisglobal.fisglobalfranklinike;

import com.fisglobal.fisglobalfranklinike.game.DiceGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FisGlobalFranklinIkeApplication {

    public static void main(String[] args) {

        SpringApplication.run(FisGlobalFranklinIkeApplication.class, args);

        DiceGame scorer = new DiceGame();

        System.out.println("{1, 2, 3, 1, 1} = "  + scorer.score(new int[]{1, 2, 3, 1, 1}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("A single one (100) {1} = "  + scorer.score(new int[]{1}));
        System.out.println("A single one (100) {1,2} = "  + scorer.score(new int[]{1,2}));
        System.out.println("A single one (100) {1,2,3} = "  + scorer.score(new int[]{1,2,3}));
        System.out.println("A single one (100) {1,2,3,4} = "  + scorer.score(new int[]{1,2,3,4}));
        System.out.println("A single one (100) {1,2,3,4,6} = "  + scorer.score(new int[]{1,2,3,4,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("A single five (50) {5} = "  + scorer.score(new int[]{5}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Straight(1200) {1,2,3,4,5,6} = "  + scorer.score(new int[]{1,2,3,4,5,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Three Pairs(800) {2,2,3,3,4,4} = "  + scorer.score(new int[]{2,2,3,3,4,4}));
        System.out.println("Three Pairs(800) {1,1,2,2,3,3} = "  + scorer.score(new int[]{1,1,2,2,3,3}));
        System.out.println("Three Pairs(800) {5,5,4,4,3,3} = "  + scorer.score(new int[]{5,5,4,4,3,3}));
        System.out.println("Three Pairs(800) {1,1,3,3,5,5} = "  + scorer.score(new int[]{1,1,3,3,5,5}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {1,1,1,1,1,1} = "  + scorer.score(new int[]{1,1,1,1,1,1}));
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {2,2,2,2,2,2} = "  + scorer.score(new int[]{2,2,2,2,2,2}));
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {3,3,3,3,3,3} = "  + scorer.score(new int[]{3,3,3,3,3,3}));
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {4,4,4,4,4,4} = "  + scorer.score(new int[]{4,4,4,4,4,4}));
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {5,5,5,5,5,5} = "  + scorer.score(new int[]{5,5,5,5,5,5}));
        System.out.println("Six-of-a-kind (Multiply Triple Score by 8) {6,6,6,6,6,6} = "  + scorer.score(new int[]{6,6,6,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {1,1,1,1,1,3} = "  + scorer.score(new int[]{1,1,1,1,1,3}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {2,2,2,2,2,4} = "  + scorer.score(new int[]{2,2,2,2,2,4}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {3,3,3,3,3,6} = "  + scorer.score(new int[]{3,3,3,3,3,6}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {4,4,4,4,4,2} = "  + scorer.score(new int[]{4,4,4,4,4,2}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {5,5,5,5,5,3} = "  + scorer.score(new int[]{5,5,5,5,5,3}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) {6,6,6,6,6,2} = "  + scorer.score(new int[]{6,6,6,6,6,2}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) + 1 (100) {6,6,6,6,6,1} = "  + scorer.score(new int[]{6,6,6,6,6,1}));
        System.out.println("Five-of-a-kind (Multiply Triple Score by 4) + 5 (50) {6,6,6,6,6,5} = "  + scorer.score(new int[]{6,6,6,6,6,5}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {1,1,1,1,3,3} = "  + scorer.score(new int[]{1,1,1,1,3,3}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {2,2,2,2,4,4} = "  + scorer.score(new int[]{2,2,2,2,4,4}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {3,3,3,3,6,6} = "  + scorer.score(new int[]{3,3,3,3,6,6}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {4,4,4,4,2,2} = "  + scorer.score(new int[]{4,4,4,4,2,2}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {5,5,5,5,3,3} = "  + scorer.score(new int[]{5,5,5,5,3,3}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) {6,6,6,6,2,2} = "  + scorer.score(new int[]{6,6,6,6,2,2}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) + 1(100) {6,6,6,6,1,4} = "  + scorer.score(new int[]{6,6,6,6,1,4}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) + 5(50) {6,6,6,6,5,4} = "  + scorer.score(new int[]{6,6,6,6,5,4}));
        System.out.println("Four-of-a-kind (Multiply Triple Score by 2) + 1(100) + 5(50) {6,6,6,6,1,5} = "  + scorer.score(new int[]{6,6,6,6,1,5}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple ones [1,1,1] (1000) {1,1,1,2,3,4} = "  + scorer.score(new int[]{1,1,1,2,3,4}));
        System.out.println("Triple twos [2,2,2] (200) {2,2,2,3,4,6} = "  + scorer.score(new int[]{2,2,2,3,4,6}));
        System.out.println("Triple threes [3,3,3] (300) {3,3,3,2,4,6} = "  + scorer.score(new int[]{3,3,3,2,4,6}));
        System.out.println("Triple fours [4,4,4] (400) {4,4,4,2,3,6} = "  + scorer.score(new int[]{4,4,4,2,3,6}));
        System.out.println("Triple fives [5,5,5] (500) {5,5,5,6,4,2} = "  + scorer.score(new int[]{5,5,5,6,4,2}));
        System.out.println("Triple sixes [6,6,6] (600) {6,6,6,4,3,2} = "  + scorer.score(new int[]{6,6,6,4,3,2}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple ones [1,1,1] (1000) + Triple twos [2,2,2] (200) {1,1,1,2,2,2} = "  + scorer.score(new int[]{1,1,1,2,2,2}));
        System.out.println("Triple ones [1,1,1] (1000) + Triple threes [3,3,3] (300) {1,1,1,3,3,3} = "  + scorer.score(new int[]{1,1,1,3,3,3}));
        System.out.println("Triple ones [1,1,1] (1000) + Triple fours [4,4,4] (400) {1,1,1,4,4,4} = "  + scorer.score(new int[]{1,1,1,4,4,4}));
        System.out.println("Triple ones [1,1,1] (1000) + Triple fives [5,5,5] (500) {1,1,1,5,5,5} = "  + scorer.score(new int[]{1,1,1,5,5,5}));
        System.out.println("Triple ones [1,1,1] (1000) + Triple sixes [6,6,6] (600) {1,1,1,6,6,6} = "  + scorer.score(new int[]{1,1,1,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple twos [2,2,2] (200) + Triple threes [3,3,3] (300) {2,2,2,3,3,3} = "  + scorer.score(new int[]{2,2,2,3,3,3}));
        System.out.println("Triple twos [2,2,2] (200) + Triple fours [4,4,4] (400) {2,2,2,4,4,4} = "  + scorer.score(new int[]{2,2,2,4,4,4}));
        System.out.println("Triple twos [2,2,2] (200) + Triple fives [5,5,5] (500) {2,2,2,5,5,5} = "  + scorer.score(new int[]{2,2,2,5,5,5}));
        System.out.println("Triple twos [2,2,2] (200) + Triple sixes [6,6,6] (600) {2,2,2,6,6,6} = "  + scorer.score(new int[]{2,2,2,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple threes [3,3,3] (300) + Triple fours [4,4,4] (400) {3,3,3,4,4,4} = "  + scorer.score(new int[]{3,3,3,4,4,4}));
        System.out.println("Triple threes [3,3,3] (300) + Triple fives [5,5,5] (500) {3,3,3,5,5,5} = "  + scorer.score(new int[]{3,3,3,5,5,5}));
        System.out.println("Triple threes [3,3,3] (300) + Triple sixes [6,6,6] (600) {3,3,3,6,6,6} = "  + scorer.score(new int[]{3,3,3,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple fours [4,4,4] (400) + Triple fives [5,5,5] (500) {4,4,4,5,5,5} = "  + scorer.score(new int[]{4,4,4,5,5,5}));
        System.out.println("Triple fours [4,4,4] (400) + Triple sixes [6,6,6] (600) {4,4,4,6,6,6} = "  + scorer.score(new int[]{4,4,4,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple fives [5,5,5] (500) + Triple sixes [6,6,6] (600) {5,5,5,6,6,6} = "  + scorer.score(new int[]{5,5,5,6,6,6}));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Triple sixes [6,6,6] (600) + 1(100)  {6,6,6,1,3,2} = "  + scorer.score(new int[]{6,6,6,1,3,2}));
        System.out.println("Triple sixes [6,6,6] (600) + 5(50)  {6,6,6,5,3,2} = "  + scorer.score(new int[]{6,6,6,5,3,2}));
        System.out.println("Triple sixes [6,6,6] (600) + 1(100) + 5(50) {6,6,6,1,5,2} = "  + scorer.score(new int[]{6,6,6,1,5,2}));
    }

}
