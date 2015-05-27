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
public class Layer {
    List<Neural> nodes = new ArrayList<Neural>();
    public Layer(int numNodes, int numAtt){
        //create and assign some valuse into a list of Double
                
        //create nodes by putting list of values in, and add this node into the node list
        for (int i = 0; i < numNodes; i++)
        {
            Neural node = new Neural(numAtt);
            nodes.add(node);
        }
        
    }
    
    public void computeNode(Instance ins){
        for (Neural temp : nodes)
        {
            System.out.println(temp.cal(ins));
        }
    }       
    }