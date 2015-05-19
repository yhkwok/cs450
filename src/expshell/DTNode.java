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
public class DTNode {
    List<DTNode> children = new ArrayList<DTNode>();
    
    double classification = -1;
    //question
    
    public void addChild(DTNode aNode){
        children.add(aNode);
    }
    
    public void removeChild(DTNode aNode){
        children.remove(aNode);
    }
    
    public DTNode getChild(int index){
        return children.get(index);
    }   
    
}
