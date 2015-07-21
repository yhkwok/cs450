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

   public double forward(Instance inst) {
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

   public void backward(){
      //first, start with the output layer
      List<Double> outputLayerErrors = new ArrayList<Double>();
      //go through the nodes in the last layer
      Layer lastLayer = layers.get(layers.size() - 1);
      for (int i = 0; i < lastLayer.nodes.size(); i++)
      {
         double a = lastLayer.lastOutput.get(i);
         double err = a * (1 - a) * (a - a/*target value*/);
         outputLayerErrors.add(err);
      }

      Layer leftLayer = layers.get(layers.size() - 2);
      //List of weights between output layer and the left layer of it
      List<Double> newWeightListForLastLayer = new ArrayList<Double>();
      for (int i = 0; i < leftLayer.nodes.size(); i++)
      {
         List<Double> targetWeightList = (leftLayer.nodes.get(i)).weights;
         for(int j = 0; j < lastLayer.nodes.size(); j++)
         {
            for (int k = 0; k < targetWeightList.size(); k++)
            {
               double newWeight = targetWeightList.get(k) - (.2) 
                       * (outputLayerErrors.get(j)) * (leftLayer.lastOutput.get(i));
               newWeightListForLastLayer.add(newWeight);
            }
         }
      }

      

      //continue with earlier layers
      for (int i = layers.size() - 2; i >= 0; i--)
      {
         
      }
      
   }
   
   public double run(Instance inst) {
      double theReturn;
      theReturn = forward(inst);
      backward();
      
      
      
      return theReturn;
   }    
}
