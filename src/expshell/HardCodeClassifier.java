/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author YH Jonathan Kwok
 */
public class HardCodeClassifier extends Classifier {
    
    @Override
    public void buildClassifier(Instances data) throws Exception {
    }
    
    @Override
    public double classifyInstance(Instance i) {
        return 0;
    }
}
