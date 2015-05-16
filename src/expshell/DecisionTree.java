/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import static java.lang.Math.log;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import static weka.core.Utils.log2;

/**
 *
 * @author YH Jonathan Kwok
 */
public class DecisionTree extends Classifier{
    private Instances data;
    
    @Override
    public void buildClassifier(Instances data) throws Exception {
        this.data = data;
    }
    
    @Override
    public double classifyInstance(Instance i) {
        //I Know Nothing !!!!!!!!!!!!!!!!!!!!!!!!!!!
        return -1;
    }
    
    public double calEntropy(double a, double b){
        double entropy;
        double whole = a + b;
        entropy = (a/whole)*log2(a/whole) - (b/whole)*log2(b/whole);
        return entropy;
    }
    
}
