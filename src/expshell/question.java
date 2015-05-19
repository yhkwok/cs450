/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;

/**
 *
 * @author YH Jonathan Kwok
 */
public class question {
    double min;
    double max;
    
    public bool inBoundary(double val){
        if (min <= val)
            if (max > val)
                return true;
        return false;
    }
}
