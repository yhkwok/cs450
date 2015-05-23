/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YH Jonathan Kwok
 */
public class Layer {
    List<Neural> nodes = new ArrayList<Neural>();
    public Layer(int numNodes, int numInputs){
        //create and assign some valuse into a list of Double
        List<Double> nums = new ArrayList<Double>();
        for (double i = 0; i < numInputs; i++)
            nums.add(i);
        
        //create nodes by putting list of values in, and add this node into the node list
        for (int i = 0; i < numNodes; i++)
        {
            Neural node = new Neural(nums);
            nodes.add(node);
        }
    }
}
