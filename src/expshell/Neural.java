/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;
import weka.core.Debug.Random;
import weka.core.Instance;

/**
 *
 * @author YH Jonathan Kwok
 */
public class Neural {
    
   // List<Double> values = new ArrayList<Double>();
    List<Double> weights = new ArrayList<Double>();
    double randMin = 0.1;
    double randMax = 5.0;
    
    public Neural(int numInputs){
        //values = vals;
        //add the bias input at the end
        //values.add(-1.0);
        //set the weights according to the size of the values we have
        setWeights(numInputs);
    }
    
    public void setWeights(int numAtt){
        for(int i = 0; i < numAtt + 1; i++)
        {
            Random r = new Random();
            double randomValue = randMin + (randMax - randMin) * r.nextDouble();
            weights.add(randomValue);
        }
    }   
    
    public double cal(Instance ins){
        double sum = 0;
        sum += -1 * weights.get(0);
        for(int i = 1; i < weights.size(); i++)
        {
            sum += ins.value(i - 1) * weights.get(i);
        }
        //if (sum > 0)
        //    return 1.0;
        return threshold(sum);
    }
    
    public double calDouble (List<Double> lD){
        double sum = 0;
        sum += -1 * weights.get(0);
        for(int i = 1; i < weights.size(); i++)
        {
            sum += lD.get(i - 1) * weights.get(i);
        }
        return threshold(sum);
    }
    public double threshold(double sum){
        return 1 / (1 + pow(Math.E, -sum));
    }
}
