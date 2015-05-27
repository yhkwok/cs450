/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import weka.core.Instance;

/**
 *
 * @author YH Jonathan Kwok
 */
public class NeuralClass {
    
    public static void main(String[] args) throws Exception {
        Instance testInst = new Instance(5);
        testInst.setValue(0, 2.1);
        testInst.setValue(1, 3.1);
        testInst.setValue(2, 4.1);
        testInst.setValue(3, 5.1);
        //the class
        testInst.setValue(4, 0.0);
        
        Layer l = new Layer(5,testInst.numAttributes() - 1);
        
        l.computeNode(testInst);
        
    }
    
}
