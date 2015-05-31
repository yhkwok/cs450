/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import java.util.ArrayList;
import java.util.List;
import weka.core.Instance;

/**
 *
 * @author YH Jonathan Kwok
 */
public class NeuralNetwork {
    List<Layer> layers = new ArrayList<Layer>();
    List<Double> output = new ArrayList<Double>();
    int numLayers;
    List<Integer> lONumNodes;
    public NeuralNetwork(int numLayers, int numInputs, List<Integer> lONumNodes){
        this.numLayers = numLayers;
        this.lONumNodes = lONumNodes;
        
        //set up the whole network, put layers into a list
        Layer temp = new Layer(lONumNodes.get(0), numInputs);
        layers.add(temp);
        for (int i = 1; i < numLayers; i++)
        {
            temp = new Layer(lONumNodes.get(i), lONumNodes.get(i - 1));
            layers.add(temp);
        }        
    }
    
    public double run(Instance inst) {
        output = (layers.get(0)).computeNode(inst);
        for (int i = 1; i < numLayers; i++) {
            output = (layers.get(i)).computeDouble(output);
        }
        
        double low = 50;
        double index = 0;
        double targetIndex = 0;
        for (double temp : output)
        {            
            if (temp < low)
            {
                low = temp;
                targetIndex = index;
            }
            index++;
        }        
        return targetIndex;
    }    
}
