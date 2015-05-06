/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author YH Jonathan Kwok
 */
public class KNN extends Classifier{
    Integer k = 8;
    Instances data;
        
    @Override
    public void buildClassifier(Instances i) throws Exception {
        data = i;
    }
    
    @Override
    public double classifyInstance(Instance instance) throws Exception{
        //Sort by using TreeMap
        Map<Integer, Double> distances = new TreeMap<>();
        int distance = 0;    
        
        //go through the data and find hte distance
        for (int i = 0; i < data.numInstances(); i++){
            for (int j = 0; i < data.numAttributes(); j++){
                //the Manhattan distance
                distance += abs((int)(data.instance(i).value(j) - instance.value(j)));
            }
            distances.put(distance, data.instance(i).classValue());
            distance = 0;
        }
        
        //find the nearest neighbor's major class
        int count = 0;
        double tempClass;
        
        int tally[] = new int [data.numClasses()];
        // comment...
        for (Map.Entry<Integer, Double> entry : distances.entrySet()){
            if(count >= k)
                break;
            tempClass = entry.getValue();
            tally[(int)tempClass]++;
            count++;
        }
        
        int maxIndex = 0;
        int majority;
        for(int i = 0; i < data.numClasses(); i++){
            majority = tally[i];
            if (majority > tally[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
      
}
