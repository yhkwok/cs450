/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import java.util.ArrayList;
import java.util.List;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author YH Jonathan Kwok
 */
public class NeuralClassifier extends Classifier{
    NeuralNetwork nn = null;
    @Override
    public void buildClassifier(Instances i) throws Exception {
        List<Integer> numNodes = new ArrayList<Integer>();
        //numNodes.add(5);
        //numNodes.add(6);
        numNodes.add(i.numClasses());
        
        nn = new NeuralNetwork(numNodes.size(), i.numAttributes() - 1, numNodes);
        for (int j = 0; j < i.numInstances(); j++) {
            System.out.println(nn.run(i.instance(j)));
        } 
        
    }
    
    @Override
    public double classifyInstance(Instance i) {
        return nn.run(i);
    }
    
}
